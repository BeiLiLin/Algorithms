package interview;

import java.util.Arrays;
import java.util.Scanner;

//判断数组中的三个数是否有相加等于N的
public class Bilibili {
    public static Boolean demo(int arr[],int N){
        Arrays.sort(arr);
        if (arr[0]>N){
            return false;
        }
        int count = 0;
        int i = 0,j=arr.length-1,k=1;
        while (k<j && i<k){
            count = arr[i]+arr[j]+arr[k];
            if (count==N){
                return true;
            }else if(count<N&&arr[i]+arr[j]+arr[k+1]>N){
                i++;
            }else if(count<N){
                k++;
            }else if (count>N){
                j--;
            }
        }
        return false;
    }
    public static void main(String []args){
        String str = null;
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext())
        {
            str = sc.nextLine();
        }else{return ;}
        String[] param = str.split(",");
        int N = Integer.parseInt(param[1]);
        String arr[] = param[0].split(" ");
        int arrs[] = new int [arr.length];
        for (int i=0;i<arr.length;i++){
            arrs[i]=Integer.parseInt(arr[i]);
        }
        System.out.println(demo(arrs,N).toString());
    }

}
