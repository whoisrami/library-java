package ZigZagConversion;

/**
 * Author: Alex Yang
 * Date: 12/25/14
 * Dependencies:
 * - N/A
 * Description:
 * - The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * Solution:
 * - N/A
 */

public class ZigZagConversion {
  public static void main(String[] args) {
    System.out.println(convert("ABCD", 2));
    System.out.println(convert("PAYPALIS", 3)); //should be PAAPLISYI
    System.out.println(convert("AB", 1));
//    System.out.println(convert("PAYPALISHIRING", 3));
  }

  static String convert(String s, int nRows) {
    if (nRows == 1) return s;

    StringBuffer[] sbArray = new StringBuffer[nRows];
    for (int i = 0; i < sbArray.length; i++) {
      sbArray[i] = new StringBuffer();
    }

    boolean direction = false;
    int ptr = 0;
    for (int i = 0; i < s.length(); i++) {
      sbArray[ptr].append(s.charAt(i));

      if (ptr == 0 || ptr == nRows - 1) direction = !direction;
      if (direction) {
        ptr++;
      } else {
        ptr--;
      }
    }

    StringBuffer result = new StringBuffer();
    for (int i = 0; i < sbArray.length; i++) {
      result.append(sbArray[i].toString());
    }

    return result.toString();
  }
}
