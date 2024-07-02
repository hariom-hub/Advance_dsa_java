package Advance_dsa_java.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bipartiteGraph {

    static class Edge {

        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,2));

    }

    public static int graphsize(ArrayList<Edge>[] graph) {

        int nodeCount = 0;

        for (int i = 0; i < graph.length; i++) {

            nodeCount++;
        }
        return nodeCount;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {

        int[] color = new int[graph.length];


        for (int i = 0; i < color.length; i++) {

            color[i] = -1;
        }

        Queue<Integer> qu = new LinkedList<>();


        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {

                qu.add(i);
                color[i] = 0;
                while (!qu.isEmpty()) {

                    int curr = qu.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {

                        Edge e = graph[curr].get(j);

                        if (color[e.dest] == color[curr] && graphsize(graph) % 2 != 0) {
                            return false;
                        } else if (color[e.dest] == -1) {

                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            qu.add(e.dest);
                        }

                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
