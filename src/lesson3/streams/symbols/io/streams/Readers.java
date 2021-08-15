package lesson3.streams.symbols.io.streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Readers {

    private static final String FILE_NAME = "test_writer.txt";

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("test_writer.txt")));

        System.out.println("FileInputStream example:");
        try (DataInputStream byteInput = new DataInputStream(new FileInputStream(FILE_NAME))) {
//            System.out.println(byteInput.readUTF()); // exception, we should have used writeUTF
            System.out.println(byteInput.readLine());
            System.out.println(byteInput.readLine());
            System.out.println(byteInput.readLine());
        }

        System.out.println();
        System.out.println("FileReader example:");

        // --------------------------
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }


        // --------------------------
        System.out.println();
        System.out.println("Scanner example:");

//        try (Scanner scanner = new Scanner(Paths.get("test_writer.txt"))) {
        try (Scanner scanner = new Scanner(new FileInputStream("test_writer.txt"))) {
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
        }


        // --------------------------
        System.out.println();
        System.out.println("Files.readAllLines example:");

        for (String line : Files.readAllLines(Paths.get(FILE_NAME))) {
            System.out.println(line);
        }


    }
}
