package lesson7.reflection.dz;

import lesson7.reflection.dz.tester.annotations.AfterSuite;
import lesson7.reflection.dz.tester.annotations.BeforeSuite;
import lesson7.reflection.dz.tester.annotations.Test;


public class Tests {

    @BeforeSuite
    public void prepare() {
        System.out.println("making preparations");
    }

    @Test(priority = Test.Priority.VERY_LOW)
    public void test1() {
        System.out.println("In test 5");
    }

    @Test(priority = Test.Priority.LOW)
    public void test2() {
        System.out.println("In test 4");
    }

    @Test(priority = Test.Priority.MAX_PRIORITY)
    public void test3() {
        System.out.println("In test 1");
    }

    @Test(priority = Test.Priority.HIGHEST)
    public void test4() {
        System.out.println("In test 2");
    }

    @Test
    public void test5() {
        System.out.println("In test 3");
    }

    @AfterSuite
    public void cleanUp() {
        System.out.println("making cleanup");
    }

}
