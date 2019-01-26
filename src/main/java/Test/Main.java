package Test;

import java.util.Scanner;

/*

 */
public class Main {
    public static  void main(String []args){
        Scanner sc = new Scanner(System.in);
        int i;
        int m =sc.nextInt();
        int n =sc.nextInt();
        if(!((2*m)%n ==0 && n>=2 && n<=1000000000 && m>=1))     return;
        int sum =0;
        int count =n;
        int flag=1;
        for (i=1;i<m+1;i++){
            if (flag==1)
            {
                sum -= i;
                if (--count==0)     flag=0;
            } else if (flag ==0){
                sum += i;
                if (++count==n)     flag=1;
            }
        }
        System.out.println(sum);
    }
}