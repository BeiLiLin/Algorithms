package Unit1.test1.Bag;

import edu.princeton.cs.algs4.StdOut;;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/*
    链表实现的背包
 */
public class Bag<T> implements Iterable<T> {
    private int N;
    private Node first;
    private class Node{
        private T t;
        private Node next;
    }
    public void add(T t){
        Node oldFirst = first;
        first = new Node();
        first.t = t;
        first.next = oldFirst;
    }
    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }
    private class BagIterator implements Iterator<T>{
        private Node node = first;
        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T t = node.t;
            node = node.next;
            return t;
        }
    }
    public static void main(String[] args){
        Bag<String> b = new Bag<String>();
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
            b.add(sc.next());
        }
        for (String x : b)
            StdOut.println(x);
    }
}
