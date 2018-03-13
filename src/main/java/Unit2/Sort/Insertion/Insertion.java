package Unit2.Sort.Insertion;

import template.StdOut;

import java.util.Scanner;

public class Insertion {
    public static void sort(Comparable []a){
        int N = a.length;
        //让每个a[i]与a[i-1,i-2....]交换位置
        for (int i=1;i<N;i++){
            /*
            当j>0时交换元素
                直到出现a[j]>a[j-1],则可以退出循环，因为前面的元素已经有序。
             */
            for(int j = i;j>0&&less(a[j],a[j-1]);j--)
                exch(a,j,j-1);
//            drawShow(a);
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
    public static void exch(Comparable []a,int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    //测试数组是否有序
    public static boolean isSorted(Comparable []a){
        for (int i=1;i<a.length;i++)
            if (less(a[i],a[i-1]))
                return false;
        return true;
    }
    //输出数组
    public static void show(Comparable []a){
        for (Comparable x:a)
            StdOut.print(x+" ");
        StdOut.println();
    }

    //画出数组
//    public static void drawShow(Comparable []a){
//        int N = a.length;
//        for (int i = 0;i<N;i++ ){
//            double x=1.0*i/N;
//            double y = a[i].toString().hashCode()/2.0;
//            double rw = 0.5/N;
//            double rh = Double.parseDouble((String) a[i])/2.0;
//            StdDraw.filledRectangle(x,y,rw,rh);
//        }
//    }
    public static void main(String []args){
        StdOut.println("请输入排序的数组字符串，每个数组元素用,号隔开：");
        Scanner sc = new Scanner(System.in);
        String []a = sc.next().split(",");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
