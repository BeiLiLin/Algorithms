package Test;
/*
    继承时，父类子类的代码块、静态代码块、构造函数的执行先后顺序
    A:父类：
    B：父类
 */
public class ClassA {
    {
        System.out.println("I class A");
    }
    public ClassA(){
        System.out.println("ClassA");
    }
    static {
        System.out.println("static A");
    }
}
