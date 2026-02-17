package Percolation;

import java.util.Arrays;

public class QuickFind {

    private int[] arr;

    public QuickFind(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    public void union(int p, int q) {

        int combination = arr[q];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == combination) {
                arr[i] = arr[p];
            }
        }
        return;
    }

    public int find(int p) {
        return arr[p];
    }

    public boolean connected(int p, int q) {
        return arr[p] == arr[q];
    }

    public String toString() {
        String s = "";

        return s;
    }

    public static void main(String[] args) {
        QuickFind q = new QuickFind(5);
        boolean[] expected = new boolean[] { true };
        boolean[] actual = new boolean[expected.length];

        long startTime = System.nanoTime();
        q.union(1, 2);
        q.union(3, 1);
        q.union(0, 4);

        actual[0] = q.connected(0, 4);

        System.out.println("Execution Time: " + ((double) System.nanoTime() - startTime) / 1e9);
        System.out.println(Arrays.equals(expected, actual));
    }
}
