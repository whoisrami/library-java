package BubbleSort;

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
public class BubbleSort {
  public static void main(String args[]) {
    int[] arr = new int[]{126, 348, 343, 432, 316, 171, 556, 223, 670, 201};

    sort(arr);
    for (int i : arr) {
      System.out.print(i);
      System.out.print(", ");
    }
  }

  static void sort(int[] arr) {
    boolean swapped = true;

    while (swapped) {
      swapped = false;
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) { //swap
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
          swapped = true;
        }
      }
    }


  }
}
