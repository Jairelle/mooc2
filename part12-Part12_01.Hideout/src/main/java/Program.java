
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hideout<String> hideout = new Hideout<>();
        System.out.println(hideout.isInHideout());

        hideout.putIntoHideout("Pearl necklace");
        System.out.println(hideout.isInHideout());
        System.out.println(hideout.takeFromHideout());
        System.out.println(hideout.isInHideout());
    }
}
