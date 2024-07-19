package Advance_dsa_java.Graphs;//package Advance_dsa_java.Graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Bfs {


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

    public static void bfs(ArrayList<Edge>[]graph){

        Queue<Integer>qu = new LinkedList<>();
        boolean []visit = new boolean[graph.length];
        qu.add(0);

        while (!qu.isEmpty()){

            int curr = qu.remove();
            if (!visit[curr]){
                System.out.print(curr+" ");
                visit[curr] = true;
                for (int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);//get the neighbours of the curr node
                    qu.add(e.dest);
                }
            }


        }
    }

    public static void main(String[] args) {


        int V = 7;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 4, 0));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        graph[4].add(new Edge(4, 2, 0));
        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 5, 0));

        graph[5].add(new Edge(5, 3, 0));
        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 6, 0));

        graph[6].add(new Edge(6,5,0));


        bfs(graph);

    }
}