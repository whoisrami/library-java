package LongestCommonPrefix;

/**
 * Author: Alex Yang
 * Date: 1/2/15
 * Dependencies:
 * - N/A
 * Description:
 * - Write a function to find the longest common prefix string amongst an array of strings.
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    String[] arr = new String[]{"aab", "aaab", "aaa", "aa"};
    String[] arr2 = new String[]{"aa", "a"};
    System.out.println(longestCommonPrefix(arr));
    System.out.println(longestCommonPrefix(arr2));
  }

  /**
   * 1. Grabs the first element of the array.
   * 2. Then, loops through each character of first ele comparing it to the corresponding
   * characters in the rest of the strings in the array.
   * 3. At any time, if we find a mismatch, we break and return the substring.
   *
   * @param strs an array of strings
   * @return the longest common prefix
   */
  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";

    String s = strs[0];
    for (int i = 0; i < s.length(); i++) { //loop through character indexes first
      for (int j = 1; j < strs.length; j++) { //loop through array
        if (i > strs[j].length() - 1 || strs[j].charAt(i) != s.charAt(i)) {
          return s.substring(0, i);
        }
      }
    }

    return s; //first is the lcp (all other strings had it as their prefix)
  }
}
