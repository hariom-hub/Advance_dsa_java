
package Practice;
import java.util.*;
public class oop{


    abstract class Galaxy {

        abstract void Planet();
        
    }
    public class Sun extends Galaxy{
        public  void Planet(){
            System.out.println("this is a Sun.");
        }
    }
    public static class Data{

        String name;
        int age;

        public void GetData(){
            System.out.println(this.name);
            System.out.println(this.age);
        }
        // constructor
        public Data(String name, int age){
            this.age = age;
            this.name = name;
        }
        // passing constructor as argument
        // there is no destructor in java because of garbage collector
        
        public Data(Data d){
            System.out.println(d.age);
            System.out.println(d.name);
        }

    }
    public static void main(String[] args){
        System.out.println("hello hariom");
        Data d1= new Data("harru",20);
        Data d2 = new Data(d1);
        
        
       
        
    }
}