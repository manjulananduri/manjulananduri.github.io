class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] t : times) {
            graph.get(t[0]).add(new int[]{t[1], t[2]});
        }

        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{k, 0});
        Map<Integer, Integer> res = new HashMap<>();
        while (q.size() != 0) {
            int[] cur = q.poll();
            if (res.containsKey(cur[0])) {
                continue;
            }
            //We try to add the same element to the queue.
            //But only the cur[1] having minimum value will be considered because
            //of the above containsKey condition.
            res.put(cur[0], cur[1]);
            for (int i[] : graph.get(cur[0])) {
                q.add(new int[]{i[0], cur[1] + i[1]});
            }

        }

        if (res.size() != n) {
            return -1;
        }

        int time = 0;
        for (int t : res.values()) {
            time = Math.max(time, t);
        }
        return time;
    }
}