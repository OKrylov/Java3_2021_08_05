import calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class NewCalculatorTestCase {

    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }


    @Test
    public void testAdd() {
        calculator = new Calculator();
        Assertions.assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void testSub() {
        calculator = new Calculator();
        Assertions.assertEquals(3, calculator.sub(5, 2));
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.NANOSECONDS)
    public void testMul() throws InterruptedException {
        calculator = new Calculator();
//        Thread.sleep(1);
        Assertions.assertEquals(9, calculator.mul(3, 3));
    }

    @Test
//    @Disabled("Временно отключено")
    public void testDiv() {
        calculator = new Calculator();
        Assertions.assertEquals(1, calculator.div(2, 2));
    }


    @Test
    public void testDivZero() {
        calculator = new Calculator();
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.div(2, 0));
    }

    @ParameterizedTest
    @MethodSource("dataForArraySumOperation")
    public void testArraySumOperation(int[] array, int result) {
        Assertions.assertEquals(result, calculator.add(array[0], array[1]));
    }

    public static Stream<Arguments> dataForArraySumOperation() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] { 1, 1},   2));
        out.add(Arguments.arguments(new int[] { 2, 2},   4));
        out.add(Arguments.arguments(new int[] { 1, 2},   3));
        out.add(Arguments.arguments(new int[] { 10, 15}, 25));
        return out.stream();
    }


}

