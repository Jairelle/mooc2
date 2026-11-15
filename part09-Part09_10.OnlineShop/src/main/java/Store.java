
import java.util.Scanner;

public class Store {

    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("Products: " + this.warehouse.products());
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = this.scanner.nextLine();
            if (product.isEmpty()) {
                break;
            }

            if (this.warehouse.take(product)) {
                cart.add(product, this.warehouse.price(product));
            }
        }

        System.out.println();
        System.out.println(customer + ", products in your shopping cart:");
        cart.print();
        System.out.println("Total: " + cart.price());
    }
}
