package GroupAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Alex Yang
 * Date: 10/27/14
 * Dependencies:
 * - N/A
 * Description:
 * - DESCRIPTION
 Two words are anagrams iff they contain the same letters in the same frequency.
 For example: 'dog' and 'god' are anagrams but 'ball' and 'lab' are not.

 anagram(dog) == anagram(god) == anagram(dgo)

 Input:
 ooyala
 dog
 cat
 act
 tca

 Output:
 numAnagrams(String[] input) prints:
 ooyala: 1
 dog: 1
 cat: 3
 act: 3
 tca: 3
 * Solution:
 * - N/A
 */
public class GroupAnagrams {
  public static void main(String args[]) {
    String[] testarray = {"ooyala", "dog", "cat", "act", "tca" };
    numAnagrams(testarray);
  }

  static void numAnagrams(String[] arr) {
    Map<String, Integer> map = new HashMap<String, Integer>();

    for (String s : arr) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String sortedString = new String(chars); //sort all chars
      if(!map.containsKey(sortedString)) {
        map.put(sortedString, 1);
      } else {
        map.put(sortedString, map.get(sortedString) + 1);
      }
    }

    for (String s : arr) {
      System.out.print(s + ": ");
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String sortedString = new String(chars); //sort all chars
      System.out.print(map.get(sortedString));
      System.out.println();
    }
  }
}
