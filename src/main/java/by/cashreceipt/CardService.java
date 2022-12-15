package by.cashreceipt;

import java.util.List;

public class CardService {
    private List<Card> cardList;

    public CardService() {
    }
    public CardService(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Card findById(Integer id){
        for (Card card : cardList) {
            if (card.getId() == id) {
                return card;
            }
        }
        throw new IllegalArgumentException("Card index is out of range.");
    }
    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
