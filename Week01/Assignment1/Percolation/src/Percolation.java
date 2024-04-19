import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] grid;
    private WeightedQuickUnionUF index;
    private int numberOfOpenSites;
    private int inputLength;

    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        numberOfOpenSites = 0;
        inputLength = n;
        grid = new int[n][n];
        index = new WeightedQuickUnionUF(n * n + 2);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = 0;

    }

    public void open(int p, int q) {
        if (p < 1 || p > inputLength || q < 1 || q > inputLength) {
            throw new IllegalArgumentException();
        }

        grid[p - 1][q - 1] = 1;
        numberOfOpenSites++;
        if (p == 1) {
            index.union(0, getIndex(p, q));
        }
        if (p == inputLength) {
            index.union(inputLength * inputLength + 1, getIndex(p, q));
        }
        if (p > 1 && isOpen(p - 1, q)) {
            index.union(getIndex(p, q), getIndex(p - 1, q));
        }
        if (q > 1 && isOpen(p, q - 1)) {
            index.union(getIndex(p, q), getIndex(p, q - 1));
        }
        if (p < inputLength && isOpen(p + 1, q)) {
            index.union(getIndex(p, q), getIndex(p + 1, q));
        }
        if (q < inputLength && isOpen(p, q + 1)) {
            index.union(getIndex(p, q), getIndex(p, q + 1));
        }
    }

    public boolean isOpen(int p, int q) {
        if (p > inputLength || q > inputLength || p <= 0 || q <= 0) {
            throw new IllegalArgumentException();
        }
        return grid[p - 1][q - 1] > 0;
    }

    public boolean isFull(int p, int q) {
        if (p < 1 || p > inputLength || q < 1 || q > inputLength) {
            throw new IllegalArgumentException();
        }
        return index.find(0) == index.find(getIndex(p, q));
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public boolean percolates() {
        return index.find(0) == index.find(inputLength * inputLength + 1);
    }

    private int getIndex(int p, int q) {
        return inputLength * (p - 1) + q;
    }

    public static void main(String[] args) {

    }
}
