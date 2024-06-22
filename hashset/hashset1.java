package Advance_dsa_java.hashset;
import java.util.*;

public class hashset1 {

    public static void main(String[] args){

        HashSet<String>hs = new HashSet<>();
        hs.add("Hariom");
        hs.add("gaurisha");
        hs.add("shreesha");
        hs.add("pandit");
        //Iterator
//        Iterator it = hs.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
        //advanced loops
        for(String str : hs){
            System.out.println(str);
        }

    }
}

