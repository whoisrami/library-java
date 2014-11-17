package FileSystemStdin;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FileSystemTest {

  @Test
  public void testDirectory() throws Exception {
    FileSystem fs = new FileSystem();
    fs.mkdir("testDirectory");
    int numFiles = fs.getCurrentDirectory().numFiles();
    assertEquals(1, numFiles);
    fs.mkdir("testDirectory2");
    assertEquals(2, fs.getCurrentDirectory().numFiles());
  }

  @Test
  public void testDir() throws Exception {
    FileSystem fs = new FileSystem();
    fs.mkdir("c");
    fs.mkdir("a");
    fs.mkdir("b");

    ArrayList<String> testArrayList = new ArrayList<>();
    testArrayList.add("a");
    testArrayList.add("b");
    testArrayList.add("c");

    ArrayList<Entry> entries = fs.dir();
    for (int i = 0; i < entries.size(); i++) {
      String value = entries.get(i).getName();
      assertEquals(value, testArrayList.get(i));
    }
  }

}