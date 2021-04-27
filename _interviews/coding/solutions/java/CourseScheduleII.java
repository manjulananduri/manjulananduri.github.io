/**
 * Time Complexity: O(V + E) : V is vertices, E is edges
 * Space Compexity: O(V + E)
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);
        List<Integer> list = new ArrayList<>();
        for(int i =0 ; i < numCourses; i++) {
            dfs(i, list);
            if(cycle) {
                return new int[]{};
            }
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> ongoing = new HashSet<>();
    boolean cycle = false;

    void dfs(int cur, List<Integer> res) {
        if(cycle) {
            return;
        }

        //This needs to be before the visited condition to detect cycle
        //or else this condition will never execute for visited
        if(ongoing.contains(cur)) {
            cycle = true;
            return;
        }

        if(visited.contains(cur)) {
            return;
        }

        visited.add(cur);
        ongoing.add(cur);
        for(int child : map.get(cur)) {
            dfs(child, res);
        }
        ongoing.remove(cur);
        res.add(cur);
    }


    void buildGraph(int n, int[][] courses) {
        for(int i = 0; i < n ; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] course : courses) {
            map.get(course[1]).add(course[0]);
        }
    }


}