package javaTest;

public class One  extends  Base{
    private String s;
    public One(){}{}
    public One( String s){
        super("sdds");
        System.out.println("xxx");
    }
    public static void main(String[] args){

     String s = null;
        if ((s==null)|| (s.length()==0))
        {
            System.out.println("111");
        }
        if( (s!=null) && (s.length()>0) )
        {
           System.out.println("121");
        }
    }
}
