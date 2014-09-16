package BlackJack;

import java.util.ArrayList;

public class Deck<T extends Card> {
  private ArrayList<T> cards;
  private int dealtIndex;

  public Deck(ArrayList<T> cards) {
    this.cards = cards;
  }

  public void shuffle() {
    //TODO: implement shuffling cards
  }

  public int remainingCards() {
    return cards.size() - dealtIndex;
  }

  public ArrayList<T> dealHand(int number) {
    if (remainingCards() < number) {
      return null;
    }

    ArrayList<T> hand = new ArrayList<T>();
    int count = 0;
    while (count < number) {
      T card = dealCard();
      hand.add(card);
      count++;
    }

    return hand;
  }

  public T dealCard() {
    if (remainingCards() == 0) {
      return null;
    }

    T card = cards.get(dealtIndex);
    dealtIndex++;
    return card;
  }
}