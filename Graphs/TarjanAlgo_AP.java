package Advance_dsa_java.Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TarjanAlgo_AP {

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

        //undirected graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }


    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int[] dt, int[] ldt, int time, boolean[] visit, boolean[] ap) {

        visit[curr] = true;
        dt[curr] = ldt[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            int neighbour = e.dest;

            if (par == neighbour) {
                continue;
            } else if (visit[neighbour]) {
                ldt[curr] = Math.min(ldt[curr], dt[neighbour]);
            } else {
                //neighbour not visited
                dfs(graph, neighbour, curr, dt, ldt, time, visit, ap);
                ldt[curr] = Math.min(ldt[curr], ldt[neighbour]);
                if (par != -1 && dt[curr] <= ldt[neighbour]) {
//                    System.out.println("AP->" + curr);
                    ap[curr] = true;
                }
                children++;
            }
            if (par == -1 && children > 0) {
                ap[curr] = true;
            }
        }
    }


    public static void getAP(ArrayList<Edge>[] graph, int V) {

        boolean[] visit = new boolean[V];
        int[] dt = new int[V];
        int[] ldt = new int[V];
        int time = 0;
        boolean[] ap = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                dfs(graph, i, -1, dt, ldt, time, visit, ap);
            }
        }

        //print ap

        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("AP->" + i);
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        getAP(graph, V);

    }
}