/**
 * Time Complexity: O(2 ^ n)
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, res, 0, 0, "");
        return res;
    }


    void generate(int n, List<String> res, int leftCount, int rightCount, String cur) {
        if (cur.length() == n * 2) {
            res.add(cur);
            return;
        }

        if (leftCount < n) {
            generate(n, res, leftCount + 1, rightCount, cur + "(");
        }

        if (rightCount < leftCount) {
            generate(n, res, leftCount, rightCount + 1, cur + ")");
        }


    }


}