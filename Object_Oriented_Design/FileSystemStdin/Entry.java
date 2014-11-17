package FileSystemStdin;

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
/**
 * Created by alexyang on 9/19/14.
 */
public abstract class Entry {
  protected String name;
  protected Directory parent;

  public Entry(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
  }

  public String getPath() {
    if (this.parent == null) {
      return name;
    } else {
      return parent.getPath() + "\\" + name;
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Directory getParent() {
    return parent;
  }

  public void setParent(Directory parent) {
    this.parent = parent;
  }
}
