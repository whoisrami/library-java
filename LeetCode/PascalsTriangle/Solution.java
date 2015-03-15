package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 2/23/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 * Solution:
 * - N/A
 */
public class Solution {
  public List<List<Integer>> generate(int numRows) {
    if (numRows <= 0) return new ArrayList<>();

    List<List<Integer>> results = new ArrayList<>();

    List<Integer> first =  new ArrayList<>();
    first.add(1);
    results.add(first);

    for (int i = 0; i < numRows - 1; i++) {
      List<Integer> row = new ArrayList<>();
      List<Integer> tmp = results.get(i);

      row.add(1);

      for (int j = 0 ; j < tmp.size() - 1; j++) {
        int a = tmp.get(j);
        int b = tmp.get(j + 1);

        row.add(a + b);

      }

      row.add(1);
      results.add(row);
    }

    return results;
  }
}
