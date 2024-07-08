// “A class should have one, and only one, reason to change.”

import java.util.List;

public class Order {

    private List<String> items;
    private double totalAmount;
    
    public void setItems(List<String> items) {
        this.items = items;
    }

    public Order(List<String> items) {
        this.items = items;
    }

    // getters and setters
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


    public List<String> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
