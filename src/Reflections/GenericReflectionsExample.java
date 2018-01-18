package Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenericReflectionsExample {

    protected List<String> stringList= new ArrayList<>();

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList){
        this.stringList=stringList;
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {

        //Generic Return Type
        Method getter=GenericReflectionsExample.class.getMethod("getStringList");
        Type returnType= getter.getGenericReturnType();

        if(returnType instanceof ParameterizedType){
            ParameterizedType parameterizedType= (ParameterizedType) returnType;
            Type[] typeArgs= parameterizedType.getActualTypeArguments();

            for(Type type: typeArgs){
                Class typeArgClass= (Class) type;
                System.out.println("Type Argument Class: "+ typeArgClass);
            }
        }

        System.out.println();


        //Generic Parameter Type
        Method setter= GenericReflectionsExample.class.getMethod("setStringList", List.class);
        Type[] genericParameterTypes= setter.getGenericParameterTypes();
        for (Type genericParameterType: genericParameterTypes){
            if(genericParameterType instanceof ParameterizedType){
                ParameterizedType parameterizedType= (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes= parameterizedType.getActualTypeArguments();
                for(Type parameterArgType : parameterArgTypes){
                    Class parameterClass= (Class) parameterArgType;
                    System.out.println("Parameter Generic Type: "+ parameterClass);
                }
            }
        }

        System.out.println();

        //Generic Field Type
        Field field= GenericReflectionsExample.class.getDeclaredField("stringList");
        Type genericFieldType= field.getGenericType();
        if(genericFieldType instanceof ParameterizedType){
            ParameterizedType parameterizedType= (ParameterizedType) genericFieldType;
             Type[] fieldArgTypes= parameterizedType.getActualTypeArguments();
             for(Type type : fieldArgTypes){
                 Class clazz = (Class) type;
                 System.out.println("Field Generic Class : "+ clazz);
             }
        }
    }
}
