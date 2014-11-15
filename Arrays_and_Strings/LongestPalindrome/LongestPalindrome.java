package LongestPalindrome;

/**
 * Author: Alex Yang
 * Date: 11/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a string, find the longest palindrome in the string.
 * Solution:
 * - N/A
 */
public class LongestPalindrome {
  public static void main(String[] args) {
    System.out.println("Should print: 'ffracecarff' ");
//    System.out.println(findLongestPalindrome("zracecarzeyeadsfracecarsdfmadambbaaffracecarff"));
    System.out.println(longestPalindrome("zracecarzeyeadsfracecarsdfmadambbaaffracecarff"));
    System.out.println("Should print: 'caabbaac' ");
//    System.out.println(findLongestPalindrome("azsadabbaddfacaabbaac"));
    System.out.println(longestPalindrome("azsadabbaddfacaabbaac"));
  }

//  static String findLongestPalindrome(String str) {
//    String max = "";
//    char[] carr = str.toCharArray();
//    int expand = 1;
//
//    //odd case iteration check
//    for (int i = 0; i < str.length(); i++) {
//      boolean validIndex = i - expand >= 0 && i + expand < str.length();
//      if (validIndex) {
//        String substr = str.substring(i - expand, i + 1 + expand);
//        while (isPalindrome(substr)) {
//          if (substr.length() > max.length()) max = substr;
//          expand++;
//
//          boolean validIndex2 = i - expand >= 0 && i + expand < str.length();
//          if (validIndex2) {
//            substr = str.substring(i - expand, i + 1 + expand);
//          } else {
//            break;
//          }
//        }
//        expand = 1;
//      }
//    }
//
//    //even case iteration check
//    for (int i = 0; i < str.length(); i++) {
//      boolean validIndex = i - expand >= 0 && i + 1 + expand < str.length();
//      if (validIndex) {
//        String substr = str.substring(i - expand, i + 2 + expand);
//        while (isPalindrome(substr)) {
//          if (substr.length() > max.length()) max = substr;
//          expand++;
//
//          boolean validIndex2 = i - expand >= 0 && i + 1 + expand < str.length();
//          if (validIndex2) {
//            substr = str.substring(i - expand, i + 2 + expand);
//          } else {
//            break;
//          }
//        }
//        expand = 1;
//      }
//    }
//
//    return max;
//  }
//
//  static boolean isPalindrome(String s) {
//    for (int i = 0; i < s.length()/2; i++) {
//      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
//        return false;
//      }
//    }
//    return true;
//  }

  //solution from leetcode, uses my method but way shorter
  static String expandAroundCenter(String s, int c1, int c2) {
    int l = c1, r = c2;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return s.substring(l+1, r);
  }

  static String longestPalindrome(String s) {
    if (s.length() == 0) return "";
    String longest = s.substring(0, 1);

    for (int i = 0; i < s.length(); i++) {
      String p1 = expandAroundCenter(s, i, i);
      if (p1.length() > longest.length()) {
        longest = p1;
      }

      //even case
      String p2 = expandAroundCenter(s, i, i+1);
      if (p2.length() > longest.length()) {
        longest = p2;
      }
    }
    return longest;
  }
}
