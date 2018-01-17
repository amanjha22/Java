package Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorExample {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz =ClassExample.class;
        Constructor[] constructors=clazz.getConstructors();

        Constructor noParamConstrcutor= clazz.getConstructor();
        Constructor intParamConstructor=clazz.getConstructor(Integer.TYPE); //Use ClassName.Type for Primitive Classes
        Constructor multiParamConstructor=clazz.getConstructor(ClassExample.class,Long.class);

        //Constructor privateConstructor=clazz.getConstructor(Long.class); //This throws NoSuchMethodException as private members are not accessible

        ClassExample classExample= (ClassExample) noParamConstrcutor.newInstance();
        ClassExample classExample1= (ClassExample) intParamConstructor.newInstance(1);

        System.out.println(classExample);
        System.out.println(classExample1);
    }
}
