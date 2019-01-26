public class A{
    public  static void add(Byte b)
    {
        b = b++;
    }

    public static void main(String[] args) {
        Byte a = 127;
        Byte b = 127;
        byte by = 127;
        by++;
        System.out.print( by + " ");
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
}




