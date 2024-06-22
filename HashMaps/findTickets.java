package Advance_dsa_java.HashMaps;

import java.util.HashMap;

public class findTickets {

    public static String getTickets(HashMap<String, String> tickets) {

        HashMap<String, String> revMap = new HashMap<>();

        for (String str : tickets.keySet()) {

            revMap.put(tickets.get(str), str);
        }

        for (String key : tickets.keySet()) {

            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("chennai", "bengaluru");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");

        String order = getTickets(tickets);
        System.out.print(order);
        for (String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(key));
        }
    }

}