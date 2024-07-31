package Advance_dsa_java.Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class kruskalAlgo {

    static class Edge implements Comparable<Edge> {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {

            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge e2) {
            return this.weight - e2.weight;
        }
    }

    static int n = 4;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {

        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {

        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parB]++;

        } else if (rank[parA] < rank[parB]) {

            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

    }

    public static void kruskalMst(ArrayList<Edge> edges, int V) {

        int mstCost = 0;
        Collections.sort(edges);
        int count = 0;
        for (int i = 0; count < V - 1; i++) {

            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.weight;
                count++;
            }
        }
        System.out.println("cost of minimum spannig tree :" + mstCost);

    }

    public static void main(String[] args) {

        init();

        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalMst(edges, v);
    }
}