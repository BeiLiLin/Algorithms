package Test;

class Test1 implements Runnable{
    private SynchronizedTest synchronizedTest;
    public Test1(SynchronizedTest t){
        synchronizedTest = t;
    }
    @Override
    public void run() {

        synchronizedTest.a();
    }
}
class Testss implements Runnable{
    private SynchronizedTest synchronizedTest;
    public Testss(SynchronizedTest t){
        synchronizedTest = t;
    }
    @Override
    public void run() {
        synchronizedTest.b();
    }
}
public class SynchronizedTest {
    public synchronized void a(){
        for (int i = 0;i<5;i++){
            System.out.println("a");
        }

    }
    public synchronized void b(){
        for (int i = 0;i<5;i++){
            System.out.println("b");
        }

    }
    public static void main(String[]args){
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Thread thread1 = new Thread(new Test1(synchronizedTest));
        Thread thread2 = new Thread(new Testss(synchronizedTest));
        Thread thread3 = new Thread(new Testss(synchronizedTest));
        Thread thread4 = new Thread(new Test1(synchronizedTest));
        Thread thread5 = new Thread(new Testss(synchronizedTest));
        Thread thread6 = new Thread(new Test1(synchronizedTest));
        thread1.start();thread2.start();thread3.start();
        thread4.start();thread5.start();thread6.start();
    }
}
