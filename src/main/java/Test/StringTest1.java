package Test;
/*
    连接表达式 +
（1）只有使用引号包含文本的方式创建的String对象之间使用“+”连接产生的新对象才会被加入字符串池中。
（2）对于所有包含new方式新建对象（包括null）的“+”连接表达式，它所产生的新对象都不会被加入字符串池中

 *特例一：A和B都是常量，值是固定的，因此s的值也是固定的，它在类被编译时就已经确定了。
            也就是说：String s=A+B; 等同于：String s="ab"+"cd";
 *特例二：A和B虽然被定义为常量，但是它们都没有马上被赋值。在运算出s3的值之前，他们何时被赋值，以及被赋予什么样的值，都是个变数。
 *          因此A和B在被赋值之前，性质类似于一个变量。那么s就不能在编译期被确定，而只能在运行时被创建了。
 */
public class StringTest1 {
    public static final String A = "ab";// static final修饰的变量相当于常量
    public static final String B ="cd";

    public static final String C; // 常量A 没有立即赋值，系统会将这两个常量看成变量，所以s3的值无法在编译时赋值，所以会在运行时创建新的对象，而不是在常量池中拿常量
    public static final String D;    // 常量B
    static {
        C = "ab";
        D = "cd";
        System.out.println("赋值");
    }
    //不会被执行
    {
        System.out.println("代码块");
    }
    public static void main(String []args){
        System.out.println("main");
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";//加入字符串池
        String str4 = str1 + str2;//不会加入字符串池
        System.out.println(str3 == str4);//false
        String str5 = "string";
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false

        //特例一：
        String s1 = A+B;
        String s2 = "abcd";
        System.out.println("s1 == s2:");
        System.out.println(s1 == s2);

        //特例二：
        System.out.println("s3进行赋值");
        String s3 = C+D;
        String s4 = "abcd";
        System.out.println("s3 == s4:");
        System.out.println(s3 == s4);
    }
}
