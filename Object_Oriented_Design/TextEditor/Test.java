package TextEditor;

/**
 * Author: Alex Yang
 * Date: 3/24/15
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class Test {
  public static void main(String[] args) {
    TextEditor te = new TextEditor(10);
    te.insertString("abcde");

    //te.moveCursorTo(0);
    te.stepCursorBackward();
    te.display();
    te.stepCursorForward();
    te.display();


    te.insertString("World");
    te.display();

    te.moveCursor(-3);
    te.display();

    te.deleteChar();
    te.display();

    te.stepCursorBackward();
    te.stepCursorBackward();
    te.stepCursorBackward();
    te.display();
  }

}
