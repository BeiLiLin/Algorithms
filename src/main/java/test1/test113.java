/*
    在命令行输入三个整数，判断是否都相等
 */
public class test113 {
public static void main(String[]args){
        String []Compare = new String[3];
       for (int i = 0;i<3;i++){
               Compare[i]=args[i];
       }
       if((Compare[0].equals(Compare[1])) && (Compare[0].equals(Compare[2])))
       {
               System.out.print("equal");
       }else{
           System.out.print("not equal");
       }
}
}
