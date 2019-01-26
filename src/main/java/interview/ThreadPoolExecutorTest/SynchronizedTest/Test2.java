package interview.ThreadPoolExecutorTest.SynchronizedTest;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//同步的条件，调用同一个对象锁，使用同步方法同步

class A {
    public static int count = 0;
    private char[] word = new char[]{'h','e','l','l','o',',','w','o','r','l','d','!'};
    public synchronized void PrintWord(){
        System.out.println(word[count++]);
    }
}

class MTask implements Runnable{
    A a ;
    MTask(A a){
        this.a = a;
    }
    @Override
    public void run() {
            System.out.println("当前运行的线程"+Thread.currentThread().getId());
            a.PrintWord();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
public class Test2 {
    public static void main(String []args){
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(10,15,200,
                        TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        A a = new A();//调用同一个对象锁
        MTask task = new MTask(a);
        for (int i =0; i<12;i++){
            executor.execute(task);
        }
    }
}
