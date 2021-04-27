/**
 * Time Complexity: O(n)
 * Space Complexity: O(X) : X is the number of distinct characters in the input.
 */
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer val = 1 + map.getOrDefault(ch, 0);
            map.put(ch, val);

            while (map.size() > 2 && l <= i) {
                char lchar = s.charAt(l);
                val = map.get(lchar) - 1;
                map.put(lchar, val);
                if (val == 0) {
                    map.remove(lchar);
                }
                l++;
            }

            max = Math.max(max, i - l + 1);
        }

        return max;
    }
}