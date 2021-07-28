/**
 * Optimized solution is :  Fisher-Yates Algorithm
 * This involves following steps
 * 1. Start with first index say start.
 * 2. Pick a random index from range [start, arr.length)
 * 3. Swap start index element with element at random index.
 * 4. Increment start and continue above steps till end is reached.
 * Time Complexity: O(N)
 * Space Complexity: O(N).
 */
class Solution {

    int[] a;

    public Solution(int[] nums) {
        a = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return a;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] res = a.clone();
        for (int i = 0; i < res.length; i++) {
            int rand = i + (int) (Math.random() * (res.length - i));
            int temp = res[i];
            res[i] = res[rand];
            res[rand] = temp;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */