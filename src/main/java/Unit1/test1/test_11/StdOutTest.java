package Unit1.test1.test_11;

import edu.princeton.cs.algs4.StdOut;;

public class StdOutTest {
    public  static void main(String [] args){
        int f=0,g=1;
        for (int i = 0 ;i<= 15;i++){
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
