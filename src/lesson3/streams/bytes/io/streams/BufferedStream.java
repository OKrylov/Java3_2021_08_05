package lesson3.streams.bytes.io.streams;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BufferedStream {

    private interface ThrowableRunnable {
        void exec() throws Exception;
    }

    private static final int BYTES_NUMBER = 1024 * 1024;
    private static final char SYMBOL = 'Z';

    public static void main(String[] args) throws Exception {
        measureTime(BufferedStream::fileWriter, "Per byte writer");
        measureTime(BufferedStream::arrayFileWriter, "Array writer");
        measureTime(BufferedStream::bufferFileWriter, "Buffered writer");
    }

    private static void bufferFileWriter() throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("test_buffer")));
        for (int i = 0; i < BYTES_NUMBER; i++) {
            out.writeChar(SYMBOL);
        }
        out.close();
    }

    private static void fileWriter() throws IOException {
        DataOutputStream out = new DataOutputStream((new FileOutputStream("test_buffer")));
        for (int i = 0; i < BYTES_NUMBER; i++) {
            out.writeChar(SYMBOL);
        }
        out.close();
    }

    private static void arrayFileWriter() throws IOException {
        byte[] data = new byte[BYTES_NUMBER];
        Arrays.fill(data, (byte) SYMBOL);
        DataOutputStream out = new DataOutputStream((new FileOutputStream("test_buffer")));
        out.write(data);
        out.close();
    }

    private static void measureTime(ThrowableRunnable method, String methodName) throws Exception {
        long start = System.nanoTime();
        method.exec();
        long end = System.nanoTime();
        System.out.printf("%s took: %d ms%n", methodName, TimeUnit.NANOSECONDS.toMillis(end - start));
    }
}
