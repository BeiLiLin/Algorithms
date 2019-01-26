package Unit2.Sort.priorQueue;

import edu.princeton.cs.algs4.StdOut;;

public class MaxPQ<T extends Comparable<T>>{
    private T[] pq;//基于堆的完全二叉树
    private int N = 0;//    储存于pq[1....N]中，pq[0]
    public MaxPQ(int maxN){
        pq = (T[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){return N == 0;}
    public int size(){return N;}
    //插入对象在最低，并上浮该对象，恢复堆的有序
    public void insert(T t){
        if (N == pq.length-1)   resize(2*pq.length);
        pq[++N] = t;
        swim(N);
    }
    //删除最大的对象pq[1]，并使pq[1] = pq[N],然后使用sink恢复堆的有序
    public T delMax(){
        T max = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        if (N < (pq.length-1)/4)    resize(pq.length/2);
        return max;
    }

    public boolean less(int i ,int j){
        return pq[i].compareTo(pq[j])<0;
    }
    public void exch(int i , int j){
        T t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    //上浮
    public void swim(int k){
        while(k > 1 && less(k/2,k))
        {
            exch(k/2,k);
            k = k/2;
        }
    }
    //下沉
    public void sink(int k){
        //2*k、2*k+1为k的两个子结点
        while(2*k <= N){
            int max = k*2;
            if(max < N && less(max,max+1)) max++;//先判断max是否<N，防止max+1越界，然后选出子结点较大的与k比较
            if(!less(k,max))      break;//k小于max，pq[k]下沉，否则退出该下函数
            exch(k,max);
            k = max;
        }
    }
    public void resize(int max){
        T[] temp =(T[]) new Comparable[max+1];
        for (int i = 1; i < N+1; i++)
            temp[i] = pq[i];
        pq = temp;
    }
}
