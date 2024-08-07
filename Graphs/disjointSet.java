package Advance_dsa_java.Graphs;

public class disjointSet {

    static int n = 7;
    static int[] par = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return find(par[x]);
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

    public static void main(String[] args) {

        init();
        union(1,5);
        System.out.println(find(5));
        union(3,4);
        System.out.println(find(4));
    }

}