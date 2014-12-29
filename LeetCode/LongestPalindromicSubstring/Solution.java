package LongestPalindromicSubstring;

/**
 * Author: Alex Yang
 * Date: 12/28/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    System.out.println("Should print: 'ffracecarff' ");
//    System.out.println(findLongestPalindrome("zracecarzeyeadsfracecarsdfmadambbaaffracecarff"));
    System.out.println(longestPalindrome("zracecarzeyeadsfracecarsdfmadambbaaffracecarff"));
    System.out.println("Should print: 'caabbaac' ");
//    System.out.println(findLongestPalindrome("azsadabbaddfacaabbaac"));
    System.out.println(longestPalindrome("azsadabbaddfacaabbaac"));
  }

  public static String longestPalindrome(String s) {
    if (s.length() == 0) return "";

    String max = "";
    for (int i = 0; i < s.length(); i++) {
      String tmp = expand(s, i, i);
      String tmp2 = expand(s, i, i + 1);
      if (tmp.length() > max.length()) {
        max = tmp;
      }

      if (tmp2.length() > max.length()) {
        max = tmp2;
      }
    }

    return max;
  }

  public static String expand(String s, int c1, int c2) {
    int l = c1, r = c2;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }

    //index shifted over by one because counter run through an extra time.
    return s.substring(l+1, r);
  }
}
