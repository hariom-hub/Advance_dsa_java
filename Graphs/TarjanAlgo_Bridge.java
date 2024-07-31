package Advance_dsa_java.Graphs;

import java.util.*;

public class TarjanAlgo_Bridge {

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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int[] dt, int[] ldt, boolean[] visit, int time) {

        visit[curr] = true;
        dt[curr] = ldt[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            int neighbour = e.dest;
            //case  : 1
            if (par == neighbour) {
                continue;
            }
            //case : 2
            else if (!visit[neighbour]) {

                dfs(graph, neighbour, curr, dt, ldt, visit, time);
                ldt[curr] = Math.min(ldt[curr], ldt[neighbour]);
                if (dt[curr] < ldt[neighbour]) {
                    System.out.println("Bridge " + curr + "--------------->" + neighbour);
                }
            } else {
                ldt[curr] = Math.min(ldt[curr], dt[neighbour]);
            }
        }
    }

    public static void TarjanBridge(ArrayList<Edge>[] graph, int V) {

        int[] dt = new int[V];
        int ldt[] = new int[V];
        int time = 0;
        boolean[] visit = new boolean[V];

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                dfs(graph, i, -1, dt, ldt, visit, time);
            }
        }

    }

    public static void main(String[] args) {

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        TarjanBridge(graph, V);
    }
}