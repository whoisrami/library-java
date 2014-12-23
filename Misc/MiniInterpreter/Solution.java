package MiniInterpreter;

/**
 * Author: Alex Yang
 * Date: 12/21/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    try{
      BufferedReader br =
              new BufferedReader(new InputStreamReader(System.in));

      String input;

      while((input=br.readLine())!=null){
        List<String> list = parseTerm(input);
        if (list.get(0).equals("add")) {
          System.out.println(add(list.get(1), list.get(2)));
        } else if (list.get(0).equals("mult")) {
          System.out.println(mult(list.get(1), list.get(2)));
        }
      }

    }catch(IOException io){
      io.printStackTrace();
    }
  }

  static List<String> parseTerm(String s) {
    String term = s.trim();
    if (term.charAt(0) == '(' && term.charAt(term.length()-1) == ')') {
      term = term.substring(1, term.length() - 1);
    }

    int parenCounter = 0;
    int i = 0;
    int j = 0;
    ArrayList<String> terms = new ArrayList<String>();
    for (i = 0; i < term.length(); i++) {
      if (term.charAt(i) == '(') parenCounter++;
      if (term.charAt(i) == ')') parenCounter--;

      if (parenCounter == 0 && term.charAt(i) == ' ') {
        terms.add(term.substring(j, i));
        j = i + 1;
      }
    }
    terms.add(term.substring(j, i));
    return terms;
  }

  static int add(String t1, String t2) {
    int left = Integer.MIN_VALUE;
    int right = Integer.MIN_VALUE;

    if (t1.contains("(")) {
      List<String> terms = parseTerm(t1);
      if (terms.get(0).equals("add")) {
        left = add(terms.get(1), terms.get(2));
      }
      if (terms.get(0).equals("mult")) {
        left = mult(terms.get(1), terms.get(2));
      }
    } else {
      left = Integer.parseInt(t1);
    }

    if (t2.contains("(")) {
      List<String> terms = parseTerm(t2);
      if (terms.get(0).equals("add")) {
        right = add(terms.get(1), terms.get(2));
      }
      if (terms.get(0).equals("mult")) {
        right = mult(terms.get(1), terms.get(2));
      }
    } else {
      right = Integer.parseInt(t2);
    }

    return left + right;
  }

  static int mult(String t1, String t2) {
    int left = Integer.MIN_VALUE;
    int right = Integer.MIN_VALUE;

    if (t1.contains("(")) {
      List<String> terms = parseTerm(t1);
      if (terms.get(0).equals("add")) {
        left = add(terms.get(1), terms.get(2));
      }
      if (terms.get(0).equals("mult")) {
        left = mult(terms.get(1), terms.get(2));
      }
    } else {
      left = Integer.parseInt(t1);
    }

    if (t2.contains("(")) {
      List<String> terms = parseTerm(t2);
      if (terms.get(0).equals("add")) {
        right = add(terms.get(1), terms.get(2));
      }
      if (terms.get(0).equals("mult")) {
        right = mult(terms.get(1), terms.get(2));
      }
    } else {
      right = Integer.parseInt(t2);
    }

    return left * right;
  }
}
