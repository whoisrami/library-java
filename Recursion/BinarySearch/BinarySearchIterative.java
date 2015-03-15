package BinarySearch;

/**
 * Author: Alex Yang
 * Date: 3/11/15
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class BinarySearchIterative {
  public static void main(String args[]) {
    int[] arr = {1, 2, 4, 5, 6, 8, 9, 10, 12, 14};
    System.out.println(search(arr, 2));
    System.out.println(search(arr, 13));
  }

  static int search(int[] arr, int value) {
    int start = 0;
    int end = arr.length - 1;

    while (start < end) {
      int mid = (start + end)/2;

      if (arr[mid] == value) {
        return mid;
      } if (arr[mid] > value) {
        end = mid - 1;
      } else if (arr[mid] < value) {
        start = mid + 1;
      }
    }

    return -1;
  }


}
