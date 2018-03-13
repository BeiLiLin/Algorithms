package Unit2.Sort.Shell;

import template.StdOut;

import java.util.Scanner;

public class Shell {
    public static void sort(Comparable []a){
       //将a[]升序排序
        int N = a.length;
        int h = 1;
        while (h <N/3) h = 3*h+1;//1,4,13,40,121,364,1093
        while (h >= 1){
            //将数组变成h有序
            for (int i = h; i < N; i++){
                //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]....之中
                for (int j = i; j >= h && less(a[j],a[j-h]);j -= h )
                    exch(a,j,j-h);
            }
            h=h/3;
        }
    }
    public static boolean less(Comparable v,Comparable w){

        return v.compareTo(w)<0;
    }
    public static void  exch(Comparable []a,int i ,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static boolean isSorted(Comparable []a){
        int N = a.length;
        for (int i=1;i<N;i++)
            if(less(a[i],a[i-1]))
                return false;
        return true;
    }
    public static void  show(Comparable []a){
        for (Comparable x :a)
            StdOut.print(x+" ");
        StdOut.println();
    }

    public static void main(String []args){
        StdOut.println("请输入排序的数组字符串，每个数组元素用,号隔开：");
        Scanner sc = new Scanner(System.in);
        String []a = sc.next().split(",");
        sort(a);
        assert  isSorted(a);
        show(a);
    }
}
