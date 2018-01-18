package Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyAnnotation(name = "AnnotationExample", value = "Hello World")
@MyAnnotation()
public class AnnotationExample {

    @MyAnnotation(value = "checkAnnotationField", name="field")
    public String checkAnnotationField="";

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class clazz= AnnotationExample.class;

        //Access all annotations
        Annotation[] annotations= clazz.getAnnotations();
        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotations){
                MyAnnotation[] myAnnotations=((MyAnnotations) annotation).value();

                for(MyAnnotation myAnnotation: myAnnotations){
                    System.out.println("Name: "+ myAnnotation.name());
                    System.out.println("Value : "+myAnnotation.value());
                    System.out.println();
                }
            }
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation= (MyAnnotation) annotation;
                System.out.println("Name: "+ myAnnotation.name());
                System.out.println("Value : "+myAnnotation.value());
                System.out.println();
            }
        }


        //Access Specific Annotation
        MyAnnotation annotation= (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
        if(annotation!=null)
        {
            System.out.println("Name: "+ annotation.name());
            System.out.println("Value : "+annotation.value());
            System.out.println();
        }

        //Method Annotations
        Method method= clazz.getMethod("checkAnnotationsOnMethods", String.class);
        MyAnnotation annotation1= method.getAnnotation(MyAnnotation.class) ;
        Annotation[] annotation2= method.getDeclaredAnnotations();

        System.out.println("Method has : "+ annotation2.length+" annotations");

        if (annotation1 != null) {
            System.out.println("Name: "+ annotation1.name());
            System.out.println("Value : "+annotation1.value());
            System.out.println();
        }

        //Parameter Annotations
        Annotation[][] parameterAnnotations = method.getParameterAnnotations(); // Array of annotation for each parameter type
        Class[] parameterTypes = method.getParameterTypes();

        int i=0;
        for(Annotation[] annotations1 : parameterAnnotations){
            Class parameterType = parameterTypes[i++];

            for(Annotation annotation12 : annotations1){
                if(annotation12 instanceof MyAnnotation){
                    MyAnnotation myAnnotation = (MyAnnotation) annotation12;
                    System.out.println("param: " + parameterType.getName());
                    System.out.println("name : " + myAnnotation.name());
                    System.out.println("value: " + myAnnotation.value());
                    System.out.println();
                }
            }
        }

        //Field Annotations
        Field field = clazz.getField("checkAnnotationField");
        Annotation[] anno = field.getDeclaredAnnotations();

        for(Annotation ann : anno){
            if(ann instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) ann;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
                System.out.println();
            }
        }

        Annotation ann = field.getAnnotation(MyAnnotation.class);
        if(ann instanceof MyAnnotation){
            MyAnnotation myAnnotation = (MyAnnotation) ann;
            System.out.println("name: " + myAnnotation.name());
            System.out.println("value: " + myAnnotation.value());
            System.out.println();
        }
    }


    @MyAnnotation(value = "checkAnnotationField", name = "method")
    public void checkAnnotationsOnMethods(@MyAnnotation(value = "HelloWorld", name = "hello") String hello){

    }
}
