package SearchForRange;

/**
 * Author: Alex Yang
 * Date: 3/24/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 * Solution:
 * - N/A
 */
public class Solution {
 public int[] searchRange(int[] A, int target) {
   int start = 0;
   int end = A.length - 1;
   int found = -1;

   while (start <= end) {
     int mid = (start + end)/2;
     if (A[mid] > target) {
       end = mid - 1;
     } else if (A[mid] < target) {
       start = mid + 1;
     } else {
       found = mid;
       break;
     }
   }

   if (found == -1) return new int[]{-1, -1};

   int aStart = found;
   int aEnd = found;
   while(true) {
     if (aStart > 0 && A[aStart - 1] == A[found]) {
       aStart--;
     } else {
       break;
     }
   }

   while(true) {
     if (aEnd < A.length - 1 && A[aEnd + 1] == A[found]) {
       aEnd++;
     } else {
       break;
     }
   }

   return new int[]{aStart, aEnd};

 }
}
