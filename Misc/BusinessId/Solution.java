package BusinessId;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Solution {
  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, ArrayList<String>> map = new HashMap<>();
    String line;
    while ((line = br.readLine()) != null) {
      //System.out.println(line);
      String[] arr = line.split(" ");
      if (!map.containsKey(arr[1])) {
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add(arr[0]);
        map.put(arr[1], tmp);
      } else {
        ArrayList<String> list = map.get(arr[1]);
        list.add(arr[0]);
        map.put(arr[1], list);
      }
    }

    Object[] keys = map.keySet().toArray();
    Arrays.sort(keys);
    for(int i = keys.length - 1; i >= 0; i--) {
      ArrayList<String> arr = map.get(keys[i]);
      for (String s : arr) {
        System.out.println(s + " " + keys[i]);
      }
    }
  }
}
