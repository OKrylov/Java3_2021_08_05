package lesson8;

public class TestLabel {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            System.out.printf("i: %d%n", i);
            for (int j = 0; j < 10; j++) {
                if (!innerLoop(i, j)) {
                    break;
                }
            }
        }
    }

    private static boolean innerLoop(int i, int j) {
        for (int k = 0; k < 10; k++) {
            if (j == 0 && k == 5) {
                return false;
            }
            System.out.printf("i: %d; j: %d; k: %d%n", i, j, k);
        }
        return true;
    }
}
