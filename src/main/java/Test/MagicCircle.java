package Test;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Scanner;
/*
    腾讯笔试——魔法阵  判断一个四边形是否是一个正方形
    给定四个点，能构成正方形输出Yes，否则输出No。
 */
/*
    输入数据：
            3
        0 0 2 2
        0 2 0 2
        0 1 5 6
        1 6 0 5
        0 0 7 7
        0 3 0 3
 */
/*
    解题思路：
    1.先求出6条边的长度
    2.判断是否分别有4条相同的边(判断是否为菱形)
    3.再判断两条边与对角线满足勾股定理（判断有直角）
 */
public class MagicCircle {
    //计算两点间的距离
    public static double  distance(int x1,int y1,int x2,int y2){
        double a;
        a=Math.pow((x1-x2),2.0)+Math.pow((y1-y2),2.0);//pow计算一个数的n次幂。sqrt解幂
        return a;
    }
    public static void main(String[] args){
        Stopwatch timer = new Stopwatch();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个(1<= t<= 5)的整数,表示有t组数据 ");
        int N;
        if(sc.hasNext())    N=sc.nextInt();
        else                return;
        int [] x = new int[4];//存放x轴
        int [] y = new int[4];//存放y轴

        for ( int i=0;i<N;i++)//N组数据的循环
        {
            //获取数据
            System.out.println("请输入第一行数据 ");
            int k=0;
            while (true)
            {
                if (k ==4)  break;
                if ((sc.hasNext()))     x[k++] =sc.nextInt();

            }
            System.out.println("请输入第二行数据");
            k=0;
            while (true)
            {
                if (k ==4)  break;
                if (sc.hasNext())       y[k++] =sc.nextInt();
            }
            double side[] = new double[6];
            side[0] = distance(x[0],y[0],x[1],y[1]);
            side[1] = distance(x[0],y[0],x[2],y[2]);
            side[2] = distance(x[0],y[0],x[3],y[3]);
            side[3] = distance(x[1],y[1],x[2],y[2]);
            side[4] = distance(x[1],y[1],x[3],y[3]);
            side[5] = distance(x[3],y[3],x[2],y[2]);
            int sum1=1,sum2=0;
            double j=0.0;//存放边或者对角线
            double d=0.0;//存放边或者对角线
            j = side[0];
           for (k=1;k<6;k++){
               if (side[0] ==side[k])
               {
                   sum1++;
               }else{
                   sum2++;
                   if (d==0.0)    d = side[k];//给d赋值
               }
           }
            if (sum1 == 4 && sum2 == 2){//side[0]为边
//                System.out.println("此时j数据存放边，d数据存放对角线");
               //根据勾股定理判断是否有一个直角，此时j数据存放边，d数据存放对角线
                if (j*2 == d){
                    System.out.println("yes");
                    continue ;
                }else{
                    System.out.println("no");
                    continue;
                }
            }else if(sum1 == 2 && sum2 ==4){//side[0]为对角线
//                System.out.println("此时d数据存放边，j数据存放对角线");
                //根据勾股定理判断是否有一个直角，此时d数据存放边，j数据存放对角线
                if (d*2 == j){
                    System.out.println("yes");
                    continue ;
                }else{
                    System.out.println("no");
                    continue ;
                }
            } else{
                System.out.println("no");
                continue ;
            }
        }
        System.out.println("运行时间 "+timer.elapsedTime());
    }
}
