package coreJava;
import java.util.*;
import java.util.UUID;

public class File1 {

    public static void main(String[] args) {
        
        int []a = new int[5];
        int result = 10/0;
        try{

            System.out.println(a[5]);
            
            System.out.println(result);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
    }
}