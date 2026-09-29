package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConstructorCheck implements Comparable<ConstructorCheck> {

    int id;
    String name;

    public ConstructorCheck(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(ConstructorCheck arg0) {
        if (this.id < arg0.id) {
            return -1;
        } else if (this.id > arg0.id) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Main {
    public static void main(String[] args) {
        ConstructorCheck obj = new ConstructorCheck(1, "John");
        // System.out.println("ID: " + obj.id + ", Name: " + obj.name);

        // ConstructorCheck obj2 = new ConstructorCheck(); // This line will cause a
        // compilation error because there
        // is no default constructor defined in ConstructorCheck class

        ConstructorCheck obj1 = new ConstructorCheck(6, "Arun");
        ConstructorCheck obj2 = new ConstructorCheck(9, "Doe");
        ConstructorCheck obj3 = new ConstructorCheck(4, "Smith");

        List<ConstructorCheck> list = new ArrayList<>();
        list.add(obj);
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);

        System.out.println("Before Sorting");
        for (ConstructorCheck temp : list) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name);
        }
        Collections.sort(list); // for natural ordering only one compareTo method is needed to be implemented in
                                // the class

        System.out.println("After Sorting");
        for (ConstructorCheck temp : list) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name);
        }

        Collections.sort(list, new NameComparator()); // for custom ordering a separate comparator class is needed
                                                        // to be implemented

        System.out.println("After Sorting by Name");
        for (ConstructorCheck temp : list) {    
            System.out.println("ID: " + temp.id + ", Name: " + temp.name);
        }

    }
}


class NameComparator implements Comparator<ConstructorCheck> {
    @Override
    public int compare(ConstructorCheck o1, ConstructorCheck o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


//public class Test {} // class name should be same as file name, so this class should be in Test.java file
