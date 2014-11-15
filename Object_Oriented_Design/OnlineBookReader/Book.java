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
public class Book {
  private int bookId;
  private String details;

  public Book(int bookId, String details) {
    this.bookId = bookId;
    this.details = details;
  }

  public void update() {}

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }
}
