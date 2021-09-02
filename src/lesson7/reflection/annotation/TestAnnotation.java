package lesson7.reflection.annotation;

import java.lang.reflect.Method;

@MarketingAnnotation(type = "Type")
public class TestAnnotation {

    @MarketingAnnotation
    private String title;

    @MarketingAnnotation(type = "Type")
    public void markedMethod() {
        System.out.println("Hello, World!");
    }

    public void unmarkedMethod() {
        System.out.println("Goodbye, World!");
    }

    @MarketingAnnotation(type = "Java", value = 36.6f)
    public void print(String word, float value) {
        System.out.println("Word: " + word);
        System.out.println("Normal temperature: " + value);
    }

    public static void main(@MarketingAnnotation String[] args) throws Exception {
        @MarketingAnnotation TestAnnotation test = new TestAnnotation();

        for (Method method : test.getClass().getDeclaredMethods()) {
            MarketingAnnotation annotation = method.getAnnotation(MarketingAnnotation.class);
            if (annotation != null && !method.getName().equals("print")) {
                method.invoke(test);
                System.out.println("Annotation value is " + annotation.value());
                System.out.println("Annotation type is " + annotation.type());
            }
        }

        Method printMethod = test.getClass().getMethod("print", String.class, float.class);
        if (printMethod.isAnnotationPresent(MarketingAnnotation.class)) {
            MarketingAnnotation annotation = printMethod.getAnnotation(MarketingAnnotation.class);
            printMethod.invoke(test, annotation.type(), annotation.value());
        }
    }
}
