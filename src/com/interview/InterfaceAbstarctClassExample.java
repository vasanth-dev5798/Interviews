package com.interview;

public class InterfaceAbstarctClassExample extends AbstractClass implements InterfaceExample {


    @Override
    public void interfaceMethod() {
        System.out.println("Implementation of interface method");
    }

    @Override
    void abstractMethod() {
        System.out.println("Implementation of Abstract method");
    }

    @Override
    void abstractMethod2() {
        System.out.println("Implementation of Abstract method 2");
    }

    @Override // This method is implemented from the interface and without the @Override annotation, 
    // it would still be valid, but using @Override helps to catch errors at compile time 
    // if the method signature does not match the interface method.
    public void interfaceabstractMethod() {
        System.out.println("Implementation of interface abstract method");
    }

    public InterfaceAbstarctClassExample() {
        super(); // calling the constructor of the abstract class
        //this(10); // cannot call this() and super() in the same constructor, so calling this() after super()
        System.out.println("InterfaceAbstarctClassExample constructor called");
    }

    @Override
    public void callMe() { // to call the concrete method form interface than class wins
    // Explicitly target the interface's default implementation
    InterfaceExample.super.callMe();
    // Explicitly target the abstract class's concrete implementation
    }
    
    public static void main(String[] args) {
        InterfaceAbstarctClassExample example = new InterfaceAbstarctClassExample();
        example.abstractMethod();
        example.interfaceMethod();
        example.interfaceabstractMethod();
        example.callMe(); //class wins over interface , call a concrete method from abstract clas
        // until the we are calling the concrete method from interace with super keyword.
        example.setX(5);
        System.out.println("Value of x: " + example.getX());
        int staticValue = InterfaceExample.staticMethod();
        System.out.println("Static value: " + staticValue);

        InterfaceExample in = new InterfaceAbstarctClassExample(); // interface reference can hold the object of the 
        // class that implements it

        in.callMe(); // still class wins over interface , call a concrete method from abstract clas

        //int defaultValue = example.setXvalue(15); // calling default method from interface
        // System.out.println("Default method returned value: " + defaultValue);

       // AbstractClass abstractClass = new AbstractClass(); // you cannot instantiate an abstract class
       //InterfaceExample interfaceExample = new InterfaceExample(); // you cannot instantiate an interface
       }
}


abstract class AbstractClass {
    int x; // can have instance variables in abstract class

    public AbstractClass() { //can have constructor in abstract class
        System.out.println("Abstract class constructor called");
        this.x = 0;
    }

    public AbstractClass(int x) { // can have parameterized constructor in abstract class
        this.x = x; // constructor can be used to initialize the state of the abstract class
    }

    abstract void abstractMethod();
    abstract void abstractMethod2(); // can have multiple abstract methods
 
    public void callMe() { // can have concrete methods in abstract class
        System.out.println("This is a concrete method in the abstract class");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

interface InterfaceExample {
    int x = 10; // by default public static final

    //public InterfaceExample() { // can not have constructor in interface
    //}

    void interfaceMethod();// by default public abstract
    abstract void interfaceabstractMethod();
    //abstract void interfaceabstractMethod2(); // can have multiple abstract methods

    public default void callMe() {
        System.out.println("This is a default method in the interface");
    }

    static int staticMethod() {
        System.out.println("This is a static method in the interface");
        return 10;
    }

    default int setXvalue(int n) { // default method can have implementation
       // x = n; // this line will cause a compilation error because x is final in interface
        return n;
    }
}