/**
 * Sort Input by start time.
 * In a priority queue track the endtimes.
 * When a new meeting occurs check the priority queue for the smallest end time of the current running meetings.
 * If current start is > priority queue peek end then remove priority queue meeting and add current meeting end time.
 * <p>
 * Time Complexity: O(NlogN) : N is the number of meetings
 * Space Complexity: O(N)
 **/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        Queue<Integer> q = new PriorityQueue<>();
        q.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            Integer end = q.peek();
            if (intervals[i][0] >= end) {
                q.poll();
            }
            q.add(intervals[i][1]);
        }
        return q.size();
    }
}