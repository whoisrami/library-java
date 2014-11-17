package FileSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Author: Alex Yang
 * Date: 11/16/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class FileSystem {
  public static void main(String args[]) throws IOException {
    FileSystem fs = new FileSystem();
    String thisLine;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Logged in and awaiting input.");
    while ((thisLine = br.readLine()) != null) {
      String[] tokens = thisLine.split(" ");

      if (tokens[0].equals("exit")) {
        break;
      }

      //TODO: implement cd and pwd, as well as multiple tokens
      switch(tokens[0]) {
        case "ls":
          if (tokens.length > 1) {
            fs.ls(tokens[1]);
          } else {
            fs.ls();
          }
          break;
        case "mkdir":
          if (tokens.length > 1) {
            fs.mkdir(tokens[1]);
          }
          break;
      }
    }

    System.out.println("Exited system.");
  }

  private  Directory currentDirectory;

  public FileSystem() {
    this.currentDirectory = new Directory("~/root", null);
  }

  public ArrayList<Entry> ls() {
    display(currentDirectory.getContents());
    return currentDirectory.getContents();
  }

  public ArrayList<Entry> ls(String flags) {
    ArrayList<Entry> entries = new ArrayList<>(currentDirectory.getContents());
    char[] carray = flags.toCharArray();

    for (char c : carray) {
      if (c == 'l') { //sort by name
        Collections.sort(entries, new Comparator<Entry>() {
          public int compare(Entry e1, Entry e2) {
            return e1.getName().compareTo(e2.getName());
          }
        });
      }
    }
    display(entries);
    return entries;
  }

  public void cd(String s) {
    if (s.equals("..")) {
      currentDirectory = currentDirectory.getParent();
    }

    for (Entry e : currentDirectory.getContents()) {
      if (e.getName().equals(s) && e instanceof Directory) {
        currentDirectory = (Directory)e;
      }
    }
  }

  public void pwd() {
    System.out.println(currentDirectory.getPath());
  }

  public void mkdir(String s) {
    currentDirectory.addEntry(new Directory(s, currentDirectory));
  }

  public void mkFile(String s) {
    currentDirectory.addEntry(new File(s, currentDirectory, 32));
  }

  public Directory getCurrentDirectory() {
    return currentDirectory;
  }

  public void display(ArrayList<Entry> contents) {
    for (Entry content : contents) {
      System.out.println(content.getName());
    }
  }
}
