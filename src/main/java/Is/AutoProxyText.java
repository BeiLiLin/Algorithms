package Is;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject{
    public void say(String name,int age);
}
class RealSub implements Subject{

    @Override
    public void say(String name, int age) {
        System.out.println(name +"-"+age);
    }
}
class MyInvocationHandler implements InvocationHandler{
    private Object obj = null;

    public Object bind(Object obj){
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling"+method);
        Object temp = method.invoke(this.obj,args);
        System.out.println("after calling"+method);
        return temp;
    }
}
public class AutoProxyText {
    public static void main(String []args){
    //如果想要完成动态代理，首先需要定义一个InvocationHandler接口的子类，已完成代理的具体操作。
    //实例化一个代理类对象
    MyInvocationHandler demo = new MyInvocationHandler();
    //通过Bind方法实例化RealSub的一个实例对象
    Subject subject = (Subject)demo.bind(new RealSub());
    System.out.println("----");
    //调用该代理对象的方法
    subject.say("dd",1);
    }
}
