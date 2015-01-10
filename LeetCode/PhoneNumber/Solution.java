package PhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 1/8/15
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {
  public static void main(String[] args) {
    System.out.println(numToLetter('2'));
    System.out.println(letterCombinations("23"));
  }

  public static List<String> letterCombinations(String digits) {
    List<String> results = new ArrayList<String>();

    letterCombinationsHelper(digits, 0, "", results);
    return results;
  }

  public static void letterCombinationsHelper(String digits, int level, String permutation, List<String> results) {
    if (level >= digits.length()) {
      results.add(permutation);
      return;
    }

    String letters = numToLetter(digits.charAt(level));

    for (int i = 0; i < letters.length(); i++) {
      letterCombinationsHelper(digits, level + 1, permutation + letters.charAt(i), results);
    }
  }

  public static String numToLetter(char digit) {
    String converted = "";

    switch (digit) {
      case '2':
        converted = "abc";
        break;
      case '3':
        converted = "def";
        break;
      case '4':
        converted = "ghi";
        break;
      case '5':
        converted = "jkl";
        break;
      case '6':
        converted = "mno";
        break;
      case '7':
        converted = "pqrs";
        break;
      case '8':
        converted = "tuv";
        break;
      case '9':
        converted = "wxyz";
        break;
    }

    return converted;
  }
}
