package arrays;

public class Utility {
    public static int binarySearch(int[] arr, int low, int high, int target) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else {
                if (arr[mid] > target) high--;
                else low++;
            }
        }
        return -1;
    }
/*    public static boolean binarySearch(int[] arr, int low, int high, int target) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            else {
                if (arr[mid] > target) high--;
                else low++;
            }
        }
        return false;
    }*/
}
