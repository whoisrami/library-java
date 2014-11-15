package OnlineBookReader;

import java.util.HashMap;

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
public class Library {
  //needs to keep track of all books in a data structure
  //choose hashmap for fast insert, removal, and lookup
  private HashMap<Integer, Book> books = new HashMap<>();

  //add book to library, and return it
  public Book addBook(int id, String details) {
    if (books.containsKey(id)) {
      System.out.println("book already exists");
      return null;
    }

    Book book = new Book(id, details);
    books.put(id, book);
    return book;
  }

  //remove book
  public boolean remove(Book book) {
    return remove(book.getBookId());
  }

  public boolean remove(int id) {
    if (!books.containsKey(id)) {
      System.out.println("nonexistent book cannot be removed");
      return false;
    }

    books.remove(id);
    return true;
  }

  //find book
  public Book find(int id) {
    return books.get(id);
  }
}
