package interview.ThreadPoolExecutorTest.SynchronizedTest;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//同步的条件，调用同一个对象锁,使用同步代码块同步
    class B {
        public static int count = 0;
        private char[] word = new char[]{'h','e','l','l','o',',','w','o','r','l','d','!'};
        public  void PrintWord(){
            synchronized (this){
                System.out.println(word[count++]);
            }
        }
    }

    class MTask1 implements Runnable{
    B b ;
    MTask1(B b){
        this.b = b;
    }
    @Override
    public void run() {
        System.out.println("当前运行的线程"+Thread.currentThread().getId());
        b.PrintWord();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Test3 {
        public static void main(String []args){

            ThreadPoolExecutor executor =
                    new ThreadPoolExecutor(10,15,200,
                            TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
           B b = new B();//调用同一个对象锁
            MTask1 task = new MTask1(b);
            for (int i =0; i<12;i++){
                executor.execute(task);
            }
        }
}
