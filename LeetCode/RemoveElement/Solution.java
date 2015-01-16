package RemoveElement;

/**
 * Author: Alex Yang
 * Date: 1/13/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Hide Tags
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    int[] a = new int[]{1,2,2,4,2,5};
    int val = 2;
    System.out.println(removeElement(a, val));
  }

  public static int removeElement(int[] A, int elem) {
    if (A.length == 0) return 0;

    int start = 0;
    int end = A.length - 1;
    int length = A.length;

    while (start <= end) {
      if (A[start] == elem) {
        A[start] = A[end];
        end--;
        length--;
      } else {
        start++;
      }
    }

//    printArray(A);

    return length;
  }
}
