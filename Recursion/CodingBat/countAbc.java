package CodingBat;

/**
 * Author: Alex Yang
 * Date: 11/29/14
 * Dependencies:
 * - N/A
 * Description:
 * -
 Count recursively the total number of "abc" and "aba" substrings that appear in the given string.

 countAbc("abc") → 1
 countAbc("abcxxabc") → 2
 countAbc("abaxxaba") → 2
 * Solution:
 * - N/A
 */
public class countAbc {
  public static void main(String args[]){
    System.out.println(countAbc("abc"));
    System.out.println(countAbc("abcxxabc"));
    System.out.println(countAbc("abaxxaba"));
    System.out.println(countAbc("ababc"));
  }

  static int countAbc(String str) {
    if (str.length() < 3) {
      return 0;
    }

    if (str.charAt(0) == 'a' && str.charAt(1) == 'b' &&
    (str.charAt(2) == 'c' || str.charAt(2) == 'a')) {
      return 1 + countAbc(str.substring(1));
    } else {
      return countAbc(str.substring(1));
    }
  }
}
