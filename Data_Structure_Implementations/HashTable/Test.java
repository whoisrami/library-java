package HashTable;

/**
 * Created by alexyang on 9/19/14.
 */
public class Test {
  public static void main(String args[]) {
    Hash<Integer, String> test = new Hash<Integer, String>();
    test.put(1, "one");
    test.put(2, "two");
    System.out.println(test.get(1));
  }
}
