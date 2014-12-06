package StockProfit;

/**
 * Author: Alex Yang
 * Date: 12/4/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class StockProfit {
  public static void main(String args[]) {
    int[] stocks = new int[]{20, 40, 52, 15, 30, 50, 10, 25};
    System.out.println(profit(stocks));
  }

  static int profit(int[] stocks) {
    int lowIndex = 0;
    int low = Integer.MAX_VALUE;
    int maximumDifference = 0;

    for (int i = 0; i < stocks.length; i++) {
      if (stocks[i] < stocks[lowIndex]) {
        lowIndex = i;
        low = stocks[i];
      }

      int difference = stocks[i] - low;
      if (difference > maximumDifference) {
        //found new best profit
        maximumDifference = difference;
      }
    }

    return maximumDifference;
  }
}
