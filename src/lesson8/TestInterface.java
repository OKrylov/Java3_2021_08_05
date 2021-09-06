package lesson8;

public interface TestInterface {

    String CONST = "test";

    void test();

    int sum(int a, int b);

    int mul(int a, int b);

    default int pow(int a, int pow) {
        return privateTestPow(a, pow);
    }

    static int privateTestPow(int a, int pow) {
        return (int) Math.pow(a, pow);
    }
}
