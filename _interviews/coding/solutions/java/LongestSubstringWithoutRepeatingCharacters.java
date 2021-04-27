/**
 * Time Complexity: O(n)
 * Space Complexity: Unique Chracters of the string.
 *
 * The key is l = Math.max(map.get(ch) + 1, l);
 * If a character is already present then we shift the left pointer to the latest of l or the next
 * index of last occurance of ch.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                l = Math.max(map.get(ch) + 1, l);
            }
            map.put(ch, r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}