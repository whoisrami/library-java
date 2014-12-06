package Atoi;

/**
 * Author: Alex Yang
 * Date: 12/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - Convert string into integer.
 * Solution:
 * - N/A
 */
public class atoi {
  public static void main(String args[]) {
    String str1 = "-123";
    String str2 = "54321";

    System.out.println(atoi(str1));
    System.out.println(atoi(str2));
  }

  static int atoi(String s) {

    int num = 0;
    boolean negative = false;
    if (s.charAt(0) == '-') {
      negative = true;
      s = s.substring(1);
    }

    for (int i = 0; i < s.length(); i++) {

      num = num*10 + s.charAt(i) - '0';
      System.out.println(num);
    }

    if (negative) num *= -1;
    return num;
  }
}
