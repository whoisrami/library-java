package PermuteString;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 12/4/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class PermuteString {
  public static void main(String args[]) {
    String str = "ab";
    List<String> arr = permute(str);

    for (String s : arr) {
      System.out.println(s);
    }
  }

  private static List<String> permute(String str) {
    if (str == null) return null;

    List<String> permutations = new ArrayList<>(); //reset permutations every time
    if (str.length() == 0) {
      permutations.add("");
    } else {

      char first = str.charAt(0);
      String remainder = str.substring(1);
      List<String> words = permute(remainder);

      for (String word : words) {
        for (int i = 0; i <= word.length(); i++) { //note you need an extra iteration to get the char inserted in every permutation
          String s = insertCharAt(word, first, i);
          permutations.add(s);
        }
      }

    }
    return permutations;
  }

  static String insertCharAt(String str, char c, int i) {
    String front = str.substring(0, i);
    String back = str.substring(i);
    return front + c + back;
  }
}
