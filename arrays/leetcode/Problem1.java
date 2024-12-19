package arrays.leetcode;

import java.util.*;

import arrays.Utility;
import arrays.Utility.*;

/**
 * Difficulty level: Easy
 * Two Sum problem
 * <p>
 * Input: [2, 4, 6, 9, 15, 16, 18], target = 15
 * Output [indexes]: [2,3]
 * <p>
 * [ 1,2,3,4] = 6 combos
 * [ (1,2), (1,3), (1,4), (2,3), (2,4), (3,4)  ]
 * there are n*(n-1)/2 total pairs
 */

public class Problem1 {

    /**
     * TC: O(n²), for using two nested loops
     * AS: O(1)
     */
    public static int[] usingArrays(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * TC: sort -> O(N Log N), no traverse complexity because we don't traverse whole array
     * AS: O(1)
     * This approach is the best approach for a sorted array < O(N). But if array is not sorted, then we use hashing.
     */
    public static int[] usingTwoPointer(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return new int[]{left, right};
            if (sum > target) right--;
            else left++;
        }
        return new int[]{-1, -1};
    }

    /**
     * TC: sort-> O(n log n), binary search -> O(Log N), arr traverse -> O(n)
     * so, binary search + traverse -> O(N Log N)
     * total: O(n log n) + O(N log N)
     * AS: O(1)
     */
    public static int[] usingBinarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];
            int result = Utility.binarySearch(arr, i + 1, n - 1, complement);
            if (result != -1) return new int[]{i, result};
        }
        return new int[]{-1, -1};
    }

    /*
    Outer Loop: O(n)
   map.containsKey: takes O(1) on average.
   map.put: takes O(1) on average.
   Total Time Complexity: loop performs O(1) operations (containsKey and put) for each element in the array,
   so the total time complexity is: O(n).
   Space-complexity = O(N)
     */
    public static int[] usingMap(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) return new int[]{map.get(arr[i]), i};
            else map.put(target - arr[i], i);
        }
        return new int[]{-1, -1};
    }

    // TC and SC, same as usingMap
    public static boolean usingHashSet(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int item : arr) {
            if (set.contains(target - item)) return true;
            else set.add(item);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 9, 15, 16, 18};
        //int [] result = usingArrays(arr, 15);
        //int[] result = usingTwoPointer(arr, 15);
        //int[] result = usingBinarySearch(arr, 15);
        int[] result = usingMap(arr, 15);

        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}
