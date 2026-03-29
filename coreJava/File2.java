package coreJava;
import java.util.*;

public class File2 {

    public static class Parent{

       Parent(){
        System.out.println("This is the Parent Constructor.");
       }
    }

    public static class Child extends Parent{
        
        Child(){
            super();
            System.out.println("This is a child constructor.");

        }
    }
    public static void main(String[] args) {
        
        Child c = new Child();
        
    }
}