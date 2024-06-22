package Advance_dsa_java.HashMaps;

import java.lang.reflect.Array;
import java.util.*;


public class hashmapImplement {

    static class HashMap<K, V> {

        private class Node {

            K key;
            V value;

            public Node(K key, V value) {
                this.value = value;
                this.key = key;
            }
        }

        private int N; // size of the bucket
        private int n;
        private LinkedList<Node> buckets[]; //

        @SuppressWarnings("unchecked")

        public HashMap() {

            this.N = 5;
            this.buckets = new LinkedList[5];

            for (int i = 0; i < 5; i++) {

                this.buckets[i] = new LinkedList<>();

            }
        }

        public int hashFunction(K key) {

            int hc = key.hashCode();
            return Math.abs(hc) % N;
            //Math.abs(hc) % size means if a number is divided with 4 the remainder obtained ranges from 0 to 3 which

        }

        public int getKeyLL(K Key, int bi) {

            int di = 0;
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {

                Node node = ll.get(i);
                if (node.key == Key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        public void put(K key, V value) {

            int bi = hashFunction(key); //bucket index
            int di = getKeyLL(key, bi);   // data index

            if (di != -1) {

                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }

        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldbucket[] = buckets;

            buckets = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            //nodes add in the bucket

            for (int i = 0; i < oldbucket.length; i++) {
                LinkedList<Node> ll = oldbucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public V remove(K key) {

            int bi = hashFunction(key);
            int di = getKeyLL(key, bi);

            if (di != -1) {

                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = getKeyLL(key, bi);

            if (di != 1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {

            int bi = hashFunction(key);
            int di = getKeyLL(key, bi);

            if (di != 1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {

            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {

            return n == 0;
        }

    }

    public static void main(String[] args) {


        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Japan", 200);
        hm.put("Singapore", 250);
        hm.put("Vietnam", 300);

        ArrayList<String> keys = hm.keySet();
        for (String str : keys) {
            System.out.println("keys = "+str+" values = "+hm.get(str));
        }




    }
}
