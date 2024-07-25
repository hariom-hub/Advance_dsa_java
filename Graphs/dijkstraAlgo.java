package Advance_dsa_java.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstraAlgo {

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

    public static void crateGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {

            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }


    static class Pair implements Comparable<Pair> {

        int n;
        int path;

        public Pair(int n, int path) {

            this.n = n;
            this.path = path;
        }

        @Override

        public int compareTo(Pair p2) {

            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {

        int distance[] = new int[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < graph.length; i++) {

            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();
           

            for (int i = 0; i < graph[curr.n].size(); i++) {

                Edge e = graph[curr.n].get(i);

                int u = e.src;
                int v = e.dest;
                int weight = e.weight;

                if (distance[u] + weight < distance[v]) {
                    //update
                    distance[v] = distance[u] + weight;
                    pq.add(new Pair(v, distance[v]));
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println(distance[i]);
        }
    }

    public static void main(String[] args) {

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        crateGraph(graph);
        int src = 0;
        dijkstra(graph, src);

    }
}