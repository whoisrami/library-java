package MagicIndex;

/**
 * Author: Alex Yang
 * Date: 9/29/14
 * Dependencies:
 * - N/A
 * Description:
 * - A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i.  Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * - FOLLOW UP: What if the values are not distinct?
 * Solution:
 * - N/A
 */
public class MagicIndex {
  public static void main(String args[]) {
    int[] arr = {-1, 0, 0, 1, 2, 2, 5, 7, 9, 123, 123, 123, 123};
    System.out.println(findDistinct(arr));
  }

  static int findDistinct(int[] arr) {
    return findNotDistinct(arr, 0, arr.length - 1);
  }

  static int findDistinct(int[] arr, int start, int end) {
    System.out.println("enter with start: " + start + " end: " + end);
    if (end < start || start < 0 || end >= arr.length) {
      return -1;
    }

    int mid = (start + end)/2;

    if (mid == arr[mid]) {
      return mid;
    } else if (mid < arr[mid]) {
      return findDistinct(arr, start, mid - 1);
    } else {
      return findDistinct(arr, mid + 1, end);
    }
  }

  //same, but use N as the index for the left side on each iteration, where N is the element at mid index that is less than mid index
  static int findNotDistinct(int[] arr, int start, int end) {
    System.out.println("enter with index start: " + start + " end: " + end);
    if (end < start || start < 0 || end >= arr.length) {
      return -1;
    }

    int mid = (start + end)/2;

    if (mid == arr[mid]) {
      return mid;
    }

    //first search left for magic index
    //NOTE: we can skip values for increased efficiency if value at mid is smaller than the mid index itself
    int left = findNotDistinct(arr, start, Math.min(mid - 1, arr[mid]));
    if (left >= 0) return left;

    //then search right
    int right = findNotDistinct(arr, Math.max(mid + 1, arr[mid]), end);
    return right;
  }
}
