package BinarySearch;

/**
 * Author: Alex Yang
 * Date: 10/24/14
 * Dependencies:
 * - N/A
 * Description:
 * - Typical binary search.
 * Solution:
 * - N/A
 */
public class BinarySearch {
  public static void main(String args[]) {
    int[] arr = {1, 2, 4, 5, 6, 8, 9, 10, 12, 14};
    System.out.println(search(arr, 2));
    System.out.println(search(arr, 13));
  }

  static int search(int[] arr, int value) {
    return search(arr, 0, arr.length - 1, value);
  }

  static int search(int[] arr, int start, int end, int value) {
    if (start >= end ) {
      return -1;
    }

    int mid = (start + end)/2;
    if (arr[mid] == value) {
      return mid;
    } else if (arr[mid] > value) {
      return search(arr, start, mid-1, value);
    } else {
      return search(arr, mid+1, end, value);
    }
  }
}
