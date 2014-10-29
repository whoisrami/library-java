package ReverseString;

/**
 * Author: Alex Yang
 * Date: 10/28/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class ReverseString {
  public static void main(String args[]) {
    String s = "This is an interview.";
    System.out.println(reverseString(s));
  }

  static String reverseString(String s) {
    char[] cArray = s.toCharArray();
    char tmp;
    for (int i = 0; i < (s.length()/2); i++) {
      //swap values
      tmp = cArray[i];
      cArray[i] = cArray[cArray.length - i - 1];
      cArray[cArray.length - i - 1] = tmp;
    }
    return new String(cArray);
  }
}
