package by.cashreceipt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseProductFile {
    private String filename = "./Product.txt";

    public List<Product> get() {
        try {
            File file = new File(this.filename);
            Scanner scanner = new Scanner(file);
            List<Product> productList = new ArrayList<Product>();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
                String[] details = line.split(";");
                Integer id = Integer.parseInt(details[0]);
                String name = details[1];
                Double price = Double.parseDouble(details[2]);
                Product product = new Product();
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                if(details.length > 3) {
                    Boolean promo = Boolean.parseBoolean(details[3]);
                    product.setPromo(promo);
                }
                productList.add(product);
            }

            return productList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("fuck");
        }

        return null;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
