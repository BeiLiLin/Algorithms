package test1;

import template.StdOut;

import java.util.Scanner;
/*
    Scanner函数的使用
 */
public class ScannerTest {
    public static void main(String [] args){
       double x , y;
        Scanner sc = new Scanner(System.in);
        StdOut.println("请输入双精度浮点数x的值：");
        x = sc.nextDouble();
        System.out.print("请输入双精度浮点数y的值：");
        y = sc.nextDouble();
        if(((x-1)<0&&(x>0))&&((y-1)<0&&(y>0))){
            System.out.print("true");
        }else{
            System.out.print("false");
        }
    }
}
