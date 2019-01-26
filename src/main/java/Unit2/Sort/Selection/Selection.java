package Unit2.Sort.Selection;

import edu.princeton.cs.algs4.StdOut;;

import java.util.Scanner;

public class Selection{
    //排序算法
    public static void sort(Comparable[] a ){
        int N = a.length;//数组长度
        for (int i = 0; i<N; i++){
          //将a[i]和a[i+1...N]中最小的元素交换
          int min = i;
          //选出a[i+1...N]中小于a[i]的最小元素
          for (int j = i+1;j<N;j++)
              if(less(a[j],a[min]))
                  min=j;
          exch(a,i,min);
        }
    }
    /*
        v.compareTo(w)比较v,w两个数的大小，
        v.compareTo(w){
            v>w     返回1；
            v<W     返回-1；
            v=w     返回0
        }
    */
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    //交换元素
    public static void exch(Comparable[] a,int i ,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    //输出数组
    public static void show(Comparable []a){
        for (int i = 0;i<a.length;i++)
            StdOut.print(a[i]+" ");
        StdOut.println();
    }
    //测试数组是否有序
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i<a.length; i++)
            //升序排序，出现右边的小于左边的数则数组无序
            if(less(a[i],a[i-1]))
                return false;
        return true;
    }
    public static void main(String []args){
        //从标准输入读取字符串，将他们排序并输出
        StdOut.println("请输入排序的数组字符串，每个数组元素用,号隔开：");
        Scanner sc =new Scanner(System.in);
        String []a  = sc.next().split(",");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
