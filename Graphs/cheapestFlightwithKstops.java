package Advance_dsa_java.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class cheapestFlightwithKstops {
    static class Edge {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {

            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(int[][] flights, ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {

            int src = flights[i][0];
            int dest = flights[i][1];
            int weight = flights[i][2];

            Edge e = new Edge(src, dest, weight);
            graph[src].add(e);
        }
    }

    static class Info {

        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {

            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapestFlight(int n, int[][] flights, int src, int dest, int k) {

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[graph.length];
        for (int i = 0; i < n; i++) {
            if (i != src) {

                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> qu = new LinkedList<>();

        qu.add(new Info(src, 0, 0));

        while (!qu.isEmpty()) {

            Info curr = qu.remove();
            //if curr.stops > k then it is a false condition then we return -1
            if (curr.stops > k) {
//                return  -1;
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {

                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;

                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    //update
                    dist[v] = curr.cost + wt;
                    qu.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }

    }

    public static void main(String[] args) {

        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dest = 3;
        int k = 1;
        System.out.println("cheapest cost is : "+cheapestFlight(n,flights,src,dest,k));

    }
}