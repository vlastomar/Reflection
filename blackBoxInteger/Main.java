package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        BlackBoxInt blackBoxInt = null;
        Constructor<?> declaredConstructor = BlackBoxInt.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance();


        Map<String, Method> methods = new HashMap<>();
        for (Method declaredMethod : blackBoxInt.getClass().getDeclaredMethods()) {
            methods.put(declaredMethod.getName(), declaredMethod);

        }


        String line = read.readLine();
        while (!"END".equals(line)){
             String[] input = line.split("_");
             Method method = methods.get(input[0]);
             method.setAccessible(true);
             method.invoke(blackBoxInt, Integer.parseInt(input[1]));
             Field declaredField = blackBoxInt.getClass().getDeclaredFields()[1];
             declaredField.setAccessible(true);
            System.out.println(declaredField.getInt(blackBoxInt));

            line = read.readLine();
        }
    }
}
