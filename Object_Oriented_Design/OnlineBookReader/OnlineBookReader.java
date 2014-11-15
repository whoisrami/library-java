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
public class OnlineBookReader {
  private Library library = new Library();
  private UserManager userManager = new UserManager();
  private Display display = new Display();

  private Book activeBook;
  private User activeUser;

  public OnlineBookReader() {

  }

  public Library getLibrary() {
    return library;
  }

  public UserManager getUserManager() {
    return userManager;
  }

  public Display getDisplay() {
    return display;
  }

  public User getActiveUser() {
    return activeUser;
  }

  public void setActiveUser(User activeUser) {
    this.activeUser = activeUser;
    display.setActiveUser(activeUser);
  }

  public Book getActiveBook() {
    return activeBook;
  }

  public void setActiveBook(Book activeBook) {
    this.activeBook = activeBook;
    display.setActiveBook(activeBook);
  }
}
