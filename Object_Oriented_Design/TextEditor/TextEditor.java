package TextEditor;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex Yang
 * Date: 3/24/15
 * Dependencies:
 * - N/A
 * Description:
 * - Implementation of Text Editor using a simple gap buffer.
 * Solution:
 * - amortized O(1) for local inserts
 * - O(1) for moving around cursor, O(n) for arbitrary cursor motions
 * - O(1) for delete
 * - Search? probably O(N)
 */
public class TextEditor {
  char[] buffer; //the "cursor"
  int size;
  int leftSize; //tracks num chars before buffer
  int rightSize; //tracks num chars after end of buffer

  public TextEditor(int size) {
    this.buffer = new char[size];
    this.size = size;
    this.leftSize = 0;
    this.rightSize = 0;
  }

  public void stepCursorForward() {
    if (rightSize > 0) {
      buffer[leftSize + 1] = buffer[size - rightSize - 1];
      leftSize++;
      rightSize--;
    }
  }

  public void stepCursorBackward() {
    if (leftSize > 0) {

      buffer[size - rightSize - 1] = buffer[leftSize - 1];
      leftSize--;
      rightSize++;
    }
  }

  public void moveCursor(int distance) {
    if (distance >= 0) {
      for (int i = 0; i < distance; i++) {
        stepCursorForward();
      }
    } else {
      distance = - distance;
      for (int i = 0; i < distance; i++) {
        stepCursorBackward();
      }
    }
  }

  public void moveCursorTo(int location) {
    //find the difference between where cursor currently is (start of buffer)
    //and final location, move cursor that many times
    moveCursor(location - leftSize);
  }

  public void insertChar(char c) {
    if ((leftSize + rightSize) == size) {
      expand();
    }

    buffer[leftSize] = c;
    leftSize++;
  }

  public void insertString(String s) {
    for (int i = 0; i < s.length(); i++) {
      insertChar(s.charAt(i));
    }
  }

  public void deleteChar() {
    leftSize--;
  }

  //loop until start buffer, then loop from right buffer to end
  public void display() {
    for (int i = 0; i < leftSize; i++) {
      System.out.print(buffer[i]);
    }

    System.out.print("^");

    for (int i = rightSize; i > 0; i--) {
      System.out.print(buffer[size - i]);
    }

    System.out.println();
  }

  //double size of buffer if needed
  private void expand() {
    int newSize = this.size * 2;
    char[] newbuf = new char[newSize];

    for (int i = 0; i < leftSize; i++) {
      newbuf[i] = buffer[i];
    }

    for (int i = 0; i < rightSize; i++) {
      newbuf[newSize - i - 1] = buffer[size - i - 1];
    }

    buffer = newbuf;
    size = newSize;
  }
}
