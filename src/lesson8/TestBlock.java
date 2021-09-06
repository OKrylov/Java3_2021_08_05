package lesson8;

public class TestBlock {

//    private static String testStatic = testStaticMethod();
    private static String testStatic;

    private static String testStaticMethod() {
        return "testStatic";
    }

    private String testNonStatic;

    static {
        System.out.println("static block");
        TestBlock.testStatic = testStaticMethod();
    }

    {
        System.out.println("not static block");
    }

    public TestBlock(String testNonStatic) {
        System.out.println("constructor");
        System.out.println(TestBlock.testStatic);
        this.testNonStatic = testNonStatic;
    }

    public static void main(String[] args) {
        new TestBlock("test");
        System.out.println();
        new TestBlock("test");

        new Runnable() {

            String test;
            {
                test = "test";
                System.out.println("test");
            }

            @Override
            public void run() {

            }
        };
    }
}
