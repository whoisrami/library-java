package AllSubsetsOfSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 12/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - Write a method to return all subsets of a set. (power set)
 * Solution:
 * - Recursive
 */
public class AllSubsetsOfSet {
  public static void main(String args[]) {
    ArrayList<Integer> set = new ArrayList<>();
    set.add(1);
    set.add(2);
    set.add(3);

    ArrayList<ArrayList<Integer>> list = subsets(set, 0);

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

  static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set, int index) {
    ArrayList<ArrayList<Integer>> allSubsets;

    if (set.size() == index) { //base case, when index reaches set size, start going back up stack frame
      allSubsets = new ArrayList<>();
      ArrayList<Integer> empty = new ArrayList<>();
      allSubsets.add(empty); //first add empty array
    } else {

      allSubsets = subsets(set, index + 1);
      int num = set.get(index);

      ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

      for (ArrayList<Integer> origSet : allSubsets) {
        ArrayList<Integer> newSubset = new ArrayList<>();
        newSubset.addAll(origSet);
        newSubset.add(num);
        temp.add(newSubset);
      }

      allSubsets.addAll(temp);
    }

    return allSubsets;
  }
}
