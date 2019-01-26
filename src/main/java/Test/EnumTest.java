package Test;

import com.sun.org.apache.xml.internal.utils.SystemIDResolver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    枚举
 */
enum CoffeeSizes{
    BIG(8),
    HUGE(10),
    OVERWHELMING(16){
        public String getLidCode(){
            return "A";
        }
    };
    CoffeeSizes(int ounces){
        this.ounces = ounces;
    }
    private int ounces;
    public int getOunces(){
        return ounces;
    }
    public String getLidCode(){
        return "B";
    }
}
public class EnumTest {
    CoffeeSizes sizes;
    public  static void main(String[]args){
        EnumTest test1 = new EnumTest();
        EnumTest test2 = new EnumTest();
        test1.sizes = CoffeeSizes.BIG;
        test2.sizes = CoffeeSizes.OVERWHELMING;
        System.out.println(test1.sizes.getOunces());
        System.out.println(test1.sizes.getLidCode());
        System.out.println(test2.sizes.getOunces());
        System.out.println(test2.sizes.getLidCode());

        for (CoffeeSizes coffeeSizes:CoffeeSizes.values()){
            System.out.println(coffeeSizes.getOunces());
            System.out.println(coffeeSizes.getLidCode());
        }
        String str = "google";
        Map<Character,Integer> map = new HashMap();
        for (int i =0 ;i<str.length();i++){
            char c = str.charAt(i);
            if (map.get(c) != null){
                int count =map.get(c)+1;
                map.put(c,count);
            }else{
                map.put(c,1);
            }
        }
        for (Character str1:map.keySet()){
            if(map.get(str1) == 1){

                System.out.println("第一个不重复"+map.get(str1));
                break;
            }
        }

     }

}
