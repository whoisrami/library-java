package CodingBat;

/**
 * Author: Alex Yang
 * Date: 12/20/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's inside them.

 nestParen("(())") → true
 nestParen("((()))") → true
 nestParen("(((x))") → false
 * Solution:
 * - N/A
 */
public class nestParen {
  public static void main(String args[]) {
    System.out.println(nestParen("(yy)"));
  }

  static boolean nestParen(String str) {
    System.out.println(str);
    if (str.length() == 0) {
      return true;
    }

    if (str.charAt(0) == ')') return false;

    if (str.charAt(0) == '(') {
      if (str.charAt(str.length() - 1) == ')') {
        return nestParen(str.substring(1, str.length() - 1));
      } else {
        return false;
      }
    }

    //if letter than false
    return false;
  }
}
