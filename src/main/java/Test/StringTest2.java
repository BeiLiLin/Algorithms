package Test;

public class StringTest2 {
    public static void main(String[] args) {
        String hello = "Hello", lo = "lo";
        //在同包同类下,引用自同一String对象.
        System.out.println((hello == "Hello") + " ");
        //在同包不同类下,引用自同一String对象.
        System.out.println((Other.hello == hello) + " ");
        //在不同包不同类下,依然引用自同一String对象.
        System.out.println((other.Other.hello == hello) + " ");
        //在编译成.class时能够识别为同一字符串的,自动优化成常量,引用自同一String对象.
        System.out.println((hello == ("Hel"+"lo")) + " ");
        //在运行时创建的字符串具有独立的内存地址,所以不引用自同一String对象.
        System.out.println((hello == ("Hel"+lo)) + " ");
        System.out.println(hello == ("Hel"+lo).intern());
    }
}
class Other {
    static String hello = "Hello";
}

