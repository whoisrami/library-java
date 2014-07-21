/**
 * Author: Alex Yang
 * Checks to see if two strings are permutations of each other
 * Solution 1: sort two strings
 * Solution 2: check character counts
 */
import java.util.Arrays;

public class isPermutation {
  static boolean sol1(String str1, String str2){
    char [] arr1 = str1.toCharArray();
    Arrays.sort(arr1);
    char [] arr2 = str2.toCharArray();
    Arrays.sort(arr2);

    String sorted_str1 = new String(arr1);
    String sorted_str2 = new String(arr2);

    return sorted_str1.equals(sorted_str2);
  }

  static boolean sol2(String str1, String str2){
    if (str1.length() != str2.length()) {
      return false;
    }

    //initialize frequency counter array
    int[] letters = new int[256];
    for (char c: str1.toCharArray()){
      letters[c]++;
    }

    for (char c: str2.toCharArray()){
      if(letters[c]-- <= 0){
        return false;
      }
    }

    return true;
  }

  public static void main (String[] args){
    String s1 = "racecardog";
    String s2 = "racedograc";
    String s3 = "racecar";
    System.out.println(sol1(s1, s2));
    System.out.println(sol1(s1, s3));

    System.out.println(sol2(s1, s2));
    System.out.println(sol2(s1, s3));
  }
}