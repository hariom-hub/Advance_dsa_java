package Advance_dsa_java.Graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class connectCities {


    static class Edge implements Comparable<Edge> {

        int cost;
        int dest;

        public Edge(int cost, int dest) {
            this.cost = cost;
            this.dest = dest;
        }

        @Override

        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }


    public static int connectCities(int[][] cities) {

        int finalCost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[cities.length];

        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {

            Edge curr = pq.remove();
            if (!visit[curr.dest]) {
                visit[curr.dest] = true;
                finalCost += curr.cost;
                for (int i = 0; i < cities[curr.dest].length; i++) {

                    if (cities[curr.dest][i] != 0) {
                       pq.add(new Edge(cities[curr.dest][i],i));
                    }
                }
            }
        }

       return finalCost;
    }

    public static void main(String[] args) {

        int cities[][] = {{0, 1, 2, 3, 4}, {1, 0, 5, 0, 7}, {2, 5, 0, 6, 0}, {3, 0, 6, 0, 0}, {4, 7, 0, 0, 0}};
        System.out.println("minimum cost to connect the cities : " + connectCities(cities));
    }
}