package by.cashreceipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {

        args = new String[] {"1-10","2-20","3-10","Card-1","File-cash_receipt.txt"};

        PartMap partMap = new PartMap(args);


        ProductPromo productPromo = new ProductPromo(10, 5);
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1, "Test product 1", 10.0, true));
        productList.add(new Product(2, "Test  product2 product2 product2 product2", 20.0, true));
        productList.add(new Product(3, "Test product 3", 10.0, true));
        productList.add(new Product(4, "Test product 4", 10.4, true));
        productList.add(new Product(5, "Test product 5", 110.4, true));
        productList.add(new Product(6, "Test product 6", 13.4));
        productList.add(new Product(7, "Test product 7", 70.4));
        productList.add(new Product(8, "Test product product product product 8", 10.4));

        List<Card> carList = new ArrayList<Card>();
        carList.add(new Card(1, 10));
        carList.add(new Card(2, 10));



        Integer vatRate = 17;

        ProductService productService = new ProductService(productList);
        Cart cart = new Cart(productService);
        /*
        cart.addItem(1, 1);
        cart.addItem(2, 10);
        cart.addItem(3, 10);
         */
        for (Map.Entry<Integer, Integer> entry : partMap.getProductAndQuntity().entrySet()) {
            Integer product = entry.getKey();
            Integer quntity = entry.getValue();
            cart.addItem(product, quntity);
        }

        if(partMap.getCard().isPresent()){
            CardService cardService = new CardService(carList);
            Integer cardId = partMap.getCard().get();
            Card card = cardService.findById(cardId);
            cart.setCard(card);
        }

        cart.setProductPromo(productPromo);
        cart.setVatRate(vatRate);
        cart.calculate();

        CashReceipt cashReceipt = new CashReceipt(cart);
        cashReceipt.print();

        Optional<String> cashReceiptFilename = partMap.getFilename();
        if(cashReceiptFilename.isPresent()) {
            cashReceipt.save(cashReceiptFilename.get());
        }

    }
}