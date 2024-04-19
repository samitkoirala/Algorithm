
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] perlocationThreshold;
    private int gridSize;

    public PercolationStats(int n, int trials) {
        Percolation per;
        gridSize = n;
        perlocationThreshold = new double[trials];
        for (int i = 0; i < trials; i++) {
            per = new Percolation(gridSize);
            do {
                int row = StdRandom.uniformInt(1, gridSize + 1);
                int column = StdRandom.uniformInt(1, gridSize + 1);
                if (!per.isOpen(row, column)) {
                    per.open(row, column);
                }
            } while ((!per.percolates()));
            perlocationThreshold[i] = per.numberOfOpenSites() / ((double) gridSize * (double) gridSize);
        }
    }

    public double mean() {
        return StdStats.mean(perlocationThreshold);
    }

    public double stddev() {
        return StdStats.stddev(perlocationThreshold);
    }

    public double confidenceLo() {
        return StdStats.mean(perlocationThreshold) - StdStats.stddev(perlocationThreshold);
    }

    public double confidenceHi() {
        return StdStats.mean(perlocationThreshold) + StdStats.stddev(perlocationThreshold);
    }

    public static void main(String[] args) {
        int gridSize = Integer.parseInt(args[0]);
        int repetitions = Integer.parseInt(args[1]);
        PercolationStats perStats = new PercolationStats(gridSize, repetitions);

        StdOut.println("mean                    = " + perStats.mean());
        StdOut.println("stddev                  = " + perStats.stddev());
        StdOut.println("95% confidence interval = ["
                + perStats.confidenceLo()
                + ", " + perStats.confidenceHi());
    }
}
