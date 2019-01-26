package Test;

public class CharacterAndChar {
    public static void main(String []args){
        Character c1 = 'a';
        Character c2 = new Character('a');
        char b1 = 'a';
        char b2 = new Character('a');

        System.out.println("b1:c1 "+(c1 == b1));
        System.out.println(c1.equals(b1));

        System.out.println("b2:c1 "+(c1 == b2));
        System.out.println(c1.equals(b2));

        System.out.println("b1:c2 "+(c2 == b1));
        System.out.println(c2.equals(b1));

        System.out.println("b2:c2 "+(c2 == b2));
        System.out.println(c2.equals(b2));

        System.out.println("c1:c2 "+(c2 == c1));
        System.out.println(c2.equals(c1));

    }
}
