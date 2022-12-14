package by.cashreceipt;

import java.util.ArrayList;
import java.util.List;
public class ProductService {
    private List<Product> productList;

    public ProductService(List<Product> productList) {
        this.productList = productList;
    }

    public Product findById(Integer id){
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new IllegalArgumentException("Product index is out of range.");
    }

    public Product findByName(String name){
        for (Product product : productList) {
            if (product.getId().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
