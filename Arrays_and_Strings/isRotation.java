/**
 * Author: Alex Yang
 * date: 8/24/2014
 * Write code to determine if s2 is a rotation of s1
 * Constraint: must use only one call to a method called isSubstring()
 */
public class isRotation {
  public static boolean isSubstring(String s1, String s2){
    //if we are allowed to use string contains method
    return s2.contains(s1)? true : false;

    //if we arent allowed to use string contains method for whatever reason, do it manually
    // for(int i = 0; i < s2.length() - s1.length(); i++){
    //   boolean found = true;
    //   for(int j = 0; j < s1.length(); j++){
    //     if(s2.charAt(i+j) != s1.charAt(j)){
    //       found = false;
    //       break;
    //     }
    //   }
    //   if (found != false){
    //     return found;
    //   } 
    // }
    // return false;

    //TODO: we could do this using regex matching as well
  }

  public static boolean checkRotation(String s1, String s2){
    if(s1.length() != s2.length()) { 
      return false;
    }

    String bigs2 = new StringBuilder().append(s2).append(s2).toString();
    return isSubstring(s1, bigs2);
  }

  public static void main (String args[]) {
    String s1 = "waterbottle";
    String s2 = "erbottlewat";
    String s3 = "erbottlewate";

    System.out.println(checkRotation(s1, s2));
    System.out.println(checkRotation(s1, s3));
  } 
}