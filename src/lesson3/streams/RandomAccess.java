package lesson3.streams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {

    public static void main(String[] args) throws FileNotFoundException {
        // 123456789
        try (RandomAccessFile raf = new RandomAccessFile("demo.txt", "r")) {
            System.out.println("File length: " + raf.length());

            raf.seek(8); // 9
            System.out.println("Get pointer: " + raf.getFilePointer());
            System.out.println((char) raf.read());

            raf.seek(2); // 3
            System.out.println("Get pointer: " + raf.getFilePointer());
            System.out.println((char) raf.read());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
