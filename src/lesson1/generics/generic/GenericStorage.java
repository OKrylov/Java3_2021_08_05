package lesson1.generics.generic;

public interface GenericStorage<E> {

    void add(E value);

    void add(E value, int index);

    void remove(int index);

    E get(int index);

    boolean find(E value);

    void display();

    Pair<E, Integer> min();
}