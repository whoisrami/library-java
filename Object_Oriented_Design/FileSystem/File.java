package FileSystem;

/**
 * Created by alexyang on 9/19/14.
 */
public class File extends Entry {
  private int size;
  private String content;

  public File(String name, Directory directory, int size) {
    super(name, directory);
    this.size = size;
  }

  public int size() {
    return size;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
