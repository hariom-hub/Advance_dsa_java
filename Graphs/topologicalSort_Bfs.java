package Advance_dsa_java.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class topologicalSort_Bfs {

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
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void CalculateIndegree(ArrayList<Edge> graph[], int[] indegree) {

        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static void TopSortBfs(ArrayList<Edge>[] graph) {

        int[] indegree = new int[graph.length];
        Queue<Integer> qu = new LinkedList<>();
        CalculateIndegree(graph,indegree);
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                qu.add(i);
            }
        }
        //bfs

        while (!qu.isEmpty()) {
            int curr = qu.remove();
            System.out.println(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    qu.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {


        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        TopSortBfs(graph);
    }
}