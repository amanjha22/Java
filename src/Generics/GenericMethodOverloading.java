package Generics;

import java.util.List;

public class GenericMethodOverloading {

    //The below code snippet throws errors of type erasure(name clash), as java can-not find the difference between two generic types
    /*
    public void getList(List<String> strings){

    }

    public void getList(List<Integer> integers){

    }
    */

    public static <T extends Integer> T getValue(T Val){
        return null;
    }

    public static  <T extends Number> T getValue(T val){
        return null;
    }


    /*
    public static <T extends Integer> T getValue(){ // This method gives an error of type erasure, same should happen with the above two methods
        return null;                                // but they work just fine, why such ir-radical behaviour. Explanation??
    }

    public static  <T extends Number> T getValue(){ //Type erasure clash with this method
        return null;
    }
    */
}
