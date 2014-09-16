package BlackJack;

public class BlackJackHand extends Hand<BlackJackCard> {
  public int score () {
    int score = 0;
    int aces = 0;
    for (BlackJackCard card : cards) {
      if (card.isAce()) {
        aces += card.value();
      } else {
        score += card.value();
      }
    }

    for (int i = 0; i < aces; i++) {
      //check if bust and handle remaining aces
      if (score + 1 <= 21 && score + 11 + (aces - i) > 21) {
        score += 1;
      } else if (score + 1 <= 21 && score + 11 + (aces - i) <= 21) {
        score += 11;
      } else {
        //if bust set score to max value
        score = Integer.MAX_VALUE;
        break;
      }
    }
    return score;
  }

  public boolean isBust() {
    return score() > 21;
  }

  public boolean is21() {
    return score() == 21;
  }

  public boolean isBlackJack() {
    if (cards.size() != 2) {
      System.out.println("More than two cards in hand");
      return false;
    }
    return (cards.get(0).isAce() && cards.get(1).isRoyal()) ||
           (cards.get(0).isRoyal() && cards.get(1).isAce());
  }
}