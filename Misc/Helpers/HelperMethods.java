package Helpers;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 12/23/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class HelperMethods {
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3};
    printArray(arr);

    List<String> l = new ArrayList<String>();
    l.add("one");
    l.add("two");
    l.add("three");
    printList(l);
  }

  public static void printArray(int[] array) {
    for (int i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void printArray(char[] array) {
    for (char i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static <T> void printList(List<T> list){
    for(T t: list){
      System.out.print(t + " ");
    }
    System.out.println();
  }

  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] < 10 && matrix[i][j] > -10) {
          System.out.print(" ");
        }
        if (matrix[i][j] < 100 && matrix[i][j] > -100) {
          System.out.print(" ");
        }
        if (matrix[i][j] >= 0) {
          System.out.print(" ");
        }
        System.out.print(" " + matrix[i][j]);
      }
      System.out.println();
    }
  }

  public static void printMatrix(boolean[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j]) {
          System.out.print("1");
        } else {
          System.out.print("0");
        }
      }
      System.out.println();
    }
  }


  public static void toFullBinaryString(int a) {
    String s = "";
    for (int i = 0; i < 32; i++) {
      Integer lsb = new Integer(a & 1);
      s = lsb.toString() + s;
      a = a >> 1;
    }
    System.out.println(s);
  }

  public static String toBaseNString(int a, int base) {

    String s = "";
    while (true) {
      int lastdigit = a % base;
      s = lastdigit + s;
      a = a / base;
      if (a == 0)
        break;
    }

    return s;
  }

}
