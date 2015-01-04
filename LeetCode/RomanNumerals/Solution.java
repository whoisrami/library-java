package RomanNumerals;

/**
 * Author: Alex Yang
 * Date: 1/1/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 * Solution:
 * - N/A
 */
public class Solution {

  /**
   * I = 1
   * IV = 4
   * V = 5
   * IX = 9
   * X = 10
   * XL = 40
   * L = 50
   * XC = 90
   * C = 100
   * CD = 400
   * D = 500
   * CM = 900
   * M = 1000
   *
   * @param num - number to be converted into roman numeral
   * @return String - roman numeral representation
   */
  public static void main (String[] args) {
    System.out.println(intToRoman(1027));
    String str = intToRoman(1027);
    System.out.println(romanToInt(str));
  }


  public static String intToRoman(int num) {
    if(num>=1000) return "M"+intToRoman(num-1000);
    if(num>=900) return "CM"+intToRoman(num-900);
    if(num>=500) return "D"+intToRoman(num-500);
    if(num>=400) return "CD"+intToRoman(num-400);
    if(num>=100) return "C"+intToRoman(num-100);
    if(num>=90) return "XC"+intToRoman(num-90);
    if(num>=50) return "L"+intToRoman(num-50);
    if(num>=40) return "XL"+intToRoman(num-40);
    if(num>=10) return "X"+intToRoman(num-10);
    if(num>=9) return "IX"+intToRoman(num-9);
    if(num>=5) return "V"+intToRoman(num-5);
    if(num>=4) return "IV"+intToRoman(num-4);
    if(num>=1) return "I"+intToRoman(num-1);
    return "";
  }

  //scan from tail to head, accounting for special cases
  public static int romanToInt(String s) {
    int total = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      switch (c) {
        case 'I':
          total += (total >= 5 ? -1 : 1);
          break;
        case 'V':
          total += 5;
          break;
        case 'X':
          total += 10 * (total >= 50 ? -1 : 1);
          break;
        case 'L':
          total += 50;
          break;
        case 'C':
          total += 100 * (total >= 500 ? -1 : 1);
          break;
        case 'D':
          total += 500;
          break;
        case 'M':
          total += 1000;
          break;
      }
    }
    return total;
  }

  //TODO: can scan from tail to head, storing int representations initially in a hashmap.  if curr character is less than character after it, subtract instead of add.
}
