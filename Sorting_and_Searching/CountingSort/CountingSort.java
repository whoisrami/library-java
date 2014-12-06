package CountingSort;

/**
 * Author: Alex Yang
 * Date: 11/29/14
 * Dependencies:
 * - N/A
 * Description:
 * - Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects having distinct key values (kind of hashing). Then doing some arithmetic to calculate the position of each object in the output sequence.
 * Solution:
 * - N/A
 */
public class CountingSort {
  public static void main(String args[]) {
    int[] arr = new int[]{126, 348, 343, 432, 316, 171, 556, 223, 670, 201};
    int max = 670;
    sort(arr, max);

    for (int i : arr) {
      System.out.print(i);
      System.out.print(", ");
    }
  }

  static void sort(int[] arr, int max) {
    int[] bucket = new int[max + 1];

    //frequency counter for all vals in array
    for (int i = 0; i < arr.length; i++) {
      bucket[arr[i]] = bucket[arr[i]] + 1;
    }

    //loop through all vals in the bucket array
    //if the value is not 0 at the bucket, then we use the inner loop to place the element in the output array however many times it appeared in the frequency array bucket
    int currIndex = 0;
    for (int i = 0; i < bucket.length; i++) {
      if (bucket[i] == 0) continue;
      for (int j = 0; j < bucket[i]; j++) {
        arr[currIndex] = i;
        currIndex++;
      }
    }
  }
}
