package StringToIntegerAtoi;

/**
 * Author: Alex Yang
 * Date: 12/29/14
 * Dependencies:
 * - N/A
 * Description:
 * - Implement atoi to convert a string to an integer.
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    String str1 = " -2147483647";
    String str2 = "2147483648";

    System.out.println(atoi(str1));
    System.out.println(atoi(str2));
  }

  public static int atoi(String str) {
    int num = 0;
    boolean negative = false;
    while (str.length() > 0 && str.charAt(0) == ' ' ) {
      str = str.substring(1);
    }

    if (str.length() == 0) return 0;

    if (str.charAt(0) == '-' || str.charAt(0) == '+') {
      if (str.charAt(0) == '-') negative = true;
      str = str.substring(1);
    }

    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) break;

      //check for overflow
      long result = (long) num*10 + str.charAt(i) - '0';
      if (result > 2147483647) { //int max
        if (negative) return -2147483648; //int min
        return 2147483647;
      }
      // at this point we can safely cast back to int, we checked before
      // that the value will be withing int's limits
      num = num*10 + str.charAt(i) - '0';
    }

    if (negative) num *= -1;
    return num;
  }
}
