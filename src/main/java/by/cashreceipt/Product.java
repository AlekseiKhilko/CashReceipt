package by.cashreceipt;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Double oldPrice = null;
    private Boolean promo = false;

    public Product(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Integer id, String name, Double price, Boolean promo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.promo = promo;
    }

    public Product(Integer id, String name, Double price, Double oldPrice, Boolean promo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.promo = promo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getPromo() {
        return promo;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Boolean promoExists() {
        if(this.promo){
            return true;
        }
        return true;
    }

    public Boolean oldPriceExists() {
        if(this.oldPrice == null){
            return false;
        }
        return true;
    }
}
