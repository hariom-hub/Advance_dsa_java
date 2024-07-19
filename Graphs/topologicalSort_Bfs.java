package Advance_dsa_java.Graphs;

import java.util.*;


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

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(2, 0));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

    }

    public static void calculateIndegree(ArrayList<Edge>[] graph, int[] indegree) {

        for (int i = 0; i < graph.length; i++) {

            int v = i;

            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static void Topsort_Bfs(ArrayList<Edge>[] graph) {

        int[] indegree = new int[graph.length];
        Queue<Integer> qu = new LinkedList<>();

        calculateIndegree(graph, indegree);

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                qu.add(i);    // adding those vertices whose indegree is equal to zero
            }
        }

        //bfs

        while (!qu.isEmpty()) {

            int curr = qu.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {

                Edge e = graph[curr].get(i);
                // reducing indegree of destination by 1 because one path of reaching it has already been removed from the queue
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    qu.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        Topsort_Bfs(graph);
    }
}