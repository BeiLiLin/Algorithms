package Test;
/*
    枚举类型的类外申声明
 */
enum CoffeeSize{BIG,HUGE,OVERWHELMING}
class Coffee{
    CoffeeSize size;
}
public class CoffeeTest1 {
    public static  void main(String []args){
        Coffee coffee = new Coffee();
        coffee.size = CoffeeSize.BIG;
    }
}
