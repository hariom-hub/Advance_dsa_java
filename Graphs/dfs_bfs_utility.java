package Advance_dsa_java.Graphs;

import java.lang.reflect.Array;
import java.util.*;


public class dfs_bfs_utility {

    static class Edge {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void Bfs_utility(ArrayList<Edge> graph[], boolean[] visit) {

        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);

        while (!qu.isEmpty()) {

            int curr = qu.remove();

            if (!visit[curr]) {

                System.out.print(curr + " ");
                visit[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    qu.add(e.dest);
                }
            }
        }
    }

    public static void Dfsutility(ArrayList<Edge> graph[], int curr, boolean[] visit) {


        visit[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph.length; i++) {

            Edge e = graph[curr].get(i);

            if (!visit[e.dest]) {

                Dfsutility(graph, e.dest, visit);
            }
        }

    }


    public static void dfs(ArrayList<Edge> graph[]) {


        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            Dfsutility(graph, i, visit);
        }
    }
i
    public static void bfs(ArrayList<Edge> graph[]) {

        boolean[] visit = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                Bfs_utility(graph, visit);
            }
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 4, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void main(String[] args) {


    }
}