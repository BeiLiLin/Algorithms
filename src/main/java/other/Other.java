package other;

public class Other {
    private String l;
    private String a;
    public static String hello = "Hello";

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Other{" +
                "l='" + l + '\'' +
                ", a='" + a + '\'' +
                '}';
    }
}
