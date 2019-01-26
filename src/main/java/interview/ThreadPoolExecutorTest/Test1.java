package interview.ThreadPoolExecutorTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
class MyTask implements Runnable{
    private int tasknum;
    public MyTask(int num){
        tasknum = num;
    }
    @Override
    public void run() {
        System.out.println("正在执行的task"+tasknum);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task"+tasknum+"执行完毕");
    }
}
public class Test1 {
    public static void main(String []args){
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5,10,10,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        for (int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程的数目"+executor.getPoolSize()+"队列中等待执行的任务数目"+executor.getQueue().size()+
            "已执行玩别的人物数目"+executor.getCompletedTaskCount());
        }
        executor.shutdown();
        System.out.println(executor.getKeepAliveTime(TimeUnit.SECONDS));
    }
}
