import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnion {
    int[] nodes;
    int[] sizenodes;

    WeightedQuickUnion(int n) {
        nodes = new int[n];
        sizenodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
            sizenodes[i] = 1;
        }
    }

    public int root(int p) {
        while (p != nodes[p])
            p = nodes[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (sizenodes[p] > sizenodes[q]) {
            nodes[rootq] = rootp;
            sizenodes[rootp] += sizenodes[rootq];
        } else {
            nodes[rootp] = rootq;
            sizenodes[rootq] += sizenodes[rootp];
        }
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnion qu = new WeightedQuickUnion(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!qu.connected(p, q)) {
                qu.union(p, q);
                System.out.println(p + " " + q);
                StdOut.println("size p= " + qu.sizenodes[p] + " size q= " + qu.sizenodes[q]);
            }
        }
        StdOut.println(qu.connected(1, 6));
        StdOut.println(qu.connected(8, 0));

    }
}
