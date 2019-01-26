package Unit2.Sort.SortCompare;

import Unit2.Sort.Heap.Heap;
import Unit2.Sort.Insertion.Insertion;
import Unit2.Sort.MergeSort.Merge;
import Unit2.Sort.MergeSort.MergeBU;
import Unit2.Sort.QuitSort.Quick;
import Unit2.Sort.Selection.Selection;
import Unit2.Sort.Shell.Shell;
import edu.princeton.cs.algs4.StdOut;;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Scanner;

public class SortCompare {
    //计算算法运行时间
    public static double time(String alg,Comparable []a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("MergeBU")) MergeBU.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }
    //使用算法alg将T个长度为N的数组排序
    public static double timeRandomInput(String alg,int N,int T){
        double total = 0.0;
        Integer[] a = new Integer[N];

        for (int t = 0;t<T;t++){
            for (int i = 0;i<N;i++)
                a[i] = StdRandom.uniform(10000);
            total += time(alg,a);
            }
          return total;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        StdOut.println("请输入参数（alg1、alg2、N、T）,每个参数用逗号隔开：");
        String []param= sc.next().split(",");
        String alg1 = param[0];
        String alg2 = param[1];
        int N = Integer.parseInt(param[2]);
        int T = Integer.parseInt(param[3]);
        double t1 = timeRandomInput(alg1,N,T);//算法1的总时间
        double t2 = timeRandomInput(alg2,N,T);//算法2的总时间
        StdOut.println(alg1+"的时间："+t1+"  "+alg2+"的时间："+t2);
        StdOut.printf("For %d random Doubles\n %s is",N,alg1);
        StdOut.printf("%.1f times faster than %s\n",t2/t1,alg2);
}
}
