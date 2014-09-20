package HashTable;

/**
 * Created by alexyang on 9/19/14.
 */
public class Cell<K, V> {
  private K key;
  private V value;

  public Cell(K key, V value) {
    this.key = key;
    this.value = value;
  }

//  public boolean equivalent(Cell<K, V> cell) {
//    return equivalent(cell.getKey());
//  }

  public boolean equivalent(K key) {
    return this.key.equals(key);
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}
