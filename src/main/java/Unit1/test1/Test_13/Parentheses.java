package Unit1.test1.Test_13;

import edu.princeton.cs.algs4.StdOut;;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Parentheses<T> implements Iterable<T> {
    private T[] a;
    private int N;
    public Parentheses(int cap){
        a = (T[])new Object[cap];
    }

    public int size(){return N;}
    public Boolean isEmpty(){return N==0;}
    public T pop(){
        T t = a[--N];
        a[N] = null;//防止对象游离
        if (N == a.length/4)    resize(a.length/2);
        return t;
    }
    public void push(T t){
        if (N == a.length)  resize(a.length*2);
        a[N++] = t;
    }
    public void resize(int max){
        T [] temp = (T[])new Object[max];
        for (int i =0 ; i<a.length ; i++)
            temp[i] = a[i];
        a=temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ParenthesesIterator();
    }
    private class ParenthesesIterator implements Iterator<T>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i>0;
        }
        @Override
        public T next() {
            return a[--i];
        }
    }

    public static void main(String[] args){
        //定义栈存放左括号
       Parentheses<String> left = new Parentheses<String>(40);
        StdOut.print("请输入文件路径：");
        String file = "";
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext())
            file = sc.nextLine();
        //读取文本数据存放在sc
        try {
            FileInputStream is = new FileInputStream(file);
            sc = new Scanner(new BufferedInputStream(is),"utf-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //将sc的内容存放在两个栈，左括号存放在left栈中，有括号存放在right栈中
        while(sc.hasNext()){
            String str=sc.next();
            StdOut.print(str+"  ");
            switch (str){
                case "(":left.push(str);break;
                case "[":left.push(str);break;
                case "{":left.push(str);break;
                case ")":
                    if (left.pop().equals("("))
                        break;
                    else {
                        StdOut.println("false");
                        return;
                    }
                case "}":
                    if (left.pop().equals("{"))
                        break;
                    else{
                        StdOut.println("false");
                        return;
                    }
                case "]":
                    if (left.pop().equals("["))
                        break;
                    else{
                        StdOut.println("false");
                        return;
                    }
            }
        }
        if (left.size() == 0)
            StdOut.println("true");
        else    StdOut.println("false");
    }
}
