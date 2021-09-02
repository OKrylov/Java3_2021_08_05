package lesson7.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})// int[] arr = {1, 2, 3}
//@Target(ElementType.METHOD)// int[] arr = {1, 2, 3}
public @interface MarketingAnnotation {

    float value() default 5.0f;

    String type() default "None";
}
