package RegexMatchExpression;

/**
 * Author: Alex Yang
 * Date: 11/26/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a text and pattern, determine if pattern matches with text completely or not using "regular expression matching".  Implement chars . and *
 * Solution:
 * - N/A
 */

//TODO: account for case with * followed by .
public class RegexMatchExpression {
  public static void main(String args[]) {
    String pattern = ".*b.c";
    String s1 = "aabcc"; //should pass
    String s2 = "aabbcb"; //should not pass
    String s3 = "abcc"; //should pass

    System.out.println(match(pattern, s1));
    System.out.println(match(pattern, s2));
    System.out.println(match(pattern, s3));
  }

//  static boolean match(String pattern, String str) {
//    return match(pattern, str, 0, 0);
//  }
//
//  static boolean match(String pattern, String str, int patternIndex, int strIndex) {
//    //if patternIndex is past the last Index, and the last char wasnt an asterisk
//    if ((strIndex == str.length() || patternIndex == pattern.length()) && (patternIndex < pattern.length() || strIndex < str.length())) {
//      return false;
//    } else if (strIndex == str.length() && patternIndex == pattern.length()) {
//      return true;
//    }
//
//    char p = pattern.charAt(patternIndex);
//    char s = str.charAt(strIndex);
//
//    System.out.println("pattern: " + patternIndex + p + " str: " + strIndex +  s);
//
//    if (p == '*') {
//      if (s == str.charAt(strIndex - 1)) {
//        strIndex++;
//      } else {
//        patternIndex++;
//      }
//    } else if (p == '.') {
//      strIndex++;
//      patternIndex++;
//    } else if (p == s) {
//      strIndex++;
//      patternIndex++;
//    } else {
//      return false;
//    }
//
//    return match(pattern, str, patternIndex, strIndex);
//  }

  static boolean match(String pattern, String str) {
    if (pattern.length() == 0) {
      return str.length() == 0;
    }

    //if on last char of pattern, or if 2nd char isnt *
    if (pattern.length() == 1 || pattern.charAt(1) != '*') {
      //if no chars left in string, or if character at string does not match char at pattern
      if (str.length() < 1 || (pattern.charAt(0) != '.' && str.charAt(0) != pattern.charAt(0))) {
        return false;
      }

      //check next char in both pattern and string
      return match(pattern.substring(1), str.substring(1));
    } else { //handle case of star
      int len = str.length();
      int i = -1;

      //check to make sure pattern before * either matches char in string, or is .
      while (i < len && (i < 0 || pattern.charAt(0) == '.' || pattern.charAt(0) == str.charAt(i))) {
        if (match(pattern.substring(2), str.substring(i + 1))) {
          return true;
        }
        i++;
      }
      return false;
    }
  }
}
