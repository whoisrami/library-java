package SortAnagrams;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: Alex Yang
 * Date: 11/29/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - can use group anagrams method, or implement a comparator as shown here
 */
public class SortAnagrams implements Comparator<String> {
  public static void main(String args[]) {
    String[] arr = new String[]{"god", "cat", "dog", "act", "none"};
    sort(arr);

    for (String s : arr) {
      System.out.print(s);
      System.out.print(", ");
    }
  }

  static void sort(String[] arr) {
    Arrays.sort(arr, new Comparator<String>() {
      public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
      }
    });
  }

  static String sortChars(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }

  @Override
  public int compare(String o1, String o2) {
    return sortChars(o1).compareTo(sortChars(o2));
  }
}
