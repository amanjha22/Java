package Reflections;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    public String name() default  "default";
    public String value() default "default";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotations{
    MyAnnotation[] value();
}