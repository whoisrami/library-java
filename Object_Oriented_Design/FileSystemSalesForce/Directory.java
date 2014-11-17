package FileSystemSalesForce;

import java.util.HashMap;

/**
 * Author: Alex Yang
 * Date: 11/17/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class Directory extends Entry {
  private HashMap<String, Entry> contents;

  public Directory(String name, Directory directory) {
    super(name, directory);
    contents = new HashMap<String, Entry>();
  }

  public HashMap<String,Entry> getContents() {
    return contents;
  }

  //whatever you add has to be of type entry
  public void addEntry(Entry entry) {
    if (!contents.containsKey(entry.getName())) {
      contents.put(entry.getName(), entry);
      entry.setParent(this);
    } else {
      System.out.println("Subdirectory already exists");
    }
  }
}
