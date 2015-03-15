package LongestSubstringNoRepeatChar;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Alex Yang
 * Date: 12/26/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args){
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("abbbbba"));
    System.out.println(lengthOfLongestSubstring("cabcda"));
    System.out.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));

  }

  //As soon as we see a duplicated character, calculate the length of the substring and start the search one character away from the previous start.
  static int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) return 0;

    Map<Character, Integer> map = new HashMap<>(); //stores character and index where it appears

    int max = 0;
    int startIndex = 0; //beginning index of possible substring

    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);
      Integer lastSeenIndex = map.get(currentChar);
      if (lastSeenIndex != null && lastSeenIndex >= startIndex) { //repeated char found, and lastSeenIndex > startIndex so that the repeated cases in between are covered, e.g. 'abba'
        //more specifically lastSeenIndex > startIndex so that if we are traversing the last character 'a' in 'abba' it doesnt wrongly give us 3 instead of 2.  It shouldn't calculate the difference from the first 'a' because the starting point is already past it.
        max = Math.max(max, i - startIndex);
        startIndex = lastSeenIndex + 1;
      }

      map.put(currentChar, i);
    }

    //final check at the end in case a repeating char wasnt found up until the end
    //e.g. babac, will get bac -> 3
    max = Math.max(max, s.length() - startIndex);
    return max;
  }
}
