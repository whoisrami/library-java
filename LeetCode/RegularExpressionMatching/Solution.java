package RegularExpressionMatching;

/**
 * Author: Alex Yang
 * Date: 12/30/14
 * Dependencies:
 * - N/A
 * Description:
 * - Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args){
    System.out.println(isMatch("aa", "a")); //false
    System.out.println(isMatch("aa", "aa")); //true
    System.out.println(isMatch("aaa", "aa")); //false
    System.out.println(isMatch("aa", "a*")); //true
    System.out.println(isMatch("aa", ".*")); //true
    System.out.println(isMatch("ab", ".*")); //true
    System.out.println(isMatch("aab", "c*a*b")); //true

    System.out.println(isMatch("ab", ".*c")); //false
    System.out.println(isMatch("aa", "b*a")); //false
    System.out.println(isMatch("a", "ab*")); //true

    System.out.println(isMatch("a", ".*..a*")); //false
    System.out.println(isMatch("bbbba", ".*a*a")); //true
    System.out.println(isMatch("a", "a*a")); //true
  }

  public static boolean isMatch(String s, String p) {
    if (p.length() == 0) return s.length() == 0;

    int i = 0;
    int len = s.length();
    if (p.length() > 1 && p.charAt(1) == '*') {
      // try not using the * pattern at all
      if (isMatch(s, p.substring(2))) {
        return true;
      }

      //handle case of star
      while (i < len && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
        //try every possibility
        if (isMatch(s.substring(i + 1), p.substring(2))) return true;
        i++;
      }
    }

    if (p.charAt(0) == '.' && len > 0) {
      return (isMatch(s.substring(1), p.substring(1)));
    } else if (len > 0 && p.charAt(0) == s.charAt(0)){
      return (isMatch(s.substring(1), p.substring(1)));
    }

    return false;
  }
}
