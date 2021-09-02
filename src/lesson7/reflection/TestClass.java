package lesson7.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) throws Exception {
//        testClass();
        testCat();
    }

    private static void testCat() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        ICat cat = new Cat("Baarsik", "black", 4);
        Class<? extends ICat> clazz = cat.getClass();

        System.out.println("Interfaces:");
        for (Class<?> anInterface : clazz.getInterfaces()) {
            System.out.println("Is interface: " + anInterface.isInterface());
            System.out.println(anInterface.getSimpleName());
        }
        System.out.println();

        System.out.println("Superclasses:");
        printAllSuperclasses(clazz);

//        System.out.println("Fields");

//        for (Field field : clazz.getFields()) {
//        for (Field field : clazz.getDeclaredFields()) {
//            field.setAccessible(true);
//            System.out.println(String.format("%s Type '%s' for field '%s'; value = %s",
//                    getAccessModifier(field),
//                    field.getType().getSimpleName(),
//                    field.getName(),
//                    field.get(cat)));
//        }
//
//        changeAge(cat, clazz);
//        changeKitty(cat, clazz);
//        System.out.println();

        System.out.println("Methods");
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println(getAccessModifier(declaredMethod) + " "
                    + declaredMethod.getReturnType() + " "
                    + declaredMethod.getName() + " "
                    + Arrays.toString(declaredMethod.getParameterTypes()));

            for (Annotation declaredAnnotation : declaredMethod.getDeclaredAnnotations()) {
                System.out.println(declaredAnnotation);
            }

        }
////
//        Method jumpMethod = clazz.getDeclaredMethod("jump");
//        jumpMethod.setAccessible(true);
//        jumpMethod.invoke(cat);  // cat.jump();
////
//        Method meowMethod = clazz.getMethod("meow", int.class);
//        meowMethod.invoke(cat, 60);  // cat.meow(60)

//        System.out.println();
//
//        System.out.println("Constructors");
//        for (Constructor<?> declaredConstructor : clazz.getDeclaredConstructors()) {
//            System.out.println(declaredConstructor);
//        }
//
//        Constructor<? extends ICat> constructor = clazz.getDeclaredConstructor(String.class, String.class, int.class);
//        ICat cat2 = constructor.newInstance("Markiz", "Yellow", 2);
//        System.out.println(cat2);
    }

    private static void printAllSuperclasses(Class<? extends ICat> clazz) {
        Class<?> currentClass = clazz;
        while (currentClass != null) {
            System.out.println(currentClass.getSimpleName());
            System.out.println("Superclass is abstract: " + Modifier.isAbstract(currentClass.getModifiers()));
            currentClass = currentClass.getSuperclass();
        }
        System.out.println();
    }

    private static String getAccessModifier(Method method) {
        if (Modifier.isPublic(method.getModifiers())) {
            return "Public";
        }
        else if (Modifier.isProtected(method.getModifiers())) {
            return "Protected";
        }
        else if (Modifier.isPrivate(method.getModifiers())) {
            return "Private";
        }
        else {
            return "Default";
        }
    }

    private static String getAccessModifier(Field field) {
        if (Modifier.isPublic(field.getModifiers())) {
            return "Public";
        }
        else if (Modifier.isProtected(field.getModifiers())) {
            return "Protected";
        }
        else if (Modifier.isPrivate(field.getModifiers())) {
            return "Private";
        }
        else {
            return "Default";
        }
    }

    private static void changeKitty(ICat cat, Class<? extends ICat> clazz) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(cat);

        Field cattyField = clazz.getDeclaredField("kitty");
        cattyField.setAccessible(true);
        System.out.println("kitty is " + cattyField.get(cat));

        cattyField.set(cat, false);
        System.out.println(cat);

        //Change static
    }

    private static void changeAge(ICat cat, Class<? extends ICat> clazz) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(cat);

        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(cat, 7);

        System.out.println(cat);
    }


    private static void testClass() throws ClassNotFoundException {
        String str = "Java";
        Class<? extends String> clazz = str.getClass();
        System.out.println("Full Name: " + clazz.getName());
        System.out.println("Short Name: " + clazz.getSimpleName());
        System.out.println("Canonical Name: " + clazz.getCanonicalName());
        System.out.println("Package Name: " + clazz.getPackageName());
        System.out.println("Type Name: " + clazz.getTypeName());

        System.out.println("---------");

        System.out.println("Primitive class Name: " + int.class.getSimpleName());
        System.out.println("Void class Name: " + void.class.getSimpleName());
        System.out.println("Array class Name: " + int[].class.getSimpleName());

        int modifiers = clazz.getModifiers();
        if ( Modifier.isPublic(modifiers) ) {
            System.out.println("String is public");
        }
        if ( Modifier.isFinal(modifiers) ) {
            System.out.println("String is final");
        }
        if ( Modifier.isAbstract(modifiers) ) {
            System.out.println("String is abstract");
        }





    }
}
