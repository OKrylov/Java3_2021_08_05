package lesson1.generics.common;

public class StringStorage {

    private String[] data;
    private int currentSize;

    public StringStorage(int size) {
        this.data = new String[size];
    }

    public String get(int index) {
        return data[index];
    }

    public void add(String value) {
        add(value, currentSize);
    }

    public void add(String value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    public boolean find(String value) {
        for (int i = 0; i < currentSize; i++) {
            if ( value.equals(data[i]) ) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}