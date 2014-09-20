package HashTable;

import java.util.LinkedList;

/**
 * Created by alexyang on 9/19/14.
 */
public class Hash<K, V> {
  private final int MAX_SIZE = 5;
  LinkedList<Cell<K, V>>[] items;

  public Hash() {
    this.items = (LinkedList<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
  }

  //temporary, BAD hashcode method
  public int hashCodeOfKey(K key) {
    return key.toString().length() % items.length;
  }

  public void put(K key, V value) {
    //use hashcode method of key to get index
    int index = hashCodeOfKey(key);

    if (this.items[index] == null) {
      this.items[index] = new LinkedList<Cell<K, V>>();
    }

    LinkedList<Cell<K, V>> list = this.items[index];
    for (Cell<K,V> cell : list) {
      if (cell.equivalent(key)) {
        list.remove(cell);
        break;
      }
    }
    list.add(new Cell<K,V>(key, value));
  }

  public V get(K key) {
    int index = hashCodeOfKey(key);

    if(this.items[index] == null) {
      return null;
    }

    LinkedList<Cell<K, V>> list = this.items[index];
    for (Cell<K,V> cell : list) {
      if (cell.equivalent(key)) {
        return cell.getValue();
      }
    }
    return null;
  }
}
