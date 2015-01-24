package DecodeWays;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Alex Yang
 * Date: 1/22/15
 * Dependencies:
 * - N/A
 * Description:
 * - A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 * Solution:
 * - N/A
 */
public class Solution {
  public static void main(String[] args) {
//    System.out.println(numDecodings("12"));
//    System.out.println(numDecodings("121")); //should return 3
//    System.out.println(numDecodings("1010")); //test invalid input
    System.out.println(numDecodings("27"));
    System.out.println(numDecodings("101"));
  }

  public static int numDecodings(String s) {
    Map <String, String> map = new HashMap<>();
    Map <String, Integer> cache = new HashMap<String, Integer>();
    initializeMap(map);

    if (s.length() == 0) return 0;
    return numDecodings(s, map, cache, 0);
  }

  public static int numDecodings(String s, Map<String, String> map, Map<String, Integer> cache, Integer decodeWays) {
    for (int i = 1; i <= s.length(); i++) {

      String firstChunk = s.substring(0, i);
      if (firstChunk.length() > 2 || !map.containsKey(firstChunk)) break;
      if (map.containsKey(firstChunk)) {
        String secondChunk = s.substring(i);
        if ("".equals(secondChunk)) {
          decodeWays++;
          return decodeWays;
        }

        if (cache.containsKey(secondChunk)) {
          decodeWays += cache.get(secondChunk);
          return decodeWays;
        } else {
          decodeWays = numDecodings(secondChunk, map, cache, decodeWays);
          cache.put(secondChunk, decodeWays);
        }
      }
    }

    return decodeWays;
  }

  public static void initializeMap(Map<String, String> map) {
    map.put("1", "A");
    map.put("2", "B");
    map.put("3", "C");
    map.put("4", "D");
    map.put("5", "E");
    map.put("6", "F");
    map.put("7", "G");
    map.put("8", "H");
    map.put("9", "I");
    map.put("10", "J");
    map.put("11", "K");
    map.put("12", "L");
    map.put("13", "M");
    map.put("14", "N");
    map.put("15", "O");
    map.put("16", "P");
    map.put("17", "Q");
    map.put("18", "R");
    map.put("19", "S");
    map.put("20", "T");
    map.put("21", "U");
    map.put("22", "V");
    map.put("23", "W");
    map.put("24", "X");
    map.put("25", "Y");
    map.put("26", "Z");
  }

}
