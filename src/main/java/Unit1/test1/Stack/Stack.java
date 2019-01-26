package Unit1.test1.Stack;

import edu.princeton.cs.algs4.StdOut;;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Stack<T> implements Iterable<T> {
    private Node first;
    private int N;
    public class Node{
        private T t;
        Node next;
    }
    public Boolean isEmpty(){return first == null;}
    public int size(){return N;}
    public void push(T t){
        Node OldFirst = first;
        first = new Node();
        first.t = t;
        first.next = OldFirst;
        N++;
    }
    public T pop(){
        T t = first.t;
       first = first.next;
        N--;
       return t;
    }
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
    private class StackIterator implements Iterator<T>{
        private Node node = first;
        @Override
        public boolean hasNext() { return node!= null; }
        @Override
        public T next() {
            T t = node.t;
            node = node.next;
            return t;
        }
    }

    public static void main(String[] args){
        Stack<String> s = new Stack<String>();
        String file;
        StdOut.print("请输入文件路径：");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext())
            file = sc.next();
        else return;
        //读取数据
        try {
            FileInputStream is = new FileInputStream(file);
            sc = new Scanner(new BufferedInputStream(is),"utf-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //进栈操作
        while(sc.hasNext())
            s.push(sc.nextLine());
        //出栈操作
        for (String x : s)
            StdOut.println(x);
    }
}
