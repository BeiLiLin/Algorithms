package nio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NioClient {
    private final ByteBuffer sendBuffer=ByteBuffer.allocate(1024);
    private final ByteBuffer receiveBuffer=ByteBuffer.allocate(1024);
    private Selector selector;
    private SocketChannel socketChannel;

    public NioClient()throws IOException{
        //开启
        this.socketChannel = SocketChannel.open();
        this.socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(),6565));
        this.socketChannel.configureBlocking(false);
        System.out.println("连接建立成功");
        //开启选择器
        this.selector=Selector.open();
        //注册选择器
        this.socketChannel.register(selector,SelectionKey.OP_READ);
        //监听是否有新事件
        while (selector.select() > 0 ){
            //遍历新事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                    SelectionKey key = it.next();
                    it.remove();
                    //如果存在可读事件，<服务器发送消息过来>
                    if (key.isReadable()) {
                        receive(key);
                    }
            }

        }
    }

    public static void main(String[] args) throws Exception{
        final NioClient client=new NioClient();
        Thread sendMsg=new Thread(client::sendInputMsg);
        sendMsg.start();

        client.start();
    }

    private void start()throws IOException {

    }

    /**
     * 接收服务端发送的内容
     * @param key
     * @throws IOException
     */
    private void receive(SelectionKey key)throws IOException{
        SocketChannel socketChannel=(SocketChannel)key.channel();
        socketChannel.read(receiveBuffer);
        receiveBuffer.flip();
        String receiveData= Charset.forName("UTF-8").decode(receiveBuffer).toString();

        System.out.println("receive server message:"+receiveData);
        receiveBuffer.clear();
    }

    /**
     * 发送控制台输入内容至服务器
     */
    private void sendInputMsg() {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        try{
            String msg;
            while ((msg = bufferedReader.readLine()) != null){
                synchronized(sendBuffer){
                    sendBuffer.put((msg+"\r\n").getBytes());
                    //在写模式下调用flip()之后，Buffer从写模式变成读模式
                    //发送之前将数据改为读模式
                    sendBuffer.flip();
                    while(sendBuffer.hasRemaining()){
                        socketChannel.write(sendBuffer);
                    }
                    /*
                    我们在 write 后，执行 buffer.compact()将没有发出的数据复制到 buffer
                    的开始位置，posittion = limit-position,limit = capacity,这样在下一次
                    read(buffer)的时候，数据就会继续添加到缓冲的后面了
                     */
                    sendBuffer.compact();

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
