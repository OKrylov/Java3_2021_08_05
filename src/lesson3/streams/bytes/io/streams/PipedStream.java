package lesson3.streams.bytes.io.streams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStream {

    private static PipedInputStream in;
    private static PipedOutputStream out;

    public static void main(String[] args) throws IOException {
        in = null;
        out = null;
        try {
            in  = new PipedInputStream();
            out = new PipedOutputStream();
            out.connect(in);
            for (int i = 0; i < 100; i++) {
                out.write(i);
            }
            int x;
            while ((x = in.read()) != -1) {
                System.out.print(x + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
