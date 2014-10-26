import java.util.ArrayList;

/**
 * Author: Alex Yang
 * Date: 10/25/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class Mergesort {
  public static void main(String args[]) {
//    int[] testLeft = {1, 3, 7};
//    int[] testRight = {2, 4, 5};
//    int[] merged = merge(testLeft, testRight);
//    for (int i : merged) {
//      System.out.print(i);
//    }

    int[] test = {4,2,3,1,5};
    test = mergesort(test);

    for (int i : test) {
      System.out.print(i);
    }
  }

  static int[] mergesort(int[] arr) {
    if (arr.length == 1) {
      return arr;
    }

    int mid = arr.length/2;
    int[] left = new int[mid];
    int[] right = new int[arr.length - mid];
    for (int i = 0; i < mid; i++) {
      left[i] = arr[i];
    }
    for (int j = 0; j < arr.length - mid; j++) {
      right[j] = arr[mid + j];
    }

    left = mergesort(left);
    right = mergesort(right);
    return merge(left, right);
  }


  static int[] merge(int[] left, int[] right) {
    int[] merged = new int[left.length + right.length];
    int leftIndex = 0;
    int rightIndex = 0;
    int mergedIndex = 0;

    //while there are still elements remaining
    while(leftIndex < left.length || rightIndex < right.length) {

      //if elements in left and less than the element at front of right side
      if (leftIndex < left.length &&
         (rightIndex >= right.length || left[leftIndex] <= right[rightIndex])) {
        merged[mergedIndex] = left[leftIndex];
        mergedIndex++;
        leftIndex++;
      } else if (rightIndex < right.length &&
                (leftIndex >= left.length || right[rightIndex] < left[leftIndex])){
        merged[mergedIndex] = right[rightIndex];
        mergedIndex++;
        rightIndex++;
      }
    }

    return merged;
  }
}
