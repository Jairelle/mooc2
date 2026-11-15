
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, String> map = new HashMap<>();
        map.add("yksi", "one");
        map.add("kaksi", "two");

        System.out.println(map.get("yksi"));
        System.out.println(map.get("kaksi"));
        System.out.println(map.get("kolme"));

        map.remove("yksi");
        System.out.println(map.get("yksi"));
        System.out.println(map.size());
    }
}
