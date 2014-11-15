package OnlineBookReader;

import java.util.HashMap;

/**
 * Author: Alex Yang
 * Date: 11/14/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class UserManager {
  private HashMap<Integer, User> users = new HashMap<>();

  //add users
  public User addUser(int id, String details, int accountType) {
    if (users.containsKey(id)) {
      return null;
    }

    User user = new User(id, details, accountType);
    users.put(id, user);
    return user;
  }

  //remove users
  public boolean remove(User u) {
    return remove(u.getUserId());
  }

  public boolean remove(int id) {
    if (!users.containsKey(id)) {
      return false;
    }
    users.remove(id);
    return true;
  }

  //find a user
  public User find(int id){
    return users.get(id);
  }
}
