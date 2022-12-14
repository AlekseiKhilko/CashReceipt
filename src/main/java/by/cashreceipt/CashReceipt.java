package by.cashreceipt;


import java.text.NumberFormat;
import java.util.Locale;

public class CashReceipt {
    Locale locale = new Locale("en", "US");
    NumberFormat currencyFormatter;
    private String textShop = "SUPERMARKT 123";
    private String textAddress = "123, MILKYWAY Galaxy/ Earth";
    private String textPhone = "Tel: 123-456-789";
    private Integer cashirNomber = 4435435;

    private Integer cashReceiptWidthChar = 44;
    private Cart cart;
    private CashReceiptPrint cashReceiptPrint;

    public CashReceipt(Cart cart) {
        this.cart = cart;
        this.setCurrencyFormatter(NumberFormat.getCurrencyInstance(this.locale));
        this.cashReceiptPrint = new CashReceiptPrint(cart);
    }

    public CashReceiptPrint getCashReceiptPrint() {
        return cashReceiptPrint;
    }

    public void setCashReceiptPrint(CashReceiptPrint cashReceiptPrint) {
        this.cashReceiptPrint = cashReceiptPrint;
    }

    public void print() {
        this.getCashReceiptPrint()
                .header()
                .line('-')
                .body()
                .line('=')
                .footer();
    }

    public void save(String filename) {
        this.getCashReceiptPrint().saveToFile(filename);
    }
    /*
            public void printHeader(){
                System.out.printf("\n%s\n\n", StringUtils.center("CASH RECEIPT", cashReceiptWidthChar));
                System.out.printf("%s\n%s\n%s\n\n",
                        StringUtils.center(textShop, cashReceiptWidthChar),
                        StringUtils.center(textAddress, cashReceiptWidthChar),
                        StringUtils.center(textPhone, cashReceiptWidthChar));

                System.out.printf("%s%s\n",
                        padRight("CASHIER: №" + cashirNomber, cashReceiptWidthChar/2),
                        padLeft("DATE: 435435", cashReceiptWidthChar/2));

                System.out.println(padLeft("TIME: 435435", cashReceiptWidthChar));
            }
            public static String padRight(String s, int n) {
                return String.format("%-" + n + "s", s);
            }
            public static String padLeft(String s, int n) {
                return String.format("%" + n + "s", s);
            }
            public void printLine(char padChar){
                String line = new String(new char[cashReceiptWidthChar]).replace('\0', padChar);
                System.out.println(line);
            }
            public void printBody(){

                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(this.locale);

                for(CartItem item: cart.getItems()){
                    Integer quantity = item.getQuantity();
                    String name = item.getProduct().getName();
                    Double price = item.getProduct().getPrice();
                    Double total = item.getTotal();

                    if(name.length() > 20){
                        name = name.substring(0, 17) + "...";
                    }

                    System.out.printf("%s%s%s%s\n",
                            padRight(quantity.toString(), 4),
                            padRight(name, 20),
                            padLeft(getCurrencyFormatter().format(price), 10),
                            padLeft(getCurrencyFormatter().format(total), 10));

                }
            }
            public void printFooter(){
                System.out.printf("%s%s\n",
                        padRight("TAXABLE TOT.", cashReceiptWidthChar/2),
                        padLeft(getCurrencyFormatter().format(cart.getTaxableTotalValue()), cashReceiptWidthChar/2));

                System.out.printf("%s%s\n",
                        padRight("VAT" + cart.getVatRate() + "%", cashReceiptWidthChar/2),
                        padLeft(getCurrencyFormatter().format(cart.getVatValue()), cashReceiptWidthChar/2));

                System.out.printf("%s%s\n",
                        padRight("TOTAL", cashReceiptWidthChar/2),
                        padLeft(getCurrencyFormatter().format(cart.getTotalValue()), cashReceiptWidthChar/2));
            }
        */
    public NumberFormat getCurrencyFormatter() {
        return currencyFormatter;
    }

    public void setCurrencyFormatter(NumberFormat currencyFormatter) {
        this.currencyFormatter = currencyFormatter;
    }

}
