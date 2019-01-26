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
                1�����н���
                -1�������н���
             */
            /*
                String ���͵Ĵ�С ��ʹ��String��CompareTo�������бȽ�
                o1.compareTo(o2)
                o1>o2:  1
                o1<o2:  -1
                o1==o2: 0
             */
                @Override
                public int compare(String o1, String o2) {
                /*
                (o2 + o1) �� (o1 + o2)���Ƚ�
                 (o2 + o1)>(o1 + o2) ֵΪ1,   ����
                 (o2 + o1)=(o1 + o2) ֵΪ0,
                 (o2 + o1)<(o1 + o2) ֵΪ-1   ������
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