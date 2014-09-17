package CallCenter;

/**
 * Created by alexyang on 9/16/14.
 */
public class Call {
  private Rank rank;
  private Caller caller;
  private Employee handler;

  public Call(Caller caller) {
    this.rank = Rank.Responder;
    this.caller = caller;
  }

  public Employee getHandler() {
    return handler;
  }

  public void setHandler(Employee handler) {
    this.handler = handler;
  }

  public void putOnHold() {
    System.out.println("No one available at this time.  Please hold.");
  }

  public Rank escalateRank() {
    if(this.rank == Rank.Responder) {
      this.rank = Rank.Manager;
    } else if (this.rank == Rank.Manager) {
      this.rank = Rank.Director;
    }
    return rank;
  }

  public void disconnect() {
    System.out.println(this.caller.getName() + " Disconnected");
  }

  public Rank getRank() {
    return rank;
  }

  public void setRank(Rank rank) {
    this.rank = rank;
  }

  public Caller getCaller() {
    return caller;
  }

  public void setCaller(Caller caller) {
    this.caller = caller;
  }
}
