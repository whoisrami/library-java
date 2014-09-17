package CallCenter;

/**
 * Created by alexyang on 9/16/14.
 */
public class Test {
  public static void main(String[] args) {
    CallHandler ch = CallHandler.getInstance();

    Caller alex = new Caller("alex", 1);
    Call alexCall = new Call(alex);

    ch.dispatchCall(alexCall);
  }
}
