package org.example.CollectionFramework;

public class Gadget {
    private String name;
    private double price;

    public Gadget(String name,double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Gadget{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
