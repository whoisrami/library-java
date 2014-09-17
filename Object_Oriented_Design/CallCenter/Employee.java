package CallCenter;

/**
 * Created by alexyang on 9/16/14.
 */
public abstract class Employee {
  private Call currentCall = null;
  protected Rank rank;

  public Employee () {};

  public void callComplete() {
    if (this.currentCall == null) return;
    this.currentCall.disconnect();
    this.currentCall = null;

    this.assignNewCall();
  }

  public void escalateAndReassign() {
    if (this.currentCall != null) {
      this.currentCall.escalateRank();
      CallHandler.getInstance().dispatchCall(this.currentCall);
      this.currentCall = null;
    }
		// assign employee a new call if any available
    this.assignNewCall();
  }

  public void assignNewCall() {
    if (!isFree()) System.out.println(this.getRank() + " is currently not free");
    CallHandler.getInstance().assignCall(this);
  }

  public Call getCurrentCall() {
    return currentCall;
  }

  public void setCurrentCall(Call currentCall) {
    System.out.println(this.getRank() + " has received a call from " + currentCall.getCaller().getName());
    this.currentCall = currentCall;
  }

  public Rank getRank() {
    return rank;
  }

  public void setRank(Rank rank) {
    this.rank = rank;
  }

  public boolean isFree() {
    return this.currentCall == null;
  }

}
