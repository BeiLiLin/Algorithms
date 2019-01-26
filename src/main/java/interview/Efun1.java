package interview;

import java.util.Scanner;

/*
    有n个人围城一圈,顺序排号。从第一个人开始报数(从1报到3),凡报到3 的人退出圈子，问最后留下的是原来的第几号的那位。
 */
public class Efun1 {
    public static String  rowNumber(int n,Integer num[]){
        String result = "";
        while (n>1){
            int p = 0;//当前数组的指针
            Integer head = 0;//记录首位留在圈子的人的位置
            int count =0;//记录当前报数的人数
            while (p<=num.length){
                if (p == num.length ){//报数到最后一个数，因为是圈，所以头部是第一个报数的人，也是最后一个报数的人
                    if ((count+1)%3 == 0){
                        num[head] = null;
                        n--;
                    }
                    break;
                }else if (num[p]== null ){//当前位置的人已经退出
                    p++;
                }else if((count+1)%3==0){//当前报数是3的倍数
                    num[p++]=null;
                    count++;
                    n--;
                }else {//当前位置的人存在，且报数不是3的倍数
                    if (count == 0){
                        head=p;
                    }
                    if (count == 1 && n==2){
                        result = "最后一个留在圈中的人是"+p+"位置的"+num[p];
                    }
                    count++;
                    p++;
                }
            }
        }
        return result;
    }
    public static  void main(String []args){
        int n = 10;//默认为10
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            n = scanner.nextInt();
        }
        Integer [] num = new Integer [n];
        for (int i=0;i<n;i++){
            num[i] = i+1;
        }
        System.out.println(rowNumber(n,num));
    }
}
