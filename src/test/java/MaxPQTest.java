import Unit2.Sort.priorQueue.MaxPQ;
import org.junit.jupiter.api.Test;
import edu.princeton.cs.algs4.StdOut;;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxPQTest {
    @Test
    public static void main(String[] args){
        MaxPQ<String> maxPQ = new MaxPQ(5);
        String file;
        StdOut.print("请输入文件路径：");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine())  file = sc.nextLine();
        else                   return ;
        try {
            FileInputStream is = new FileInputStream(file);
            sc = new Scanner(new BufferedInputStream(is),"utf-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNext()){
            String str =  sc.next();
            maxPQ.insert(str);
            StdOut.print(str+" ");
        }
        StdOut.println("\n排序后的数");
        int N = maxPQ.size();
        for (int i = 0;i < N;i++){
            StdOut.print(maxPQ.delMax()+" ");
        }
    }
}
