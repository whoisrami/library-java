/**
 * author: Alex Yang
 * Compresses a string e.g. aaabbc into a3b2c1
 * if compressed string would be equal to or longer than real string, we simply return the string itself
 */
public class stringCompression {
  public static void main (String [] args){
    String s1 = "hello";
    String s2 = "aaabbcccccc";
    System.out.println("testing string s1: " + compress(s1));
    System.out.println("testing string s2: " + compress(s2));
  }

  static String compress (String s){
    StringBuffer buffer = new StringBuffer();
    char[] charArray = s.toCharArray();

    char lastChar = charArray[0];

    int counter = 1;
    for (int i=1; i < s.length(); i++){
      if(charArray[i] != lastChar){
          buffer.append(lastChar);
          buffer.append(Integer.toString(counter));
          counter = 1;
          lastChar = charArray[i];
        } else {
          counter++;
        }

      //if we are at the end of the stromg
      // if(i == s.length() - 1){
      //   if(charArray[i] != lastChar ){
      //     buffer.append(charArray[i]);
      //     buffer.append("1");
      //   } else {
      //     buffer.append(charArray[i]);
      //     buffer.append(Integer.toString(counter));
      //   }
      // }
      
    }
    buffer.append(lastChar);
    buffer.append(counter);

    String compressedStr = buffer.toString();
    return compressedLengthCheck(compressedStr, s); 
  }

  static String compressedLengthCheck (String sCompressed, String sOriginal){
    int strLength = sOriginal.length();
    int compressedStrLength = sCompressed.length();
    if (strLength <= compressedStrLength){
      return sOriginal;
    }
    return sCompressed;
  }
}