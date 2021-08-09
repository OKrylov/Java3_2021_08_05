package lesson1.generics.homework.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    public static <T> List<T> transform(T[] array) {
//        List<T> list = new ArrayList<>();
//        for (T value : array) {
//            list.add(value);
//        }
//        return list;
        return Arrays.asList(array);
    }


    public static void main(String[] args) {
        String[] strArr = {"s", "t", "r"};
        List<String> strList = transform(strArr);
        System.out.println(strList.getClass().getSimpleName() + " - " + strList);
    }

}