package Unit1.test1.Stack;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.princeton.cs.algs4.StdOut;;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/*
    后进先出（栈）：总是a[--N]先出
    先进先出（队列）：总是a[0]先出
 */
public class ResizingArrayStack<T> implements Iterable<T>{
    private T a[];
    private int N = 0;
    //构造函数
    public ResizingArrayStack(int cap){
        a = (T[]) new Object[cap];
    }
    //进栈
    public void push(T t){
        if(a.length == N)
            resize(2*a.length);
        a[N++] = t;
    }
    //出栈
    public T pop(){
        T temp = a[--N];
        a[N] = null;
        if(N == a.length/4)
            resize(N/2);
        return temp;
    }
    //判断栈是否为空
    public Boolean isEmpty(){
        return N ==0;
    }
    //判断栈的空间大小
    public int size(){
        return N;
    }
    //动态改变栈的空间大小
    public void resize(int max){
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i <N ; i++)
            temp[i] = a[i];
        a = temp;
    }
    /*
          为模板添加迭代功能
     */
    public Iterator<T> iterator() {
        return new ResizingArrayStackIterator();
    }
    private class ResizingArrayStackIterator implements Iterator<T>{
        private int i = N;
        public boolean hasNext() {
            return i>0;
        }
        public T next() {
            return a[--i];
        }
    }

    public static void main(String[] args){
        ResizingArrayStack<String> r = new ResizingArrayStack<String>(100);
        String file;
        Scanner sc = new Scanner(System.in);
        StdOut.println("请输入文件的路径：");
        if(sc.hasNext())
        {
            file = sc.next();
        }else{return ;}
        try {
            FileInputStream is = new FileInputStream(file);
            sc = new Scanner(new BufferedInputStream(is),"utf-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(sc.hasNext()){
            r.push(sc.next());
        }
        for (String x : r)
            StdOut.println(x);
    }
}
