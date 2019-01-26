package Is;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest {
    public static void main(String []args)throws Exception {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        class1 = Class.forName("Is.A");
        class2 = new A().getClass();
        class3 = A.class;

        System.out.println(class1);
        System.out.println(class1.getName());
        System.out.println(class2.getName());
        System.out.println(class3.getName());
// 取得本类的全部属性
        Field[] field = class1.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 获取权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 获取属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }
// 取得本类的全部方法
        Method method[] = class1.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
        }
        System.out.println();
        //获取Method对象
        Method method1 = class1.getMethod("getI");
        //调用A中的getI方法
        method1.invoke(class1.newInstance());
    }
}
