package Unit2.Sort.QuitSort;

import edu.princeton.cs.algs4.StdOut;;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

public class Quick {
    //快速排序算法
    public static void sort(Comparable[] a ){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a,int lo,int hi ){
        if(hi <= lo) return ;
        int j = partition(a,lo,hi);//返回一个切分点
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    public static int partition(Comparable[] a,int lo,int hi ){
        //将数组切分为a[lo--i-1],a[i]，a[i+1]....hi]
        int i= lo,j=hi+1;
        Comparable v = a[lo];
        while(true){
            //扫描左右，检查扫描是否结束并交换元素
            while(less(a[++i],v))   if (i ==hi)    break;//到尾部跳出循环
            while(less(v,a[--j]))   if(j == lo)    break;//到头部跳出循环
            if (i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
        // }
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
        Scanner sc =new Scanner(System.in);
        String []a  = sc.next().split(",");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
