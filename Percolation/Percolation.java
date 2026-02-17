package Percolation;

public class Percolation {

    private int[][] arr;

    private QuickUnion QuickUnion;

    /**
     * Creates n x n grid with all sites blocked
     * 
     * @param n dimensions of grid
     */
    public Percolation(int n) {
        arr = new int[n][n];
        QuickUnion qU = new QuickUnion((n * n) + 2);
    }

    /**
     * Opens a site
     * 
     * @param row
     * @param col
     */
    public void open(int row, int col) {

    }

    public boolean isOpen(int row, int col) {
        return arr[row][col] >= 1;
    }

    public boolean isFull(int row, int col) {
        return arr[row][col] == 2;
    }

    public int numberOfOpenSites() {
        int count = 0;
        for (int[] is : arr) {
            for (int i : is) {
                if (i >= 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean percolates() {

        return false;
    }

    public String toString() {
        return "";
    }
}
