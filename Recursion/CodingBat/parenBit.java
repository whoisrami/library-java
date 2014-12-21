package CodingBat;

/**
 * Author: Alex Yang
 * Date: 12/20/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".

 parenBit("xyz(abc)123") → "(abc)"
 parenBit("x(hello)") → "(hello)"
 parenBit("(xy)1") → "(xy)"
 * Solution:
 * - N/A
 */
public class parenBit {
  public static void main(String args[]) {
    System.out.println(parenBit("xyz(abc)123"));
    System.out.println(parenBit("x(hello)"));
    System.out.println(parenBit("(xy)1"));
  }

  static String parenBit(String str) {
    if (str.length() <= 1) {
      return "";
    }

    if (str.charAt(0) == '(') {
      int counter = 0;
      while (str.charAt(counter) != ')') {
        counter++;
      }

      return str.substring(0, counter + 1) + parenBit(str.substring(counter + 1));
    }

    return parenBit(str.substring(1));
  }
}
