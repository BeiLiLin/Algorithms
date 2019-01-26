package Test;
/*
   当两个包装类进行比较时：
   1：  Integer a1 = new Integer(1);
        Integer a2 = new Integer(1);
        a1 != a2
   2:   Integer b1 = 1;
        Integer b2 = 1;
        b1 == b2;
        //默认创建了数值[-128，127]的相应类型的缓存数据，超出范围仍然会创建新的对象
        Integer e1 = 129;
        Integer e2 = 129;
        e1  != e2
   3:   Integer c1 = new Integer(1);
        int c2 = 1;
        c1 == c2;
   4:  Integer d1 = new Integer(1);
        int d2 = new Integer(1);
        d1 == d2;
 */
public class IntegerAndIntTest1 {
    public static void main(String []args){
        //创建两个新的对象，地址不相等
        Integer a1 = new Integer(1);
        Integer a2 = new Integer(1);
        System.out.println("1:"+(a1== a2));

        //会从constant pool 中的Integer pool 量池中拿对象（默认创建了数值[-128，127]的相应类型的缓存数据，超出范围仍然会创建新的对象），所以地址相等
        Integer b1 = 1;
        Integer b2 = 1;
        System.out.println("2.1:"+(b1== b2));
        //这5种包装类默认创建了数值[-128，127]的相应类型的缓存数据，但是超出此范围仍然会去创建新的对象。常量池不会增加，依旧是缓存[-128，127]的相应类型的缓存数据
        Integer e1 = 129;
        Integer e2 = 129;
        System.out.println("2.2:"+(e1== e2));
        Integer e3 = 129;
        Integer e4 = 129;
        System.out.println("2.3:"+(e3== e4));

        //包装类和基本数据类型比较时，java会将包装类自动拆包装为基本类型，然后进行比较，实际上就变为两个基本类型的比较
        Integer c1 = new Integer(1);
        int c2 = 1;
        System.out.println("3:"+(c1== c2));

        //包装类和基本数据类型比较时，java会将包装类自动拆包装为基本类型，然后进行比较，实际上就变为两个基本类型的比较
        Integer d1 = new Integer(1);
        int d2 = new Integer(1);
        System.out.println("4.1:"+(d1== d2));
        //包装类和基本数据类型比较时，java会将包装类自动拆包装为基本类型，然后进行比较，实际上就变为两个基本类型的比较
        Integer w1 = new Integer(130);
        int w2 = new Integer(130);
        System.out.println("4.2:"+(w1== w2));


    }
}
