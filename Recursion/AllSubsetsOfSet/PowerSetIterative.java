package AllSubsetsOfSet;

import java.util.*;

/**
 * Author: Alex Yang
 * Date: 12/4/14
 * Dependencies:
 * - N/A
 * Description:
 * - Iterative cloning then add method to return the power set of an array.
 * Solution:
 * - N/A
 */
public class PowerSetIterative {
  public static void main(String args[]) {
    int[] set = new int[]{1,2,3};

    ArrayList<ArrayList<Integer>> list = subsets(set);

    for (List<Integer> s : list) {
      System.out.print("{");
      for (int i : s) {
        System.out.print(i);
        System.out.print(", ");
      }
      System.out.print("}");
      System.out.println();
    }
  }

  static ArrayList<ArrayList<Integer>> subsets(int[] S) {
    if (S == null)
      return null;

    Arrays.sort(S);

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    for (int i = 0; i < S.length; i++) {
      ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

      //get sets that are already in result
      for (ArrayList<Integer> a : result) {
        temp.add(new ArrayList<>(a));
      }

      //add S[i] to existing sets
      for (ArrayList<Integer> a : temp) {
        a.add(S[i]);
      }

      //add S[i] only as a set
      ArrayList<Integer> single = new ArrayList<>();
      single.add(S[i]);
      temp.add(single);

      result.addAll(temp);
    }

    //add empty set
    result.add(new ArrayList<Integer>());

    return result;
  }
}
