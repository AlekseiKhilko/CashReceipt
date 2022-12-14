package by.cashreceipt;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PartMap {

    private Map<String, String> argsMap;
    private String[] args;

    public PartMap(String[] args) {
        this.args = args;
        this.parse();
    }

    public void parse(){
        this.argsMap = new HashMap<>();
        for (String arg: this.args) {
            String[] parts = arg.split("-");
            this.argsMap.put(parts[0], parts[1]);
        }
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public Map<String, String> getArgsMap() {
        return argsMap;
    }

    public String toString() {
        String mapAsString = this.argsMap.keySet().stream()
                .map(key -> key + "=" + this.argsMap.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }

    public void setArgsMap(Map<String, String> argsMap) {
        this.argsMap = argsMap;
    }

    public Map<Integer, Integer> getProductAndQuntity(){
        Map<Integer, Integer> productsAndQuantityMap = new HashMap<>();
        for (Map.Entry<String, String> entry : argsMap.entrySet()) {
            if(entry.getKey().matches("\\d+")){
                Integer product = Integer.valueOf(entry.getKey());
                Integer quntity = Integer.valueOf(entry.getValue());
                productsAndQuantityMap.put(product, quntity);
                //System.out.println(entry.getKey() + "/" + entry.getValue());
            }

        }
        return productsAndQuantityMap;
    }

    public Optional<Integer> getCard(){
        for (Map.Entry<String, String> entry : argsMap.entrySet()) {
            if(entry.getKey().contains("Card")){
                Integer cardNumber = Integer.valueOf(entry.getValue());
                return Optional.of(cardNumber);
            }

        }
        return Optional.empty();
    }
}
