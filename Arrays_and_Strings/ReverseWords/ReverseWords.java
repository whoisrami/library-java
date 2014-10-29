package ReverseWords;

/**
 * Author: Alex Yang
 * Date: 10/28/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class ReverseWords {
  public static void main(String args[]) {
    String s = "This is an interview.";
    System.out.println(reverseIndividualWords(s));
  }

  static String reverseWords(String s) {
    String[] arr = s.split(" ");
    StringBuffer sb = new StringBuffer();
    for (int i = arr.length-1; i > 0; i--) {
      sb.append(arr[i]);
      sb.append(" ");
    }
    sb.append(arr[0]); //handle trailing space, or can use trim method
    return sb.toString();
  }

  //on the go without using split
  static String reverseIndividualWords(String str) {
    int length = str.length();
    String sentence= "";
    String word = "";
    for(int i = 0; i < length; i++) {
      if (str.charAt(i) != ' '){
        word = str.charAt(i) + word;
      } else {
        sentence += word + " ";
        word = "";
      }
    }
    sentence += word;
    return sentence;
  }


}
