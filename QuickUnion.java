import java.util.Arrays;

public class QuickUnion {
    int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public void union(int q, int p) {
        id[root(q)] = root(p);
    }

    public int root(int p) {
        int i = p;
        while (true) {
            if (id[i] == i) {
                return i;
            } else {
                i = id[i];
            }
        }

    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        QuickUnion q = new QuickUnion(5);
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
