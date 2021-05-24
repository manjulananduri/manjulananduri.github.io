/**
 * Approach: To construct a palindrome since all the input characters are used, we will generate the prefix permutations
 * and append the middle and do a reverse of prefix to get the suffix for the final string.
 * Palindrome = prefix + middle + (reverse of prefix)
 * Validation Check: If the number of characters with odd occurances > 1 we cannot form a palindrome with it since only one element can be the center .
 * So we do backtracking based on the hashmap count of chars.
 * Input is broken into half counts for each of the characters to generate prefix permutations.
 * Time Complexity: O((n/2 + 1)!)
 * Space Complexity: O(n)
 **/
class Solution {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }

        Character odd = null;
        //Detect chars with odd count.
        int oddCount = 0;
        for (Character ch : map.keySet()) {
            if (map.get(ch) % 2 == 1) {
                odd = ch;
                oddCount++;
            }
            //Reduce map count size to half for generating only prefix.
            map.put(ch, map.get(ch) / 2);
        }

        List<String> res = new ArrayList<>();
        if (oddCount > 1) {
            return res;
        }
        backtrack(res, s, odd, "", map);
        return res;
    }

    void backtrack(List<String> res, String s, Character odd, String cur, Map<Character, Integer> map) {
        if (cur.length() == s.length() / 2) {
            String middle = odd == null ? "" : odd + "";
            res.add(cur + middle + new StringBuilder(cur).reverse().toString());
            return;
        }

        for (Character ch : map.keySet()) {
            int count = map.getOrDefault(ch, 0);
            if (count != 0) {
                map.merge(ch, -1, Integer::sum);
                backtrack(res, s, odd, cur + ch, map);
                map.merge(ch, 1, Integer::sum);
            }
        }
    }

}