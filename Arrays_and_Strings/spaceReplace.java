/**
 * Author: Alex Yang
 * Replaces all spaces in a string with '%20'
 */
import java.util.ArrayList;

public class spaceReplace {
  static String spaceReplace(String str, Integer truelength){
    int counter = 0;
    char[] charArray = str.toCharArray();
    System.out.println(charArray.length);
    for (int i = 0; i < truelength; i++){
      if(charArray[i] == ' '){
        //space reached
        counter++;
      }
    }

    int newlength = counter*2 + truelength;
    //System.out.println(truelength);
    //System.out.println(newlength);

    //charArray[newlength] = '\0';
    for(int i = truelength-1; i >= 0; i--){
      //System.out.println(charArray[i]);
      if(charArray[i] == ' '){
        charArray[newlength-1] = '0';
        charArray[newlength-2] = '2';
        charArray[newlength-3] = '%';
        newlength -= 3;
      } else {
        charArray[newlength-1] = charArray[i];
        newlength--;
      }
    }

    return new String(charArray);
  }

  public static void main(String [] args){

    String s0 = "lol";
    String s1 = "Mr John Smith    ";
    String s2 = "What the  ";
    System.out.println(spaceReplace(s0, 3));
    System.out.println(spaceReplace(s1, 13));
    System.out.println(spaceReplace(s2, 8));
  }
}