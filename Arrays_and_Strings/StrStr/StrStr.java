package StrStr;

/**
 * Author: Alex Yang
 * Date: 11/24/14
 * Dependencies:
 * - N/A
 * Description:
 * - Find a pattern within string
 * Solution:
 * - KMP algorithm
 */
public class StrStr {
  public static void main(String args[]) {
    String pattern = "ABCDABD";
    String str = "ABC ABCDAB ABCDABCDABDE";

    System.out.println(kmp(str, pattern));


    String testpmt = "abababca";
    int[] tmp = new int[testpmt.length()];
    createPMT(testpmt, tmp);

    System.out.print(" ");
    for (char c : testpmt.toCharArray()) {
      System.out.print(c);
      System.out.print("|");
    }
    System.out.println();

    for (int i : tmp) {
      System.out.print(i);
      System.out.print("|");
    }
  }

  static int kmp(String str, String pattern) {
    int m = 0; //the beginning of the current match in str
    int i = 0; //the position of the current character in pattern

    int[] PMT = new int[pattern.length()]; //partial match table
    createPMT(pattern, PMT);

    while (m + i < str.length()) {
      if (pattern.charAt(i) == str.charAt(m + i)) {
        if (i == pattern.length() - 1) return m; //location found
        i = i + 1;
      } else {

        if (PMT[i] > -1) {
          m = m + i - PMT[i]; //set m index to first matched char in string
          i = PMT[i]; //set current index in pattern to value in partial match table used in prev step, this makes it so that i is pointing to the right place to continue "matching"
          //after these 2 assignments everything is all set to go for the next match
        } else {
          m = m + 1; //no match found, proceed to next char in string
          i = 0; //set position in pattern to 0
        }
      }
    }

    //if gets here, that means unsuccessful
    return -1;
  }

  //creates the partial match table
  static void createPMT(String pattern, int[] table) {
    int pos = 2;
    int cnd = 0;

    table[0] = -1;
    table[1] = 0;

    while (pos < pattern.length()) {
      if (pattern.charAt(pos - 1) == pattern.charAt(cnd)) { //first case: the substring continues
        cnd++;
        table[pos] = cnd;
        pos++;
      }

      else if (cnd > 0) { //it doesnt but we can fall back
        cnd = table[cnd];
      }

      else { //run out of candidates, cnd is 0
        table[pos] = 0;
        pos++;
      }
    }
  }
}

