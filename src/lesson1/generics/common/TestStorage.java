package lesson1.generics.common;

public class TestStorage {

    public static void main(String[] args) {
//        IntStorage intStorage = new IntStorage(5);
        Storage intStorage = new CommonStorage(5);
        intStorage.add(1);
        intStorage.add(2);

        intStorage.display();
        System.out.println();

        if (intStorage.get(0) instanceof Integer v0 && intStorage.get(1) instanceof Integer v1) {
            System.out.println(v0 + v1);
        }


//        StringStorage strStorage = new StringStorage(5);
//        strStorage.add("str1");
//        strStorage.add("str2");
//        strStorage.display();


//        intStorage.add("3");

//        Object value2 = intStorage.get(1);
//        if (value2 instanceof String) {
//            String v2 = (String) value2;
//            System.out.println("VALUE2 is String!");
//        } else {
//            Integer value1 = (Integer) intStorage.get(0);
//            Integer v2     = (Integer) intStorage.get(1);
//            System.out.println("Sum v1 + v2 = " + (value1 + v2));
//        }
//
//        Storage strStorage = new CommonStorage(5);
//        strStorage.add("1");
//        strStorage.add("2");
//        strStorage.add(3);
//
//        String v1 = (String) strStorage.get(1);
//
//        strStorage = intStorage;
//
//        String v2 = (String) strStorage.get(2);
//
//
//
//
//        intStorage.display();
//        System.out.println("---");
//
//        intStorage.remove(1);
//
//        intStorage.display();
    }
}