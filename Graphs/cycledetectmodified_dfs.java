package Advance_dsa_java.Graphs;

import javax.swing.text.SimpleAttributeSet;
import java.util.ArrayList;
import java.util.Stack;

public class cycledetectmodified_dfs {

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
//        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 2));

        //will return true;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {

        boolean[] visit = new boolean[graph.length];
        boolean[] stk = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (isCycleUtil(graph, stk, i, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] stk, int curr, boolean[] visit) {

        visit[curr] = true;
        stk[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            //case 1 : if the neighbour haven't visited

            if (!visit[e.dest] && isCycleUtil(graph, stk, e.dest, visit)) {
                return true;
            }
            if (stk[e.dest]) {
                return true;
            }
        }
        stk[curr] = false;
        return false;
    }

    public static void main(String[] args) {


        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));

    }
}