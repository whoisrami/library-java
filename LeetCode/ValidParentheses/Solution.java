package ValidParentheses;

import java.util.Stack;

/**
 * Author: Alex Yang
 * Date: 1/9/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args){
    System.out.println(isValid("({})[]"));
  }

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if ('(' == c) stack.push(')');
      if (')' == c) {
        if (stack.isEmpty() || stack.pop() != c) return false;
      }

      if ('[' == c) stack.push(']');
      if (']' == c) {
        if (stack.isEmpty() || stack.pop() != c) return false;
      }

      if ('{' == c) stack.push('}');
      if ('}' == c) {
        if (stack.isEmpty() || stack.pop() != c) return false;
      }
    }

    return stack.isEmpty();
  }
}
