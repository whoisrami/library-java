package WordLadder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * Author: Alex Yang
 * Date: 1/30/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 * Solution:
 * - N/A
 */

//TODO: this solution is rather slow....alternate solution below changes the character of the string itself and uses dict.contains() instead, is faster because only checks a max of 26 chars per iteration
//TODO: https://oj.leetcode.com/discuss/13939/could-anyone-post-ac-code-in-java-for-this-problem

public class Solution {
  public int ladderLength(String start, String end, Set<String> dict) {
    Deque<String> queue = new ArrayDeque<>();
    Deque<String> tmp = new ArrayDeque<>();
    tmp.add(start);
    int count = 1;

    do {
      queue = tmp;
      tmp = new ArrayDeque<>(); //reset tmp
      while (!queue.isEmpty()) {
        String curr = queue.poll();
        for (String s : dict) {
          if (oneCharAway(curr, s)) {
            if (s.equals(end)) return count + 1;
            tmp.add(s);
          }
        }
      }
      count++;
    } while (!tmp.isEmpty());

    return 0;
  }

  static boolean oneCharAway(String s1, String s2) {
    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        count++;
        if (count > 1) break;
      }
    }

    return count == 1;
  }
}
