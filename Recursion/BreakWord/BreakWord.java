package BreakWord;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Alex Yang
 * Date: 11/20/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a dictionary of words and a large input string tell whether the input string can be completely segmented into dictionary words.
 * Solution:
 * - N/A
 */
public class BreakWord {
  public static void main(String[] args) {
    Set<String> dictionary = new HashSet<String>();
    dictionary.add("apple");
    dictionary.add("pear");
    dictionary.add("pier");
    dictionary.add("pie");
    System.out.println(breakWord("applepie", dictionary));
  }

  static boolean breakWord(String str, Set<String> dict) {
    Set<String> solved = new HashSet<>();
    return breakWord(str, dict, solved);
  }

  static boolean breakWord(String str, Set<String> dict, Set<String> solved) {
    for (int i = 1; i <= str.length(); i++) {
      String firstWord = str.substring(0, i);
      if (dict.contains(firstWord)) {
        String secondWord = str.substring(i);
        if (secondWord == null || secondWord.length() == 0) {
          return true;
        }

        if (!solved.contains(secondWord)) {
          if (breakWord(secondWord, dict, solved)) {
            return true;
          }

          solved.add(secondWord);
        }
      }
    }
    return false;
  }
}
