package interview.ThreadPoolExecutorTest.SynchronizedTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//同步的条件，调用同一个对象锁,使用同步对象同步
class C {
    public static int count = 0;
    private char[] word = new char[]{'h','e','l','l','o',',','w','o','r','l','d','!'};
    public  void PrintWord(){
     System.out.println(word[count++]);
    }
}

class MTask2 implements Runnable{
    C c ;
    MTask2(C c){
        this.c = c;
    }
    @Override
    public void run() {
        System.out.println("当前运行的线程"+Thread.currentThread().getId());
        synchronized (c){
            c.PrintWord();
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Test4 {
    public static void main(String []args){

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(10,15,200,
                        TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        C c = new C();//调用同一个对象锁
        MTask2 task = new MTask2(c);
        for (int i =0; i<12;i++){

            executor.execute(task);
        }
    }
}

