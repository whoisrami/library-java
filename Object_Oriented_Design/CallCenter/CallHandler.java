package CallCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexyang on 9/16/14.
 */
public class CallHandler {
  private static CallHandler instance = null;

  /* Initialize with 10 respondents, 4 managers, and 2 directors. */
  private final int NUM_RESPONDENTS = 10;
  private final int NUM_MANAGERS = 4;
  private final int NUM_DIRECTORS = 2;

  private ArrayList<Respondent> respondents = new ArrayList<>(NUM_RESPONDENTS);
  private ArrayList<Manager> managers = new ArrayList<>(NUM_MANAGERS);
  private ArrayList<Director> directors = new ArrayList<>(NUM_DIRECTORS);

  private ArrayList<Call> responderCallQueue = new ArrayList<>();
  private ArrayList<Call> managerCallQueue = new ArrayList<>();
  private ArrayList<Call> directorCallQueue = new ArrayList<>();

  /* Get instance of singleton class. */
  public static CallHandler getInstance() {
    if (instance == null) {
      instance = new CallHandler();
    }
    return instance;
  }

  protected CallHandler() {
    for (int r = 0; r < NUM_RESPONDENTS; r++) {
      this.respondents.add(new Respondent());
    }
    for (int m = 0; m < NUM_MANAGERS; m++) {
      this.managers.add(new Manager());
    }
    for (int d = 0; d < NUM_DIRECTORS; d++) {
      this.directors.add(new Director());
    }
  }

  public void dispatchCall(Caller caller) {
    Call call = new Call(caller);
    dispatchCall(call);
  }

  public void dispatchCall(Call call) {
    //check for call rank first
    Rank callRank = call.getRank();

    //check if any available employees in given rank
    switch (callRank) {
      case Responder:
        responderCallQueue.add(call);
        for (Respondent respondent : respondents) {
          if (respondent.isFree()) {
            respondent.assignNewCall();
            return;
          }
        }

        break;
      case Manager:
        managerCallQueue.add(call);
        for (Manager manager : managers) {
          if (manager.isFree()) {
            manager.assignNewCall();
            return;
          }
        }
        break;
      case Director:
        directorCallQueue.add(call);
        for (Director director : directors) {
          if (director.isFree()) {
            director.assignNewCall();
            return;
          }
        }
        break;
    }

    System.out.println("No one available to take the call right now.  Please hold");

  }

  public void assignCall(Employee e) {
    //look inside queue to see if there are any calls of that rank
    Rank employeeRank = e.getRank();
    if (employeeRank == Rank.Responder && !responderCallQueue.isEmpty()) {
      e.setCurrentCall(responderCallQueue.remove(0));
    } else if (employeeRank == Rank.Manager && !managerCallQueue.isEmpty()) {
      e.setCurrentCall(managerCallQueue.remove(0));
    } else if (employeeRank == Rank.Director && !directorCallQueue.isEmpty()){
      e.setCurrentCall(directorCallQueue.remove(0));
    } else {
      //have employee do nothing, since nothing in any queues
      return;
    }
  }
}
