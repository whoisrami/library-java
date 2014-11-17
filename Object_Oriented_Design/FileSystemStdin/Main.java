package FileSystemStdin;

import java.io.*;

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
public class Main {
  public static void main(String args[]) throws IOException {
    FileSystem fs = new FileSystem();
    String thisLine;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while ((thisLine = br.readLine()) != null) {
      String[] tokens = thisLine.split(" ");

      fs.displayCommand(tokens);

      switch(tokens[0]) {
        case "dir":
          fs.pwd();
          fs.dir();
          break;
        case "up":
          fs.up();
          break;
        case "mkdir":
          if (tokens.length > 1 && tokens[1].length() <= 6) {
            fs.mkdir(tokens[1]);
          }
          break;
        case "cd":
          if (tokens.length > 1 && tokens[1].length() <= 6) {
            fs.cd(tokens[1]);
          }
          break;
      }
    }
  }
}
