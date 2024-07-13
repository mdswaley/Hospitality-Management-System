package org.example.Practice;

public class DynamicMethod {

    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 = new B();
        obj1.hello();
        obj2.hello();


    }
}
class A{
    public void hello(){
        System.out.println("Hello");
    }
}
class B extends A{
    @Override
    public void hello(){
        System.out.println("swaley");
    }
}
