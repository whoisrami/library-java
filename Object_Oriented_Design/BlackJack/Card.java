package BlackJack;

public abstract class Card {
  //protected since BlackJackCard needs to be able to read these as well
  protected int value;
  protected Suit suit;

  public Card(int value, Suit suit) {
    this.value = value;
    this.suit = suit;
  }

  public abstract int value();

  public Suit suit() {
    return this.suit;
  }

  public void print() {
    String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    System.out.print(values[this.value - 1]);
    switch (suit) {
      case Club:
        System.out.print("club");
        break;
      case Heart:
        System.out.print("heart");
        break;
      case Diamond:
        System.out.print("diamond");
        break;
      case Spade:
        System.out.print("spade");
        break;
    }
    System.out.print(" ");
  }
}