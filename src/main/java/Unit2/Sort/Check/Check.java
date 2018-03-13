package Unit2.Sort.Check;

import Unit2.Sort.Heap.Heap;
import Unit2.Sort.Insertion.Insertion;
import Unit2.Sort.MergeSort.Merge;
import Unit2.Sort.QuitSort.Quick;
import Unit2.Sort.Selection.Selection;
import Unit2.Sort.Shell.Shell;
import template.StdOut;
import template.StdRandom;

import java.util.Scanner;

/*
    检查数组排序是否有修改过
 */
public class Check {
    public static void Sort(String alg,Comparable[] a)
    {
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
    }
    public static boolean timeRandomInput(String alg,int N)
    {
        Integer[] a = new Integer[N];
        Integer[] b = new Integer[N];
        for (int i = 0; i<N; i++){
            a[i] = StdRandom.uniform(1000);
        }
        //复制数组
        for (int i = 0; i <N ; i++) {
            b[i]=a[i];
        }
        for (Integer x:b){
            StdOut.print(x+" ");
        }StdOut.println();
        Sort(alg,a);
        StdOut.println("排序后");
        for (int x:a){
            StdOut.print(x+" ");
        }StdOut.println();
        return CheckElements(a,b,N);

    }

    private static boolean CheckElements(Integer[] a, Integer[] b, int N) {
        for (int i = 0; i < N; i++)
            if(a[i]-b[i]!=0)return false;//判断有无不同的元素
        return true;
    }
    public static void main(String[] args){
        StdOut.print("输入算法名称：");
        Scanner sc = new Scanner(System.in);
        String alg =sc.next();
        StdOut.print("输入数组长度：");
        int N = sc.nextInt();
        StdOut.println(timeRandomInput(alg,N));
    }
}
