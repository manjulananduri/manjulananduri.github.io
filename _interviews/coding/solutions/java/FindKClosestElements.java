


/**
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * 1,2,3,4,5,5,5,11,12,13
 * 0,1,2,3,4,5,6
 * <p>
 * k = 3
 * x = 5
 * n/2 + 1
 * n/2
 **/

import java.util.*;

class Solution {

    int[] kClosestIntegers(int[] a, int k, int x) {
        //Insert position.
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        int position = start;

        // arr[i:j]
        int i = position;
        int j = position;
        int count = 0;

        while (i >= 0 && j < a.length) {
            if (count == k) {
                break;
            }

            if (x - a[i] < a[j + 1] - x) {
                System.out.println(i + "::" + (j + 1) + ":" + position);
                i--;
            } else {
                j++;
            }
            count++;
        }

        //System.out.println(i + "::" + j + ":" + position);
        //left exhausted
        while (count < k && i == 0 && j <= a.length - 1) {
            j++;
            count++;
        }

        //right exhauseted
        while (count < k && j == a.length && i > 0) {
            i--;
            count++;
        }

        int[] res = new int[k];
        int index = 0;

        for (int pos = i; pos < j; pos++) {
            res[index++] = a[pos];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 5, 5, 11, 12, 13};
        //int[] a = new int[]{1,2,3,4,5,5,5,6,7,8};
        int k = 3;
        int x = 10;
        System.out.println(Arrays.toString(new Solution().kClosestIntegers(a, k, x)));
    }


}


