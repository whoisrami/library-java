/**
 * author: Alex Yang
 * Recursively find both the maximum element of an array, and the minimum element
 */
import static java.lang.Math.abs;
public class Extrema {
  static int maxArray(int[] A, int start, int end){
    //if only one element in array return that element

    //calculate mid index
    int mid = (start + end)/2;
    System.out.println(mid);

    //if less than 2 elements left
    if(Math.abs(start-end) == 1){
      return max(A[start], A[end]);
    }

    return max(maxArray(A, start, mid), maxArray(A, mid, end));
  }
  static int minArray(int[] A, int start, int end){
    int mid = (start + end)/2;
    System.out.println(mid);

    if(Math.abs(start - end) == 1){
      return min(A[start], A[end]);
    }

    return min(minArray(A, start, mid), minArray(A, mid, end));
  }

  static int max(int a, int b){
    if(a >= b){
      return a;
    }
    return b;
  }

  static int min(int a, int b){
    if(a <= b){
      return a;
    };
    return b;
  }

  public static void main(String[] args){
    int[] B = {-1,2,6,3,9,2,-3,-2,11,5,7};
    // int[] B = {1, 2, 4, 3};
    System.out.println("max = " + maxArray(B, 0, B.length-1));
    System.out.println("min = " + minArray(B, 0, B.length-1));

  }
}