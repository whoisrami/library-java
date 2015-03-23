package MergeIntervals;

/**
 * Author: Alex Yang
 * Date: 3/15/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 * Solution:
 * - N/A
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> results = new ArrayList<>();
    if (intervals.size() < 1) return results;

    //sort the intervals via comparator and start attrib
    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
      }
    });

    //store the current MAX end interval
    Interval curr = intervals.get(0);

    //iterate through the list, checking end of each interval, and merging if the start of next interval less than the current MAX end interval
    for (Interval i : intervals) {
      //if found merge
      if (i.start <= curr.end) {
        if (i.end > curr.end) {
          curr.end = i.end;
        }
      } else {
        results.add(curr);
        curr = i;
      }
    }

    //make sure to add last one
    results.add(curr);
    return results;
  }
}

class Interval {
  int start;
  int end;
  Interval() {start = 0; end = 0;}
  Interval(int s, int e) {start = s; end = e;}
}
