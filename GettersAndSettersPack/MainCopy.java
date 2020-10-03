package GettersAndSettersPack;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainCopy {
    public static void main(String[] args) throws Exception {

    Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        for (Method method : methods) {
            if (method.getName().startsWith("get")){
                getters.add(method);
            }else if (method.getName().startsWith("set")){
                setters.add(method);
            }
        }

        getters.sort(Comparator.comparing(Method::getName));


        for (Method getter : getters) {
            System.out.println(String.format("%s will return class %s", getter.getName(), getter.getReturnType()));
        }
        setters.sort(Comparator.comparing(Method::getName));

        for (Method setter : setters) {
            System.out.println(String.format("%s and will set field of class %s", setter.getName(), setter.getParameterTypes()[0]));
        }
    }
}
