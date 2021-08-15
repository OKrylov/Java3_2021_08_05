package lesson3.streams.symbols.io.streams;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Writes {

    private static final String FILE_NAME = "test_writer.txt";

    private interface ThrowableRunnable {
        void exec() throws Exception;
    }

    private static final String LATIN_SEQUENCE = "abxzABXZ";
    private static final String CYRIL_SEQUENCE = "абюяАБЮЯ";
    private static final String UNICODE_SPECIAL_SEQUENCE = "^½ቖ";

    public static void main(String[] args) throws Exception {
        System.out.println("Default charset: " + Charset.defaultCharset());
//        PrintWriter writer = new PrintWriter(new FileOutputStream("test_writer.txt"));
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println(LATIN_SEQUENCE);
            writer.println(CYRIL_SEQUENCE);
            writer.println(UNICODE_SPECIAL_SEQUENCE);
        }

        for (String line : Files.readAllLines(Paths.get(FILE_NAME))) {
            System.out.println(line);
            System.out.println(Arrays.toString(line.getBytes()));
            System.out.println(Arrays.toString(unsignedByteArray(line.getBytes())));
            System.out.println();
        }

    }



    private static void measureTime(ThrowableRunnable method, String methodName) throws Exception {
        long start = System.nanoTime();
        method.exec();
        long end = System.nanoTime();
        System.out.printf("%s took: %d ms%n", methodName, TimeUnit.NANOSECONDS.toMillis(end - start));
    }

    private static int[] unsignedByteArray(byte[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Byte.toUnsignedInt(array[i]);
        }

        return result;
    }
}
