package by.cashreceipt;

public class Card {
    private Integer id;
    private Integer discount;

    public Card() {
    }
    public Card(Integer id, Integer discount) {
        this.id = id;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
