package Test;
class  Coffee2{
    enum CoffeeSize {BIG,HUGE,OVERWHELMING}
    CoffeeSize size;
}
public class CoffeeTest2 {
  public static  void main(String[]args){
      Coffee2 coffee2 = new Coffee2();
      coffee2.size = Coffee2.CoffeeSize.BIG;
  }
}
