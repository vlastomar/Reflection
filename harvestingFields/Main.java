package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Class clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		String input = read.readLine();
		int counter = 1;
		while (!"HARVEST".equals(input)){
			switch (input){
				case "private":
					Arrays.stream(fields)
							.filter(f -> Modifier.isPrivate(f.getModifiers()))
							.forEach(p -> System.out.println(String.format("private %s %s", p.getType().getSimpleName(), p.getName() ))) ;

					break;
				case "protected":
					Arrays.stream(fields)
							.filter(f -> Modifier.isProtected(f.getModifiers()))
							.forEach(p -> System.out.println(String.format("protected %s %s", p.getType().getSimpleName(), p.getName() ))) ;
					break;
				case "public":
					Arrays.stream(fields)
							.filter(f -> Modifier.isPublic(f.getModifiers()))
							.forEach(p -> System.out.println(String.format("public %s %s", p.getType().getSimpleName(), p.getName() ))) ;
					break;
				case "all":
					Arrays.stream(fields)
							.forEach(p -> System.out.println(String.format("%s %s %s", Modifier.toString(p.getModifiers()) ,p.getType().getSimpleName(), p.getName() ))) ;
					break;
			}


				counter++;
			if (counter > 100){
				break;
			}
			input = read.readLine();
		}

	}
}
