package nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    public void serve(int port) throws IOException {
        //开启ServerChannel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        //设置ServerChannel不阻塞
        serverChannel.configureBlocking(false);
        //获取socket
        ServerSocket serverSocket = serverChannel.socket();
        //绑定端口
        InetSocketAddress address = new InetSocketAddress(port);
        serverSocket.bind(address);
        //打开Selector处理channel
        Selector selector = Selector.open();
        //注册ServerSocket到Selector,并设置感兴趣的内容
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        //定义发送信息
        final ByteBuffer msg = ByteBuffer.wrap("hi!\r\n".getBytes("UTF-8"));
        //
        for (;;){
            try {
                //等待需要处理的新事件；阻塞将只持续到下一个传入事件
                selector.select();
            }catch (IOException e){
                e.getStackTrace();
                break;
            }
            //遍历新事件
            Set<SelectionKey> readKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    // 新连接
                    if (key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        // 获取一个新注册的channel
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        //将新注册的客户端加到selector中
                        client.register(selector,SelectionKey.OP_WRITE|SelectionKey.OP_READ,msg.duplicate());
                        System.out.println("Accepted connection from "+client);
                    }else if (key.isReadable()){//客户端有可读数据
                        SocketChannel client = (SocketChannel)key.channel();
                        ByteBuffer readBuffer = ByteBuffer.allocateDirect(1024);
                        readBuffer.clear();
                        client.read(readBuffer);
                        readBuffer.flip();
                        String receiveData= Charset.forName("UTF-8").decode(readBuffer).toString();
                        System.out.println("receiveData:"+receiveData);
                    }else if (key.isWritable()){//发送数据到客户端
                        SocketChannel client = (SocketChannel)key.channel();
                        ByteBuffer buffer = (ByteBuffer)key.attachment();
                        while (buffer.hasRemaining()){
                            if (client.write(buffer) == 0){
                                break;
                            }
                        }
                    }
                }catch(IOException e){
                    e.getStackTrace();
                    key.cancel();
                }
            }
        }
    }
    public static void main(String[] args) {
        NioServer server = new NioServer();
        try {
            server.serve(6565);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
