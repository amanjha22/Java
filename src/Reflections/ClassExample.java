package Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ClassExample implements Runnable {

    private int intField=0;
    public final long longField=0;
    protected static String stringField="";
    public static double DOUBLE_FIELD=0.0;

    public ClassExample(){

    }

    public ClassExample(int x) {

    }

    private ClassExample(Long y){ // This constructor is not returned by class.getConstructors as this is private

    }

    public ClassExample(ClassExample e, Long y){

    }

    public static void main(String[] args) throws ClassNotFoundException {
        String className="Reflections.ClassExample" ;
        Class clazz= Class.forName(className);
        Class clazz2= ClassExample.class;

        if(clazz==clazz2)
            System.out.println("Same object from both methods"); // both the methods return same instance of class object, thus classes are  singleton object
        else
            System.out.println("Different object from both methods");

        System.out.println("Class Name: "+ clazz.getName());
        System.out.println("Simple Class Name: "+ clazz.getSimpleName());
        System.out.println("Canonical Class Name: "+ clazz.getCanonicalName());

        int modifiers=clazz.getModifiers();
        System.out.println("Modifier value: "+ modifiers);


        //Access Modifiers
        System.out.println("Is Abstract: "+ Modifier.isAbstract(modifiers));
        System.out.println("Is Final: "+ Modifier.isFinal(modifiers));
        System.out.println("Is Interface: "+ Modifier.isInterface(modifiers));
        System.out.println("Is Native: "+ Modifier.isNative(modifiers));
        System.out.println("Is Private: "+ Modifier.isPrivate(modifiers));
        System.out.println("Is Protected: "+ Modifier.isProtected(modifiers));
        System.out.println("Is Public: "+ Modifier.isPublic(modifiers));
        System.out.println("Is Static: "+ Modifier.isStatic(modifiers));
        System.out.println("Is Synchronized: "+ Modifier.isSynchronized(modifiers));
        System.out.println("Is Strict: "+ Modifier.isStrict(modifiers));
        System.out.println("Is Transient: "+ Modifier.isTransient(modifiers));
        System.out.println("Is Volatile: "+ Modifier.isVolatile(modifiers));

        Package pack  = clazz.getPackage();
        System.out.println("Package Name: " + pack.getName());

        //Super Class
        Class superClass= clazz.getSuperclass();
        System.out.println("Super Class Name: " + superClass.getName());

        //Interface: interfaces are also returned as class objects
        Class[] interfaces= clazz.getInterfaces();
        System.out.println(interfaces.length + " interfaces implemented by this class");
        for(Class interfaze : interfaces){
            System.out.println("Interface : "+ interfaze.getName());
        }


        //Constructors
        Constructor[] constructors =clazz.getConstructors(); // this method only returns public constructors
        System.out.println(constructors.length + " constructors implemented by this class");
        for(Constructor constructor : constructors){
            System.out.println("Constructor  with : "+ constructor.getParameterCount() + " Parameters");
            if(constructor.getParameterCount()!=0)
                System.out.println("Param Types: " + Arrays.stream(constructor.getParameterTypes()).map(e-> e.getName()).collect(Collectors.toList()));
        }

        //Methods:
        Method[] methods= clazz.getMethods();
        System.out.println("The class implements: " +methods.length +" methods\n");
        for(Method method: methods){
            System.out.println("Method Name : "+method.getName());
            System.out.println("Return Type : "+method.getReturnType().getName());
            System.out.println("Exception Types : "+ Arrays.stream(method.getExceptionTypes()).map(e-> e.getName()).collect(Collectors.toList()));
            System.out.println("Parameter Count : "+method.getParameterCount());
            System.out.println("Parameter Types : " + Arrays.stream(method.getParameterTypes()).map(e-> e.getName()).collect(Collectors.toList()));
            System.out.println();
        }

    }

    @Override
    public void run() {
        //DO NOTHING
    }

    private int checkAccess(){return 0;}

    public int checkInvocation(){
        return 10;
    }

    public long checkInvocation(long x){
        return x;
    }
}
