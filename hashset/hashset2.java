package Advance_dsa_java.hashset;
import java.util.*;

public class hashset2 {

    public static void main(String[] args){

        HashSet<String>cities = new HashSet<>();
        cities.add("Hatta");
        cities.add("Damoh");
        cities.add("Sagar");
        cities.add("Jabalpur");

        System.out.println(cities);

        LinkedHashSet<String>city = new LinkedHashSet<>();
        city.add("Poland");
        city.add("France");
        city.add("Russia");
        city.add("Portugal");
        System.out.println(city);
    }

}