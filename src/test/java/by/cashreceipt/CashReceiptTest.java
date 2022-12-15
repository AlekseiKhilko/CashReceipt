package by.cashreceipt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;
import java.util.List;

public class CashReceiptTest {
    @Test
    void partMapTest() {
        String[] args = {"1-10","2-20","3-10","card-1","file-cash_receipt.txt"};
        PartMap partMap = new PartMap(args);
        assertEquals(3, partMap.getProductAndQuntity().size());
        assertEquals(1, partMap.getCard().get());
        assertEquals("cash_receipt.txt", partMap.getFilename().get());
    }

    @Test
    void productService() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "Test product 1", 10.0, true));
        productList.add(new Product(2, "Test product 2", 20.0, true));
        productList.add(new Product(3, "Test product 3", 10.0, true));
        ProductService productService = new ProductService(productList);
        Product product = productService.findById(1);

        assertTrue(productList instanceof List<Product>);
        assertEquals(3, productList.size());
        assertTrue(product instanceof Product);
        assertEquals("Test product 1", product.getName());
        assertEquals(10.0, product.getPrice());
        assertEquals(true, product.getPromo());
    }

    @Test
    void cardTest() {
        Card card = new Card();
        card.setId(1);
        card.setDiscount(10);

        assertTrue(card instanceof Card);
        assertEquals(1, card.getId());
        assertEquals(10, card.getDiscount());
    }
    @Test
    void creatCadListTest() {
        List<Card> carList = new ArrayList<Card>();
        carList.add(new Card(1, 10));
        carList.add(new Card(2, 10));
        CardService cardService = new CardService();
        cardService.setCardList(carList);
        Integer cardId = 1;
        Card card = cardService.findById(cardId);

        assertTrue(carList instanceof List<Card>);
        assertEquals(2, carList.size());
        assertEquals(carList, cardService.getCardList());
        assertTrue(cardService instanceof CardService);
        assertTrue(card instanceof Card);
        assertEquals(1, card.getId());
        assertEquals(10, card.getDiscount());
    }

    @Test
    void cartTest() {
        ProductPromo productPromo = new ProductPromo(10, 5);
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "Test product 1", 10.0, true));
        productList.add(new Product(2, "Test product 2", 20.0, true));

        ProductService productService = new ProductService(productList);
        Cart cart = new Cart(productService);
        cart.addItem(1, 1);
        cart.addItem(2, 10);

        cart.setProductPromo(productPromo);
        cart.setVatRate(17);
        cart.calculate();

        assertTrue(cart instanceof Cart);
        assertEquals(2, cart.getItems().size());
        assertEquals(17, cart.getVatRate());
        assertEquals(190.0, cart.getTaxableTotalValue());
        assertEquals(222.3, cart.getTotalValue());
    }

    @Test
    void cashReceiptTest() {
        ProductPromo productPromo = new ProductPromo(10, 5);
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "Test product 1", 10.0, true));
        productList.add(new Product(2, "Test product 2", 20.0, true));

        List<Card> carList = new ArrayList<Card>();
        carList.add(new Card(1, 10));
        carList.add(new Card(2, 10));

        ProductService productService = new ProductService(productList);
        Cart cart = new Cart(productService);
        cart.addItem(1, 1);
        cart.addItem(2, 10);

        CardService cardService = new CardService(carList);
        Card card = cardService.findById(1);

        cart.setProductPromo(productPromo);
        cart.setVatRate(17);
        cart.setCard(card);
        cart.calculate();

        CashReceipt cashReceipt = new CashReceipt(cart);

        assertTrue(cashReceipt instanceof CashReceipt);
        assertEquals(2, cart.getItems().size());
        assertEquals(2, cart.getItems().size());
        assertEquals(19.0, cart.getDiscountValue());
    }
}
