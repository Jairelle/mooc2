import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> debts;

    public IOU() {
        this.debts = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        this.debts.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        // Returns 0.0 if the person is not found in the map
        return this.debts.getOrDefault(toWhom, 0.0);
    }
}