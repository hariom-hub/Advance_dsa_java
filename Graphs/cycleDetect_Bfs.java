package Advance_dsa_java.Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cycleDetect_Bfs {

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
//        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
//        graph[1].add(new Edge(1, 2));

//        graph[2].add(new Edge(2, 0));
//        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(3, 4));


    }


    public static boolean isCycle(ArrayList<Edge>[] graph, int V) {

        int parent[] = new int[graph.length];
        boolean[] visit = new boolean[graph.length];

        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                if (bfsCycleDetect(graph, i, visit, parent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfsCycleDetect(ArrayList<Edge>[] graph, int start, boolean[] visit, int[] parent) {


        parent[start] = -1;
        visit[start] = true;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);

        while (!qu.isEmpty()) {

            int curr = qu.poll();

            for (Edge e : graph[curr]) {

                int neighbour = e.dest;
                if (!visit[neighbour]) {
                    visit[neighbour] = true;
                    parent[neighbour] = curr;
                    qu.add(neighbour);
                }else if(parent[curr] != neighbour){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph, V));

    }

}