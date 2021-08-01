import java.util.*;

/**
 * Approach: Group all the elements in the form of disjoint set.
 * Iterate through all the edges and add keep adding nodes to the DJ .
 * If at any instant if we know two nodes of the edge already exists in the set,
 * then it means a cycle node is being detected.
 * <p>
 * One important step to note is in find(a) method,
 * parent[a] = find(parent[a]).
 * This step avoids time limit exceeded since all the nodes will eventually report
 * to the parent.
 * <p>
 * Time Complexity: O(E)
 * Space Complexity: O(N)
 **/
class Solution {
    public boolean solveUnionFind(int[][] edges) {
        int n = 0;
        for (int e[] : edges) {
            n = Math.max(n, Math.max(e[0], e[1]));
        }

        parent = new int[n + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int e[] : edges) {
            if (union(e[0], e[1])) {
                return false;
            }
        }

        return true;
    }

    int[] parent;

    boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) {
            //Cycle detected.
            return true;
        }
        parent[x] = y;
        return false;
    }

    int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        //Assigning parent[a] to the result makes the disjoint set flat.
        //All children will report to root node eventually.
        parent[a] = find(parent[a]);
        return parent[a];
    }

    //Solution 2:
    /**
     * Approach: DFS Cycle detection:
     * Perform a Dfs on each of the unvisited nodes.
     * If no cycles found it means its a tree.
     *
     * Time Complexity: O(N)
     * Space Compexity: O(N)
     *
     */
    boolean dfs(int i, int parent, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        visited.add(i);
        for (Integer x : map.getOrDefault(i, new ArrayList<>())) {
            if (x.equals(parent)) {
                continue;
            }
            if (visited.contains(x)) {
                return true;
            }
            if (dfs(x, i, map, visited)) {
                return true;
            }

        }
        return false;
    }


    public boolean solveDFS(int[][] edges) {
        int max = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] e : edges) {
            max = Math.max(max, Math.max(e[0], e[1]));
            List<Integer> list = map.getOrDefault(e[0], new ArrayList<>());
            list.add(e[1]);

            List<Integer> list2 = map.getOrDefault(e[1], new ArrayList<>());
            list2.add(e[0]);

            map.put(e[0], list);
            map.put(e[1], list2);
        }


        for (int i = 0; i <= max; i++) {
            if (!visited.contains(i)) {
                if (dfs(i, -1, map, visited)) {
                    return false;
                }
            }
        }


        return true;
    }
}