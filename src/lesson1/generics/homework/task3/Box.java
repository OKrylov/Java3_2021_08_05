package lesson1.generics.homework.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<E extends Fruit> {

    private List<E> fruits = new ArrayList<>();

    public Box(List<E> fruits) {
        this.fruits.addAll(fruits);
    }

    public Box(E... fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public void add(E fruit) {
        fruits.add(fruit);
    }

    public void moveAllTo(Box<E> anotherBox) {
        for (E fruit : fruits) {
            anotherBox.add(fruit);
        }

        fruits.clear();
    }

    public boolean compareTo(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public double getWeight() {
//        return fruits.stream()
//                .mapToDouble(fruit -> fruit.getWeight())
//                .sum();

        double sum = 0.0;
        for (E fruit : fruits) {
            sum += fruit.getWeight();// sum = sum + fruit.getWeight()
        }
        return sum;
    }

}