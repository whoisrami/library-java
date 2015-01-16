package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 1/9/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
    List<String> results = generateParenthesis(7);
    for (String i : results) {
      System.out.print(i);
      System.out.print(", ");
    }
    System.out.println();
  }


  public static List<String> generateParenthesis(int n) {
    List<String> results = new ArrayList<String>();
    int ptr = 0;
    String str = "";

    helper(n, results, ptr, str);
    return results;
  }

  public static void helper(int n, List<String> results, int ptr, String str) {
    System.out.println(ptr);
    if (ptr == n*2) {
      System.out.println(str);
      if (isValid(str)) {
        System.out.println("valid");
        System.out.println(str);
        results.add(str);
      }
      return;
    }

    helper(n, results, ptr + 1, str + "(");
    helper(n, results, ptr + 1, str + ")");
  }

  static boolean isValid(String s) {
    int counter = 0;
    for (char c : s.toCharArray()) {
      if ('(' == c) counter++;
      if (')' == c) counter--;
      if (counter < 0) return false;
    }
    return counter == 0;
  }
}
