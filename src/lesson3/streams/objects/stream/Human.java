package lesson3.streams.objects.stream;

//import java.io.Serial;
import java.io.Serializable;

public class Human implements Serializable {

//    @Serial
    private static final long serialVersionUID = -2797844370655404141L;

    public int age;
    public String test;


    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                '}';
    }
}
