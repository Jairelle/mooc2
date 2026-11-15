
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pipe<String> pipe = new Pipe<>();
        System.out.println(pipe.isInPipe());

        pipe.putIntoPipe("First");
        pipe.putIntoPipe("Second");

        System.out.println(pipe.takeFromPipe());
        System.out.println(pipe.takeFromPipe());
        System.out.println(pipe.isInPipe());
    }
}
