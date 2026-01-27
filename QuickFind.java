import java.util.ArrayList;
import java.util.Arrays;

public class QuickFind {

    private int[] arr;

    private int nextGroup = 0;

    public QuickFind(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = -1;
        }
    }

    public void union(int p, int q) {
        int pGroup = arr[p];
        int qGroup = arr[q];

        if (pGroup == -1 && qGroup == -1) {
            arr[p] = nextGroup;
            arr[q] = arr[p];
            nextGroup++;
            return;
        }
        if (pGroup == -1) {
            arr[p] = arr[q];
            return;
        }
        if (qGroup == -1) {
            arr[q] = arr[p];
            return;
        }
        ArrayList<Integer> qValues = indexes(q);

        for (int i : qValues) {
            arr[i] = arr[p];
        }
        return;
        
    }
    public ArrayList<Integer> indexes(int n) {
        int searchGroup = arr[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchGroup) {
                ans.add(i);
            }
        }
        return ans;
    }

    public int find(int p) {
        return arr[p];
    }
    public boolean connected(int p, int q) {
        return arr[p] == arr[q];
    }
    public String toString() {
        String s = "";
        
        return "";
    }
    public static void main(String[] args) {
        QuickFind q = new QuickFind(5);
        q.union(1, 2);
        q.union(3,1);
        q.union(0, 4);

        System.out.println(q.connected(3, 2));


    }
}
