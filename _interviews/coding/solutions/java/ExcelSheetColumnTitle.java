/**
 * Time Complexity: O(n)
 * Space Complexity: constant .
 **/
class Solution {
    public String convertToTitle(int col) {
        StringBuilder sb = new StringBuilder();
        while(col > 0) {
            int x = col % 26;
            int rem = x == 0 ? 26 : x;
            sb.append((char)(64 + rem));
            col = (col - rem)/ 26 ;
        }
        return sb.reverse().toString();
    }
}