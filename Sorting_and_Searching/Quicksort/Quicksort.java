package Quicksort;

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
public class Quicksort {
  public static void main(String args[]) {
    //test partition functionality
    int[] partitionTest = {0, 4, 3, 2, 5, 1};

    int pivotIndex = partition(partitionTest, 0, partitionTest.length-1);

    System.out.println(pivotIndex);
    for (int i : partitionTest) {
      System.out.print(i);
    }

    System.out.println("\n");
    //test quicksort
    int[] test = {4,2,3,1,5};
    test = quicksort(test);

    for (int i : test) {
      System.out.print(i);
    }
  }

  static int[] quicksort(int[] arr) {
    return quicksort(arr, 0, arr.length - 1);
  }

  static int[] quicksort(int[] arr, int start, int end) {
    if (start < end) {
      int pivotIndex = partition(arr, start, end);

      int[] left = quicksort(arr, start, pivotIndex - 1);
      arr = quicksort(left, pivotIndex + 1, end);
    }

    return arr;
  }

  //returns the partition element's index
  static int partition(int[] arr, int start, int end) {
    int pivot = (start + end)/2;
    int pivotValue = arr[pivot];

    //swap pivot value and rightmost value
    int tmp = arr[pivot];
    arr[pivot] = arr[end];
    arr[end] = tmp;

    int storedIndex = start;

    //swap all values less than pivot to the front of the array, and loop through
    for (int i = start; i <= end - 1; i++ ) {
      if (arr[i] < pivotValue) {
        int swp = arr[storedIndex];
        arr[storedIndex] = arr[i];
        arr[i] = swp;
        storedIndex++;
      }
    }

    //swap back end and pivot values
    int finalPivot = arr[end];
    arr[end] = arr[storedIndex];
    arr[storedIndex] = finalPivot;

    return storedIndex;
  }
}
