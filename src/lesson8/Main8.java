package lesson8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main8 {

    public static void main(String[] args) {
        System.out.println("args: " + Arrays.toString(args));
        System.out.println("Properties: " + System.getProperties());
        System.out.println("java.specification.name: " + System.getProperty("java.specification.name"));
        int a = 5;
//        Integer b = (Integer) a;
        Integer b = a;
//        System.out.println();
//        a = new Integer(8);
//        a = (int) Integer.valueOf(8);
        a = Integer.valueOf(8);
        System.out.println(a);
        System.out.println(b);

        int[] ints = {1, 2, 3};
        for (int value:
                ints) {
            System.out.println(value);
        }

        for (int anInt : ints) {
            System.out.println(anInt);
        }

        Map<String, String> map = new HashMap<>() {{
                put("test1", "1");
                put("test2", "2");
            }};

        for (String key : map.keySet()) {
            System.out.printf("%s: %s%n", key, map.get(key));
        }

        Object str = "str";
        CharSequence charSequence = (CharSequence) str;

        class LocalClass {
            private String testField;

            public void print() {
                System.out.println(testField);
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.testField = "test";
        localClass.print();

    }
}
