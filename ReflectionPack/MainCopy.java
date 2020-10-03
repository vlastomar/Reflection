package ReflectionPack;


import java.lang.reflect.InvocationTargetException;

public class MainCopy {
    public static void main(String[] args) throws Exception {
        Class ref = Reflection.class;
        System.out.println(ref);
        Class superRef = ref.getSuperclass();
        System.out.println(superRef);
        Class[] interfaces = ref.getInterfaces();
        for (Class in : interfaces) {
            System.out.println(in);
        }
        Object reflectionObjeect = ref.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObjeect);

    }




}
