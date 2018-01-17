package Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodExample {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clazz= ClassExample.class;

        //Create a class instance
        Constructor constructor = clazz.getConstructor();
        ClassExample example= (ClassExample) constructor.newInstance();


        Method[] methods=  clazz.getMethods(); //only public methods are returned here

        System.out.println("The Class Implements : "+ methods.length + " methods" );
        for(Method method : methods){
            System.out.println("Method Name : "+method.getName() + ", Return Type :" + method.getReturnType().getName() );
        }

        Method method= clazz.getMethod("checkInvocation");
        Object returnVal=method.invoke(example);
        System.out.println("Return Value: "+ returnVal);

        method=clazz.getMethod("checkInvocation", Long.TYPE);
        returnVal=method.invoke(example,5);
        System.out.println("Return Value: "+ returnVal);

    }
}
