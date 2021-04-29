/**
 * Time Complexity: O(log N) : N is length of input array .
 * Space Complexity: O(C) : Constant
 * Insert position is nothing but the 'start' index in the iterative search.
 * ]0[[[ > start will be left of 0 or right of 0 in case of single element.
 */
class Solution {
    public int searchInsert(int[] a, int target) {
        int start = 0;
        int end = a.length -1 ;

        int mid = 0;
        while(start <= end) {
            System.out.println(start + ":" + end + ":" + mid);
            mid = start + (end - start) / 2;
            if(target == a[mid]) {
                return mid;
            }
            if(target < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}