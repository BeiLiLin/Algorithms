package Test;
/*
    运行时常量池相对于CLass文件常量池的另外一个重要特征是具备动态性，Java语言并不要求常量一定只有编译期才能产生，
    也就是并非预置入CLass文件中常量池的内容才能进入方法区运行时常量池，运行期间也可能将新的常量放入池中，
    这种特性被开发人员利用比较多的就是String类的intern()方法。
 */
public class StringIntern {
    public static void main(String []args){
        //String的intern()方法会查找在常量池中是否存在一份equal相等的字符串
        // 如果有则返回该字符串的引用,如果没有则添加自己的字符串进入常量池。
        String s1 = new String("计算机");
        String s2 = s1.intern(); //将计算机加入常量池,并将常量池的值赋值给s2
        String s3 = "计算机";
        System.out.println("s1 == s2? " + (s1 == s2)); //false
        System.out.println("s3 == s2? " + (s3 == s2));//true


    }
}
