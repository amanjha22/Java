package Reflections;

import java.lang.reflect.*;

public class PrivateAccessExample {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = ClassExample.class;
        Constructor constructor= clazz.getConstructor();
        ClassExample example= (ClassExample) constructor.newInstance();

        //Access Private Members
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            int mod= field.getModifiers();
            if(Modifier.isPrivate(mod)){
                System.out.println("Private Field : "+ field.getName());
                //Turn off access checks in case of reflections
                field.setAccessible(true); // even after setting this accessible , it is only visible through reflections, normal classes still cant access it.
                field.set(example,10);
                System.out.println("Field Value : " + field.get(example));
                field.setAccessible(false);
                //System.out.println("Field Value : " + field.get(example)); this wont work after accessible is set to false
            }
        }

        //Access Private Methods
        Method[] declaredMethods= clazz.getDeclaredMethods();

        for(Method method : declaredMethods){
            int mod= method.getModifiers();
            if(Modifier.isPrivate(mod)){
                System.out.println("Private Method : "+ method.getName());
            }
        }
    }
}
