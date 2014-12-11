package QuickSelect;

/**
 * Author: Alex Yang
 * Date: 12/10/14
 * Dependencies:
 * - N/A
 * Description:
 * - Find the kth highest number in an array.
 * Solution:
 * - N/A
 */
public class QuickSelect {
  public static void main(String args[]) {
    int[] arr = new int[]{2,1,3,4,8,6,7,5};
    System.out.println(quickSelect(arr, 3));

  }

  static int quickSelect(int[] arr, int k) {
    return quickSelect(arr, 0, arr.length-1, k);
  }

  static int quickSelect(int[] arr, int start, int end, int k) {
    if (start > end) return -1; //error check
    int pivot = partition(arr, start, end);

    if (pivot == k) return arr[k];
    if (pivot > k) return quickSelect(arr, start, pivot - 1, k);
    if (pivot < k) return quickSelect(arr, pivot + 1, end, k);

    return -1;
  }

  static int partition(int[] arr, int start, int end) {
    int pivot = (start + end)/2; //can be randomly assigned
    swap(arr, pivot, end);  //swap pivot to the end

    for (int i = start; i < end; i++) { //only go up to end index - 1, because going to use that to switch into mid later
      if (arr[i] > arr[end]) { //if element at i is greater than pivot, swap to the front
        swap(arr, i, start); //swap as you go, will end with all greater than parition values before all lower than partition values
        start++;
      }
    }

    swap(arr, start, end);
    return start;
  }

  static void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
}
