package FileSystemSalesForce;

import org.apache.commons.lang.StringUtils;

import java.util.*;

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
public class FileSystem {
  private Directory currentDirectory;

  public FileSystem() {
    this.currentDirectory = new Directory("root", null);
  }

  public ArrayList<Entry> dir() {
    Map<String, Entry> contents = new HashMap<>(currentDirectory.getContents());
    ArrayList<Entry> entries = new ArrayList<>();

    for (Entry e : contents.values()) {
      entries.add(e);
    }

    if (entries.size() == 0) {
      System.out.println("No subdirectories");
      return null;
    }

    Collections.sort(entries, new Comparator<Entry>() {
      public int compare(Entry e1, Entry e2) {
        return e1.getName().compareTo(e2.getName());
      }
    });

    display(entries);
    return entries;
  }

  public void pwd() {
    System.out.println("Directory of " + currentDirectory.getPath() + ": ");
  }

  public void up() {
    if (currentDirectory.getParent() == null) {
      System.out.println("Cannot move up from root directory");
      return;
    }
    currentDirectory = currentDirectory.getParent();
  }

  //changes directory to given directory
  public void cd(String s) {
    Map<String, Entry> contents = new HashMap<>(currentDirectory.getContents());

    if (contents.containsKey(s)) {
      currentDirectory = (Directory)contents.get(s);
    } else {
      System.out.println("Subdirectory does not exist");
    }
  }

  //creates new directory
  public void mkdir(String s) {
    currentDirectory.addEntry(new Directory(s, currentDirectory));
  }

  //displays entries in directory with formmated outupt
  public void display(ArrayList<Entry> contents) {
    int counter = 0;
    for (Entry content : contents) {
      if (counter == 10) System.out.print("\n");
      System.out.print(content.getName());
      System.out.print(padSpaces(content.getName()));
      counter++;
    }
    System.out.print("\n");
  }

  //displays the command with formatted output
  public void displayCommand(String[] tokens) {
    System.out.print("Command: ");
    for (String s : tokens) {
      System.out.print(s);
      System.out.print(padSpaces(s));
    }
    System.out.print("\n");
  }

  //use StringUtils.repeat to buffer each entry with spaces
  public String padSpaces(String str) {
    int numSpaces = 8 - str.length();
    String repeated = StringUtils.repeat(" ", numSpaces);
    return repeated;
  }
}

