import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {

    private int[] nodes;

    QuickFindUF(int n) {
        nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return nodes[p] == nodes[q];
    }

    public void union(int p, int q) {
        int pid = nodes[p];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == pid)
                nodes[i] = nodes[q];
        }
    }

    public static void main(String[] args) throws Exception {
        int nodesSize = StdIn.readInt();
        QuickFindUF qf = new QuickFindUF(nodesSize);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!qf.connected(p, q)) {
                qf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
        StdOut.println(qf.connected(1, 6));
        StdOut.println(qf.connected(8, 0));

    }
}
