package StringBinarySearch;

/**
 * Author: Alex Yang
 * Date: 11/29/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
 * Solution:
 * - N/A
 */
public class StringBinarySearch {
  public static void main(String args[]) {
    String[] arr = new String[]{"ab", "abc", "", "ba", "", "", "bbb", "", "cd", "dc", "", "ee", "", "", "efg"};
    String str = "ba";

    System.out.println(search(arr, str));
  }

  static int search(String[] strings, String str) {
    if (strings == null || str == null || "".equals(str)) {
      return -1;
    }

    return search(strings, str, 0, strings.length - 1);
  }

  static int search(String[] strings, String str, int start, int end) {
    if (start > end) {
      return -1;
    }

    int mid = (start + end)/2;

    if (strings[mid].isEmpty()) {
      int left = mid - 1;
      int right = mid + 1;

      while (true) {
        if (left < start && right > end) {
          return -1;
        } else if (right <= end && !strings[right].isEmpty()) {
          mid = right;
          break;
        } else if (left >= start && !strings[left].isEmpty()) {
          mid = left;
          break;
        }

        left--;
        right++;
      }
    }

    if (str.equals(strings[mid])) {
      return mid;
    } else if (strings[mid].compareTo(str) > 0) {
      return search(strings, str, mid + 1, end);
    } else {
      return search(strings, str, start, mid - 1);
    }
  }
}
