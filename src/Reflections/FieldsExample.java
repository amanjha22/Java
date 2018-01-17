package Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldsExample {

    public static void main(String[] args) {
        Class clazz= ClassExample.class;
        Field[] fields=clazz.getFields(); // only public fields are returned
        System.out.println("Class contains : " + fields.length + " fields");

        System.out.println();
        for(Field field : fields){
            System.out.println("Field Name : "+field.getName() + " ,Field Type : "+ field.getType().getName());
            int modifiers=field.getModifiers();

            System.out.println("Is Final: "+ Modifier.isFinal(modifiers));
            System.out.println("Is Private: "+ Modifier.isPrivate(modifiers));
            System.out.println("Is Protected: "+ Modifier.isProtected(modifiers));
            System.out.println("Is Public: "+ Modifier.isPublic(modifiers));
            System.out.println("Is Static: "+ Modifier.isStatic(modifiers));
            System.out.println("Is Synchronized: "+ Modifier.isSynchronized(modifiers));
            System.out.println("Is Transient: "+ Modifier.isTransient(modifiers));
            System.out.println("Is Volatile: "+ Modifier.isVolatile(modifiers));
            System.out.println();
        }

    }

}
