package BlackJack;

public class BlackJackCard extends Card {
  public BlackJackCard(int value, Suit suit) {
    super(value, suit);
  }

  public int value() {
    if (isAce()) {
      return 1;
    } else if (isRoyal()) {
      return 10;
    } else {
      return this.value;
    }
  }

  public boolean isAce() {
    return this.value == 1;
  }

  public boolean isRoyal() {
    return this.value >= 11 && this.value <= 13;
  }
}