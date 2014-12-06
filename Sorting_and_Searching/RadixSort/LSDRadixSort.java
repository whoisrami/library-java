package RadixSort;

import java.util.ArrayList;

/**
 * Author: Alex Yang
 * Date: 11/29/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class LSDRadixSort {
  public static void main(String args[]) {

    int[] arr = new int[]{126, 348, 343, 432, 316, 171, 556, 223, 670, 201};
    int maxDigitSymbols = 3;

    sort(arr, 3);
    for (int i : arr) {
      System.out.print(i);
      System.out.print(", ");
    }
  }

  static void sort(int[] arr, int maxDigitSymbols) {
    final int RADIX = 10;
    //initialize buckets as array of arraylists
    ArrayList[] buckets = new ArrayList[RADIX];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new ArrayList<Integer>();
    }

    int mod = 10;
    int div = 1;
    for (int i = 0; i < maxDigitSymbols; i++) { //loop through max digits times
      for (int j = 0; j < arr.length; j++) { //loop through all elements in the arr
        int bucket = (arr[j] % mod) / div; //grab digit with mod, chop off last digits with div
        buckets[bucket].add(arr[j]);
      }

      int currIndex = 0;
      for (int j = 0; j < buckets.length; j++) {
        if (buckets[j].isEmpty()) continue; //if bucket is empty, continue
        for (Object z : buckets[j]) {
          arr[currIndex] = (int)z;
          currIndex++;
        }
      }

      mod *= 10;
      div *= 10;

      //clear buckets frequency map
      for (ArrayList b : buckets) {
        b.clear();
      }
    }
  }
}
