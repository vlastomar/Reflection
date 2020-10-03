package HighQualityMistakesPack;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class MainCopy {
    public static void main(String[] args) throws Exception {

    Class<Reflection> clazz = Reflection.class;
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(p -> System.out.println(String.format("%s must be private!", p.getName())));

        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods)
                .filter(f -> f.getName().startsWith("get"))
                .filter(f2 -> !Modifier.isPublic(f2.getModifiers()))
                . sorted(Comparator.comparing(Method::getName))
                .forEach(p -> System.out.println(String.format("%s have to be public!", p.getName())));

        Arrays.stream(methods)
                .filter(f -> f.getName().startsWith("set"))
                .filter(f2 -> !Modifier.isPrivate(f2.getModifiers()))
                . sorted(Comparator.comparing(Method::getName))
                .forEach(p -> System.out.println(String.format("%s have to be private!", p.getName())));

    }
}
