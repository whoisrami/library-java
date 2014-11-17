package FileSystem;

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
    fs.mkFile("testFile");
    assertEquals(2, fs.getCurrentDirectory().numFiles());
  }

  @Test
  public void testLs() throws Exception {
    FileSystem fs = new FileSystem();
    fs.mkdir("c");
    fs.mkdir("a");
    fs.mkFile("b");

    ArrayList<String> testArrayList = new ArrayList<>();
    testArrayList.add("c");
    testArrayList.add("a");
    testArrayList.add("b");

    ArrayList<Entry> entries = fs.ls();
    for (int i = 0; i < entries.size(); i++) {
      String value = entries.get(i).getName();
      assertEquals(value, testArrayList.get(i));
    }
  }

  @Test
  public void testLsSort() throws Exception {
    FileSystem fs = new FileSystem();
    fs.mkdir("c");
    fs.mkdir("a");
    fs.mkFile("b");

    ArrayList<String> testArrayList = new ArrayList<>();
    testArrayList.add("a");
    testArrayList.add("b");
    testArrayList.add("c");

    ArrayList<Entry> entries = fs.ls("l");
    for (int i = 0; i < entries.size(); i++) {
      String value = entries.get(i).getName();
      assertEquals(value, testArrayList.get(i));
    }
  }

  @Test
  public void testCd() throws Exception {

  }

  @Test
  public void testPwd() throws Exception {

  }

  @Test
  public void testMkdir() throws Exception {

  }

  @Test
  public void testMkFile() throws Exception {

  }
}