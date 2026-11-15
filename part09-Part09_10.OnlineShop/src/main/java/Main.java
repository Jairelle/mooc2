
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("coffee", 5, 10);
        warehouse.addProduct("milk", 3, 20);
        warehouse.addProduct("bread", 7, 8);

        Store store = new Store(warehouse, new Scanner(System.in));
        store.shop("Nikolai");
    }
}
