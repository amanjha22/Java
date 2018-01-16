package Collections.Set;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {
    public static void main(String[] args) {
        NavigableSet<Integer> set= new TreeSet<>();
        set.add(1);
        set.add(6);
        set.add(7);
        set.add(9);
        set.add(8);

        System.out.println(set.floor(3));
        System.out.println(set.ceiling(3));

        System.out.println(set.lower(3));
        System.out.println(set.higher(3));

        System.out.println(set.tailSet(7,false));
        System.out.println(set.headSet(7,true));

        System.out.println(set);
    }
}
