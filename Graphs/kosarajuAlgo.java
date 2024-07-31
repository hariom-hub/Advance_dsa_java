package Advance_dsa_java.Graphs;

import java.util.*;

public class kosarajuAlgo {

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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] visit, Stack<Integer> stk) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) {
                topSort(graph, e.dest, visit, stk);
            }
        }
        stk.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visit) {
        visit[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) {
                dfs(graph, e.dest, visit);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge>[] graph, int V) {
        Stack<Integer> stk = new Stack<>();
        boolean[] visit = new boolean[V];

        // Step 1: Perform topological sort
        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                topSort(graph, i, visit, stk);
            }
        }

        // Step 2: Transpose the graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            visit[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);

                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3: Perform DFS based on finishing times in stack

        while (!stk.isEmpty()) {
            int curr = stk.pop();
            if (!visit[curr]) {
                System.out.print("SCC -> ");
                dfs(transpose, curr, visit);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}
