package PermuteString;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 1/13/15
 * Dependencies:
 * - N/A
 * Description:
 * - Generate all permutations of a string.
 * Solution:
 * - N/A
 */
public class PermuteString2 {
  public static void main(String[] args) {
    String str = "abc";
    List<String> arr = permute(str);

    for (String s : arr) {
      System.out.println(s);
    }
  }

  static List<String> permute(String str) {
    List<String> results = new ArrayList<>();
    permute(results, str, "");
    return results;
  }

  static void permute(List<String> results, String str, String acc) {
    if (str.length() == 0) {
      results.add(acc);
    }

    //essentially the grand idea of this algo is that it grabs the first char, then permutes the rest
    //then it loops to the next char, putting the 2nd char at the front...then permutes the rest...etc

    //loop through each char in string
    for (int i = 0; i < str.length(); i++) {
      //remove the character, append it to result string, and permute the rest
      permute(results, str.substring(0, i) + str.substring(i + 1), acc + str.charAt(i));
    }
  }
}
