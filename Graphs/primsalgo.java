package Advance_dsa_java.Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class primsalgo {

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

    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {

            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));


    }

    static class Pair implements Comparable<Pair> {

        int v;  //vertices
        int cost; //cost for the mst

        public Pair(int v, int cost) {

            this.v = v;
            this.cost = cost;
        }

        @Override

        public int compareTo(Pair p2) {

            return this.cost - p2.cost;
        }
    }


    public static void PrimsAlgorithm(ArrayList<Edge>[] graph) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int finalCost = 0;

        boolean[] visit = new boolean[graph.length];

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            finalCost += curr.cost;

            if (!visit[curr.v]) {

                visit[curr.v] = true;
                for (int i = 0; i < graph[curr.v].size(); i++) {

                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.src, e.weight));
                }
            }
        }
        System.out.println(finalCost);
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        PrimsAlgorithm(graph);
    }
}