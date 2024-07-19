package Advance_dsa_java.Graphs;

import java.util.*;

public class dijkstraAlgo {

    static class Edge {

        int src;
        int dest;

        public Edge(int src, int dest) {

            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {

            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    static class Pair implements Comparable<Pair> {

        int node;
        int path;

        public Pair(int node, int path) {

            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {

            return this.path - p2.path;
        }
    }

    public static void DijkstraAlgo(ArrayList<Edge>[] graph, int src) {


        int[] dist = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean []visit = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()){

            Pair curr = pq.remove();
            if (!visit[curr.node]){
                visit[curr.node] = true;
                for (int i=0;i<graph[curr.node].size();i++){

                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                }
            }
        }

    }

    public static void main(String[] args) {

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

    }
}