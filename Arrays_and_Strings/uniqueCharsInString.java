import java.util.HashMap;
import java.util.Map;

public class uniqueCharsInString {
  public static void main (String [] args){
    String s1 = "hello";
    String s2 = "heyman";
    System.out.println("checking string s1: " + checkString(s1));
    System.out.println("checking string s2: " + checkString(s2));
  }

  static boolean checkString (String s){
    Map<Character, Integer> charCounter = new HashMap<Character, Integer>();
    for(char c : s.toCharArray()){
      if(charCounter.containsKey(c)){
        //charCounter.put(c, charCounter.get(c) + 1);
        return false;
      } 
      else{
        charCounter.put(c, 1);
      }
    }
    return true;
  }
}