/**
 * Approach: Straight forward implementation of Kruskals minimum spanning tree.
 **/
class Solution {
    public int minimumCost(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        uf = new int[n + 1];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }

        int res = 0;
        for (int[] e : edges) {
            if (!union(e[0], e[1])) {
                res += e[2];
            }
        }

        int count = 0;
        for (int i = 0; i < uf.length; i++) {
            if (uf[i] == i) {
                count++;
            }
        }
        return count == 2 ? res : -1;
    }

    int[] uf;

    boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x == y) {
            return true;
        }
        uf[x] = y;
        return false;
    }

    int find(int a) {
        if (uf[a] == a) {
            return a;
        }
        uf[a] = find(uf[a]);
        return uf[a];
    }
}
