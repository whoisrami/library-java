package MergeTwoArrays;

/**
 * Author: Alex Yang
 * Date: 11/20/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class MergeTwoArrays {
  public static void main(String args[]) {
    int[] arr1 = new int[]{1,2,3,4,5};
    int[] arr2 = new int[]{1,3,4};
    int[] merged = merge(arr1, arr2);

    for (int i : merged) {
      System.out.print(i);
    }
  }

  static int[] merge(int[] arr1, int[] arr2) {
    //put pointers on the heads of each array
    int p1 = 0;
    int p2 = 0;
    int[] merged = new int[arr1.length + arr2.length];
    int currentIndex = 0; //points to current index

    while (p1 < arr1.length && p2 < arr2.length) {
      if (arr1[p1] < arr2[p2]) {
        merged[currentIndex] = arr1[p1];
        p1++;
      } else {
        merged[currentIndex] = arr2[p2];
        p2++;
      }
      currentIndex++;
    }

    //deal with remaining elements
    if (p1 < arr1.length) {
      while (p1 < arr1.length) {
        merged[currentIndex] = arr1[p1];
        p1++;
        currentIndex++;
      }
    } else {
      while (p2 < arr2.length) {
        merged[currentIndex] = arr2[p2];
        p2++;
        currentIndex++;
      }
    }

    return merged;
  }
}
