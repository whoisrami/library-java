package FileSystem;

/**
 * Created by alexyang on 9/19/14.
 */
public abstract class Entry {
  protected String name;
  protected Directory parent;
  protected long created;
  protected long lastUpdated;
  protected long lastAccessed;

  public abstract int size();

  public Entry(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
    this.created = System.currentTimeMillis();
    this.lastUpdated = System.currentTimeMillis();
    this.lastAccessed = System.currentTimeMillis();
  }

  public void delete() {
    if (this.parent == null) return;
    this.parent.deleteEntry(this);
  }

  public String getPath() {
    if (this.parent == null) {
      return name;
    } else {
      return parent.getPath() + "/" + name;
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Directory getParent() {
    return parent;
  }

  public void setParent(Directory parent) {
    this.parent = parent;
  }

  public long getCreated() {
    return created;
  }

  public void setCreated(long created) {
    this.created = created;
  }

  public long getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(long lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public long getLastAccessed() {
    return lastAccessed;
  }

  public void setLastAccessed(long lastAccessed) {
    this.lastAccessed = lastAccessed;
  }
}
