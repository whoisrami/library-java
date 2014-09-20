package FileSystem;

/**
 * Created by alexyang on 9/19/14.
 */
public class Test {
  public static void main(String args[]) {
    Directory directory = new Directory("dir1", null);
    File file = new File("file", directory, 32);
    File file1 = new File("file1", directory, 32);
    File file2 = new File("file2", directory, 32);
    directory.addEntry(file);
    directory.addEntry(file1);

    Directory directory2 = new Directory("dir2", directory);
    directory.addEntry(directory2);
    directory2.addEntry(file2);

    System.out.println("listing contents of directory 1");
    directory.ls();

    System.out.println("listing contents of directory 2");
    directory2.ls();

    System.out.println(file2.getPath());
  }
}
