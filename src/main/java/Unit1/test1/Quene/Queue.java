package Unit1.test1.Quene;
import edu.princeton.cs.algs4.StdOut;;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
/*
    先进先出
 */
public class Queue<T>implements Iterable<T> {
    private Node first;
    private Node last;
    private int N;

    public Queue() {
    }

    private class Node{
        private T t ;
        private Node next;
    }
    public Boolean isEmpty(){return first == null;}
    public int size(){return N;}
    public void enqueue(T t){
        //向表尾添加数据
        Node oldLast = last;
        last = new Node();
        last.t = t;
        last.next = null;
        if (isEmpty()) first =last;
        else            oldLast.next = last;
        N++;
    }
    public T dequeue(){
        //删除表头数据
        T t = first.t;
        first=first.next;
        if (isEmpty()) last = null;
        N--;
        return t;
    }





    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }
    private class QueueIterator implements Iterator<T>{
        private Node node =first;
        @Override
        public boolean hasNext() {
            return node!=null;
        }

        @Override
        public T next() {
            T t = node.t;
            node = node.next;
            return t;
        }
    }



    public static void main(String[] args){
        Queue<String> q = new Queue<String>();
        String file;
        StdOut.println("请输入文件的路径：");
        Scanner sc = new Scanner(System.in);
        //获取文件路径
        if (sc.hasNext())
            file = sc.next();
        else
            return ;
        //获取数据
        try {
            FileInputStream is = new FileInputStream(file);
            sc = new Scanner(new BufferedInputStream(is),"utf-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(sc.hasNext())
            q.enqueue(sc.next());
        while(!q.isEmpty())
            StdOut.println(q.dequeue());
        for (String x:q)
            StdOut.println(x);
    }
}
