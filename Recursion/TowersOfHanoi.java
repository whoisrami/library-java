import java.util.Stack;

/**
 * Author: Alex Yang
 * Date: 9/11/2014
 * Dependencies:
 *  - None
 * Description:
 *  - The famous Towers of Hanoi recursion problem, implemented using stacks.
 * Solution(s):
 *  - No description.
 */

class TowersOfHanoi {
  public static void main(String args[]) throws Exception {
    //initialize towers
    Tower[] towers = new Tower[3];
    for (int i = 0; i < 3; i++) {
      towers[i] = new Tower(i);
    }

    //add n disks to first tower in reverse order
    int n = 3;
    for (int i = n-1; i >= 0; i--) {
      towers[0].add(i);
    }

    System.out.println("calling moveDisks(" + (n) + ", " + towers[2].index() + ", " + towers[1].index() + ")" );
    //move from tower 0 to tower 2, using 1 as buffer
    towers[0].moveDisks(n, towers[2], towers[1]);
  }
}
class Tower {
  private Stack<Integer> disks;
  private int index;

  public Tower(int i) {
    disks = new Stack<Integer>();
    index = i + 1;
  }

  public int index() {
    return index;
  }

  //add disk to tower stack
  public void add(int d) {
    disks.push(d);
  }

  //move top disk from origin to destination
  public void moveOne(Tower t) {
    int disk = disks.pop();
    t.add(disk);
    System.out.println("Move disk " + (disk+1) + " from tower " + index + " to tower " + t.index);
  }

  //move top n-1 disks from origin/buffer to destination or vice versa
  public void moveDisks(int n, Tower destination, Tower buffer) {
    //base case
    if (n <= 0) {
      System.out.println("Returning, n is: " + n);
      return;
    }

    //move top n-1 disks from origin to buffer, using destination as buffer
    System.out.println("calling moveDisks(" + (n-1) + ", " + buffer.index + ", " + destination.index + ")" );
    moveDisks(n - 1, buffer, destination);

    //move one disk from origin to its "final" destination
    moveOne(destination);

    System.out.println("calling t" + buffer.index + ".moveDisks(" + (n-1) + ", " + destination.index + ", " + this.index + ")" );
    //move all the disks back on top of that one disk that was just moved
    buffer.moveDisks(n - 1, destination, this);
  }
}