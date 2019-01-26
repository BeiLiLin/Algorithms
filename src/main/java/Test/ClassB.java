package Test;

public class ClassB extends ClassA {
    {
        System.out.println("I class B");
    }
    public ClassB(){
        System.out.println("ClassB");
    }
    static {
        System.out.println("static B");
    }
    public  static  void  main(String []args){
        new ClassB();
        Float szx = 0.12f;
        System.out.println(szx);
        float s=0.12f;
        System.out.println(s);
        String str1 = new String("hello");
        String str2 = new String("hello");
        char[] char1=new char[]{'h','e','l','l','o','\0'};
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(char1));
        System.out.println(str2.equals(new String("hello")));

        Double dl = 0.01141;
        double dl1  = 0.01141;

    }
}
