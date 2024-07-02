package Advance_dsa_java.Graphs;

import java.sql.Statement;
import java.util.*;

public class topologicalSort {

    static class Edge {

        int src;
        int dest;

        public Edge(int s, int d) {

            this.src = s;
            this.dest = d;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {

            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));


    }

    public static void TopologicalSort(ArrayList<Edge>[] graph) {

        boolean visit[] = new boolean[graph.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                TopologicalSortUtil(graph, i, visit, stk);
            }
        }
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }

    }

    public static void TopologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visit, Stack<Integer> stk) {

        visit[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            if (!(visit[e.dest])) {
                TopologicalSortUtil(graph, e.dest, visit, stk);
            }
        }
        stk.add(curr);

    }

    public static void main(String[] args) {

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraph(graph);
        TopologicalSort(graph);

    }
}