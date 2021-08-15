package lesson3.streams.objects.stream;

import java.io.Serializable;

public class Human implements Serializable {

    public int age;


    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                '}';
    }
}
