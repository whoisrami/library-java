package FindDuplicate;

/**
 * Author: Alex Yang
 * Date: 10/27/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a sorted array of integer from 1 to n with exactly one duplicate. Find the duplicate
 * Solution:
 * - N/A
 */
public class FindDuplicate {
  public static void main(String args[]) {
    int[] input = {1, 2, 3, 4, 4, 5, 6};

    System.out.println(search(input));
  }

  static int search(int[] arr) {
    // check empty array here
    if(arr.length == 0) return -1;
    return search(arr, 0, arr.length-1);
  }

  static int search(int[] arr, int start, int end) {
    if (arr[start] == arr[end]) {
      return arr[start];
    }

    int mid = (start + end)/2;
    if (mid + 1 > arr[mid]) { //go left
      return search(arr, start, mid-1);
    } else { //go right
      return search(arr, mid+1, end);
    }
  }
}
