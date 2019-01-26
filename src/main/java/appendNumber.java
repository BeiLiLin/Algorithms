import java.io.*;
import java.util.*;

public class appendNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        br.close();
        Comparator<String> comparator = new Comparator<String>() {
            /*
                1：进行交换
                -1：不进行交换
             */
            /*
                String 类型的大小 ，使用String的CompareTo方法进行比较
                o1.compareTo(o2)
                o1>o2:  1
                o1<o2:  -1
                o1==o2: 0
             */
                @Override
                public int compare(String o1, String o2) {
                /*
                (o2 + o1) 与 (o1 + o2)作比较
                 (o2 + o1)>(o1 + o2) 值为1,   交换
                 (o2 + o1)=(o1 + o2) 值为0,
                 (o2 + o1)<(o1 + o2) 值为-1   不交换
                 */
                return (o2 + o1).compareTo(o1 + o2);
            }
        };
        Arrays.sort(str, comparator);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str[i]);
        }
        System.out.println(sb.toString());
    }
}