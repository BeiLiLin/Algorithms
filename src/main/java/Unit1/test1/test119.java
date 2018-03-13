package Unit1.test1;

import template.StdOut;

import java.util.Scanner;
/*
    将十进制转化为二进制
 */
public class test119 {
    public static  void  main(String[]args){
        Scanner sc = new Scanner(System.in);
        StdOut.println("请输入一个正整数：");
        int N = sc.nextInt();
        String x ="";
       /* //方法一
        x = Integer.toBinaryString(N);
        */
        //方法二
        for (int n =N;n>0;n /= 2)//2除取余，逆序排序
        {
            x=(n%2)+x;
        }
        StdOut.println(x);
    }
}
