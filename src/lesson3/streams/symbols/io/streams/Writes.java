package lesson3.streams.symbols.io.streams;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Writes {

    private static final String FILE_NAME = "test_writer.txt";

    private static final String LATIN_SEQUENCE = "abxzABXZ";
    private static final String CYRIL_SEQUENCE = "абюяАБЮЯ";
    private static final String UNICODE_SPECIAL_SEQUENCE = "^½ቖ";

    public static void main(String[] args) throws Exception {
        System.out.println("Default charset: " + Charset.defaultCharset());
//        PrintWriter writer = new PrintWriter(new FileOutputStream("test_writer.txt"));
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, StandardCharsets.UTF_8))) {
            writer.println(LATIN_SEQUENCE);
            writer.println(CYRIL_SEQUENCE);
            writer.println(UNICODE_SPECIAL_SEQUENCE);
        }


        try (Scanner scanner = new Scanner(new FileReader("test_writer.txt"))) {
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
        }


        try (BufferedReader reader = new BufferedReader(new FileReader("test_writer.txt"))) {
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
        }


        System.out.println();

        for (String line : Files.readAllLines(Paths.get(FILE_NAME))) {
            System.out.println(line);
            System.out.println(Arrays.toString(line.getBytes()));
            System.out.println(Arrays.toString(unsignedByteArray(line.getBytes())));
            System.out.println();
        }

    }


    private static int[] unsignedByteArray(byte[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Byte.toUnsignedInt(array[i]);
        }

        return result;
    }
}
