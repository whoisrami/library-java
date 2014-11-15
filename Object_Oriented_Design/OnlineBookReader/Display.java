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
public class Display {
  private Book activeBook;
  private User activeUser;
  private int pageNumber = 0;

  public Book getActiveBook() {
    return activeBook;
  }

  public void setActiveBook(Book activeBook) {
    this.pageNumber = 0;
    this.activeBook = activeBook;

    refreshTitle();
    refreshDetails();
    refreshPage();
  }

  public User getActiveUser() {
    return activeUser;
  }

  public void setActiveUser(User activeUser) {
    this.activeUser = activeUser;
    refreshUsername();
  }

  public void turnPageForward() {
    pageNumber++;
    refreshPage();
  }

  public void turnPageBack() {
    pageNumber--;
    refreshPage();
  }

  public void refreshUsername() {
		/* updates username display */
  }

  public void refreshTitle() {
		/* updates title display */
  }

  public void refreshDetails() {
		/* updates details display */
  }

  public void refreshPage() {
		/* updated page display */
  }
}
