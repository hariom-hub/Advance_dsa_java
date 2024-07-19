package Advance_dsa_java.Graphs;

import java.util.*;

public class findAllPath {

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

    //recursively find the path from the source to the destination

    public static void Find_print_Path(ArrayList<Edge>[] graph, int src, int dest, String path) {

        if (src == dest) {
            System.out.println(path + src);
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            Find_print_Path(graph, e.dest, dest, path + src);
        }
    }

    public static void main(String[] args) {

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src = 5;
        int dest = 12;
        Find_print_Path(graph, src, dest, "");

    }
}