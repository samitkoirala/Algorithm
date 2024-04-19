import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnion {

    int[] nodes;

    QuickUnion(int n) {
        nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
    }

    public int root(int n) {
        while (n != nodes[n])
            n = nodes[n];
        return n;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        nodes[rootp] = rootq;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnion qu = new QuickUnion(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!qu.connected(p, q)) {
                qu.union(p, q);
                System.out.println(p + " " + q);
            }
        }
        StdOut.println(qu.connected(1, 6));
        StdOut.println(qu.connected(8, 0));

    }

}
