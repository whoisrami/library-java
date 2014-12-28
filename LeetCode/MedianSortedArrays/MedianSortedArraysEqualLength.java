package MedianSortedArrays;

/**
 * Author: Alex Yang
 * Date: 12/26/14
 * Dependencies:
 * - N/A
 * Description:
 * - There are two sorted arrays A and B of both size n. Find the median of the two sorted arrays. The overall run time complexity should be O(log (n)).
 * Solution:
 * - http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 */

public class MedianSortedArraysEqualLength {
  public static void main(String[] args){
    int[] arr1 = new int[]{1, 12, 15, 26, 38};
    int[] arr2 = new int[]{2, 13, 17, 30, 45};

//    System.out.println(getMedian(arr1, arr1.length));
//    System.out.println(getMedian(arr2, arr2.length));
    System.out.println(findMedianSortedArrays(arr1, arr2));
  }

  //basically find kth element where k is (m + n)/2
  public static double findMedianSortedArrays(int A[], int B[]) {
    int m = A.length;
    int n = B.length;
    int mid = (m + n)/2;

    if ((m + n) % 2 != 0) // odd
      return (double) findKth(A, B, mid, 0, m - 1, 0, n - 1);
    else { // even
      return (findKth(A, B, mid, 0, m - 1, 0, n - 1)
              + findKth(A, B, mid - 1, 0, m - 1, 0, n - 1)) * 0.5;
    }
  }

  public static int findKth(int A[], int B[], int k,
                            int aStart, int aEnd, int bStart, int bEnd) {

    int aLen = aEnd - aStart + 1;
    int bLen = bEnd - bStart + 1;

    // Handle special cases
    if (aLen == 0)
      return B[bStart + k];
    if (bLen == 0)
      return A[aStart + k];
    if (k == 0)
      return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

    int aMid = aLen * k / (aLen + bLen); // a's middle count
    int bMid = k - aMid - 1; // b's middle count

    // make aMid and bMid to be array index
    aMid = aMid + aStart;
    bMid = bMid + bStart;

    if (A[aMid] > B[bMid]) {
      k = k - (bMid - bStart + 1);
      aEnd = aMid;
      bStart = bMid + 1;
    } else {
      k = k - (aMid - aStart + 1);
      bEnd = bMid;
      aStart = aMid + 1;
    }

    return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
  }
}
