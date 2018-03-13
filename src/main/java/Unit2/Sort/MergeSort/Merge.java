package Unit2.Sort.MergeSort;

import template.StdOut;

import java.util.Scanner;
/*
 自顶向下的归并排序
 */
public class Merge {
    private static Comparable[] aux;
    //排序算法
    public static void sort(Comparable[] a ){
        aux = new Comparable[a.length];//一次性分配空间
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a,int lo,int hi){
        //将数组a[lo....hi]排序
        if(hi <= lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    //原地归并
    public static void merge(Comparable[] a,int lo,int mid, int hi )
    {
        //将a[lo...mid] 和 a[mid+1...hi]归并
        int i= lo;
        int j = mid+1;
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi;k++)
            if (i>mid)                        a[k] = aux[j++];
            else if (j>hi)                   a[k] = aux[i++];
            else if (less(aux[j],aux[i]))    a[k] = aux[j++];
            else                             a[k] = aux[i++];
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
