package Unit1.test1;

import template.StdOut;

/*
    打印出一个Boolean数组的内容，*为真，空格为假
 */
public class test1111 {
    public  static  void main(String [] args){
       Boolean [][] x ={{true,true,true,true},{false,true,false,true},{false,false,false,true},{true,false,true,true},{true,false,true,true}};
        /*从命令行获取数组
        Boolean [][]x = new Boolean[4][4];
        int c;
        for(int i=0;i<4;i++){
            for(int k =0;k<4;k++){
                c = i*k+k;
                    x[i][k] = Boolean.parseBoolean(args[c]);
                     System.out.print(x[i][k]);
            }
            System.out.println();
        }*/
        Boolean temp ;
        for(int i=0;i<5;i++){
            if(i == 0){
                StdOut.println("  1 2 3 4");
                continue;
            }
            for(int k =0;k<5;k++){
                if (k == 0) {
                    StdOut.print(i+" ");
                    continue;
                }
                temp = x[i-1][k-1];
                if (temp){
                    StdOut.print("* ");
                }else{
                    StdOut.print("  ");
                }
            }
            StdOut.println();
            }

    }

}
