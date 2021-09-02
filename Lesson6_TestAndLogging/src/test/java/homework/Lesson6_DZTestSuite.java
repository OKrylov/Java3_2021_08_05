package homework;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
//@RunWith(JUnitPlatform.class)
@Suite.SuiteClasses({
        Lesson6_DZTask1JUnit4TestCase.class,
//        Lesson6_DZTask1JUnit5TestCase.class,
        Lesson6_DZTask2TestCase.class,
})
public class Lesson6_DZTestSuite {
}
