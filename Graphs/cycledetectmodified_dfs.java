package Advance_dsa_java.Graphs;

import java.util.*;

public class cycledetectmodified_dfs {

    static class Edge {

        int src;
        int dest;

        public Edge(int src, int dest) {

            this.src = src;
            this.dest = dest;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));


    }


    public static boolean isCycle(ArrayList<Edge>[] graph) {

        boolean[] visit = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];


        for (int i = 0; i < graph.length; i++) {

            if (!visit[i]) {
                if (isCycleUtil(graph, i, visit, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] visit, boolean[] stack) {

        visit[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            if (stack[e.dest]) {
                return true;
            }

            if (!visit[e.dest] && isCycleUtil(graph, e.dest, visit, stack)) {

                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {


        int V = 4;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraph(graph);
        System.out.println(isCycle(graph));


    }
}