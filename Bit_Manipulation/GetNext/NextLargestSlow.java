package GetNext;

/**
 * Author: Alex Yang
 * Date: 12/28/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a positive integer, print the next smallest and the next largest number that have the same number of 1 bits in their binary representation.
 * Solution:
 * - N/A
 */
public class NextLargestSlow {
  public static void main(String[] args) {
    int num = 10; //1010, next biggest is 12 at 1100
    System.out.println(getNextSlow(num));
  }

  // get the number of 1s in the integer passed in
  // increment and check to see if the next one has same amount of ones
  public static int getNextSlow(int i) {
    if (!hasValidNext(i)) {
      return -1;
    }
    int num_ones = countOnes(i);
    i++;
    while (countOnes(i) != num_ones) {
      i++;
    }
    return i;
  }

  public static int countOnes(int i) {
    int count = 0;
    while (i > 0) {
      if ((i & 1) == 1) {
        count++;
      }
      i = i >> 1;
    }
    return count;
  }

  // check to see if there is a valid larger value, cannot be -> 11..1100..00
  public static boolean hasValidNext(int i) {
    if (i == 0) {
      return false;
    }
    int count = 0;

    //check all 0s in a row first, then all 1s.  if counter is greater than 32, then no greater 32-bit integer value.
    while ((i & 1) == 0) {
      i >>= 1;
      count++;
    }
    while ((i & 1) == 1) {
      i >>= 1;
      count++;
    }
    if (count == 31) {
      return false;
    }
    return true;
  }
}
