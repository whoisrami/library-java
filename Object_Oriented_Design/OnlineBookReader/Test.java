package OnlineBookReader;

/**
 * Author: Alex Yang
 * Date: 11/14/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class Test {
  public static void main(String args[]) {

    OnlineBookReader obr = new OnlineBookReader();
    Library lib = obr.getLibrary();

    lib.addBook(1, "book1");
    lib.addBook(2, "book2");

    obr.setActiveBook(lib.find(1));
  }
}
