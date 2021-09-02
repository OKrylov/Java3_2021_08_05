package homework;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lesson6_DZTask2TestCase {

    private Lesson6_DZ dz;

    @Before
    public void prepare() {
        dz = new Lesson6_DZ();
    }

    @Test
    public void test_task2_empty_array() {
        Assert.assertFalse(dz.task2(new int[]{}));
    }

    @Test
    public void test_task2_only_1_and_4() {
        Assert.assertTrue(dz.task2(new int[]{1, 4, 4, 1}));
    }

    @Test
    public void test_task2_1_and_4_and_others() {
        Assert.assertFalse(dz.task2(new int[]{1, 4, 3, 1}));
    }

    @Test
    public void test_task2_without_1_and_4() {
        Assert.assertFalse(dz.task2(new int[]{2, 3}));
    }

    @Test
    public void test_task2_only_1() {
        Assert.assertFalse(dz.task2(new int[]{1, 1, 1}));
    }

    @Test
    public void test_task2_only_4() {
        Assert.assertFalse(dz.task2(new int[]{4, 4, 4}));
    }

}
