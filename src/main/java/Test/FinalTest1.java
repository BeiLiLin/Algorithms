package Test;

 public final class FinalTest1 {
     private  String a;

     public String getA() {
         return a;
     }

     public void setA(String a) {
         this.a = a;
     }

     public void a1(){
         System.out.println("a"+a);
     }
     public static void main(String[]args){
         FinalTest1 finalTest1 = new FinalTest1();
         finalTest1.setA("aa");
         finalTest1.a1();
         //对象数组可以存放对象的子类
         ClassA [] c = new ClassA[4];
         ClassB a = new ClassB();
         c[0] = a;
     }
}
