package KthSmallestTwoArrays;

/**
 * Author: Alex Yang
 * Date: 11/28/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given two sorted arrays A, B of size m and n respectively. Find the k-th smallest element in the union of A and B. You can assume that there are no duplicate elements.
 * Solution:
 * - N/A
 */
public class KthSmallestTwoArrays {
  public static void main(String args[]) {
    int[] arr1 = new int[]{1,3,5,7,9};
    int[] arr2 = new int[]{2,4,6,8, 10};

    int k = 4;
    System.out.println(find(k, arr1, arr2));
//    System.out.println(kth_elem(k, arr1, arr2, 0, arr1.length - 1));
  }

//  //best solution, O(log  m + log n) time
  static int find(int k, int[] arr1, int[] arr2) {
    return find(k, arr1, arr2, 0, arr1.length -1);
  }

  static int find(int k, int[] a, int[] b, int start, int end) {
    if (start > end) {
      //try searching in b, if not found in a
      return find(k, b, a, 0, b.length - 1);
    }

    /**
     * a[i] must be greater than or equal to i elements in array a (and smaller than a[i + 1] onwards).
     *
     * if a[i] is the kth smallest element of the total A+B array, it must be greater than or equal to k - 1 - i elements in b.  (and less than the remaining)
     * Why?
     *
     * assuming a[i] is the kth smallest element,
     *   i is the # of elements from a
     *   a[i] > k - 1 elements in A+B (and less than remaining)
     *   therefore, it is greater than k - 1 - i elements in B
     */

    //get middle element
    int i = start + (end - start)/2; //to prevent overflow
    int j = k - 1 - i - 1; //grab index in B to compare with A

    /**
     * if j is negative, that means that the kth element cant exist in B
     * if element at a[i] is gte b[j] AND
     * if element at a[i] is lte than b[j + 1], then return a[i]
     */
    if ((j < 0 || (j < b.length && a[i] >= b[j])) &&
            (j + 1 >= b.length || (j + 1 >= 0 && a[i] <= b[j + 1]))) {
      return a[i];
    } else if (j < 0 || (j + 1 < b.length && a[i] > b[j+1])) {
      return find(k, a, b, start, i - 1); //if a[i] greater than b[j + 1], search bottom half of a
    } else {
      return find(k, a, b, i + 1, end); //else, search upper half of a
    }
  }
}
