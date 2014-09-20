package FileSystem;

import java.util.ArrayList;

/**
 * Created by alexyang on 9/19/14.
 */
public class Directory extends Entry {
  private ArrayList<Entry> contents;

  public Directory(String name, Directory directory) {
    super(name, directory);
    contents = new ArrayList<Entry>();
  }

  public int size() {
    int size = 0;
    for (Entry content: contents) {
      size += content.size();
    }
    return size;
  }

  public void ls() {
    for (Entry content : contents) {
      System.out.println(content.getName());
    }
  }

  public void deleteEntry(Entry entry) {
    contents.remove(entry);
  }

  public void addEntry(Entry entry) {
    contents.add(entry);
    entry.setParent(this);
  }
}
