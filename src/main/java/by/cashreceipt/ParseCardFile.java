package by.cashreceipt;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class ParseCardFile {
    private String filename = "./Card.txt";

    public List<Card> get() {
        try {
            File file = new File(this.filename);
            Scanner scanner = new Scanner(file);
            List<Card> cardList = new ArrayList<Card>();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] details = line.split(";");
                Integer id = Integer.parseInt(details[0]);
                Integer discount = Integer.parseInt(details[1]);
                Card card = new Card(id, discount);
                cardList.add(card);
            }

            return cardList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
