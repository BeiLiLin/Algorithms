package Test;


import java.util.Scanner;

/*
腾讯笔试题
 */
public class Test2 {
    public static  void main(String []args){
        Scanner sc = new Scanner(System.in);
        int K =Integer.parseInt(sc.nextLine());
        int A =sc.nextInt();
        int X =sc.nextInt();
        int B =sc.nextInt();
        int Y =sc.nextInt();
        int sum=0,j;
        int sum1,sum2;
        int flag=1;
        int count =0,max=K;
        //x*A == k
            while ( max >1){
                if (max%A == 0) {
                    count++;
                    max=(max/A);
                }else {
                    flag =0;
                    break;
                }
                if (count>=X){
                    flag=0;
                    break;
                }
            } System.out.println("count"+count);
        //计算x*A == k的方案
            if (count<X && flag ==1)
            {
                System.out.println("计算x*A == k的方案");
                sum1=1;
                sum2=1;
                for (j=0;j<count;j++)
                {
                    sum1 *= (X-j);
                    sum2 *= (j+1);
                }
                sum += sum1/sum2;
                System.out.println("K/A ssd "+sum);
            }else if(flag ==1){
                sum++;
            }
        System.out.println("sdadsad");
        flag = 1;
        count =0;
        max=K;
        //x*B == k
            while (max>1){
                if ((max%B) == 0) {
                    count++;
                    max=max/B;
                }else{
                    flag =0;
                    break;
                }
                if (count>=Y){
                    flag=0;
                    break;
                }
            } System.out.println("count"+count);
            //计算x*B == k的方案
            if (count<Y && flag == 1)
            {

                 sum1=1;
                 sum2=1;
                for (j=0;j<count;j++)
                {
                    sum1 *= (Y-j);
                    sum2 *= (j+1);
                }
                sum += sum1/sum2;
                System.out.println("K/B dsd "+sum);
            }else if(flag ==1){
                sum++;
            }
        if (A+B ==K)                    sum+=X*Y;//K == A+B
        //K == x*A +y*B;
        for (j=1;j<=X;j++){
            count =0;
            flag=1;
            int num = K-((int)Math.pow( (double)A,(double) j));
            System.out.println("num: "+num +"j "+j);
            if (num<=0)  break;//K-(j*A)<0退出循环
                while (num>1){
                    if (num%B == 0) {
                        count++;
                        num=(num/B);
                    }else{
                        flag =0;
                        break;
                    }
                    if (count >=Y){
                        flag=0;
                        break;
                    }
                } System.out.println("count"+count);
                //判断为K == x*A +y*B的格式
                if (count>1 && count<Y && flag ==1){
                    //从X个A中选出x个没选过的A的次数;
                    sum1 = 1;
                    sum2 = 1;
                    for (int k = 0; k < j && j > 1; k++) {

                        sum1 *= X - k;
                        System.out.println("sum1 " + sum1);
                        sum2 *= j - k;
                        System.out.println("sum2 " + sum2);
                    }
                    System.out.println("sum1 " + sum1);
                    System.out.println("sum2 " + sum2);
                    int count1 = sum1 / sum2;

                    System.out.println("j个A的自由组合" + count1);
                    sum1 = 1;
                    sum2 = 1;
                    for (int k = 0; k < count && count > 1; k++) {
                        sum1 *= (Y - k);
                        sum2 *= count--;
                    }
                    int count2= sum1 / sum2;
                    System.out.println("num/B个B的自由组合"+count2);
                    sum += count1*count2;
                    System.out.println("sum"+sum);
                }// if (count>0){


        }//for循环结束
        System.out.println(sum);

    }
}
