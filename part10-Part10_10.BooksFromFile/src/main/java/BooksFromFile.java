
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksFromFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File: ");
        String file = scanner.nextLine();

        readBooks(file).stream().forEach(book -> System.out.println(book.getName()));
    }

    public static List<Book> readBooks(String file) {
        List<Book> books = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(file))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                books.add(new Book(parts[0],
                        Integer.valueOf(parts[1]),
                        Integer.valueOf(parts[2]),
                        parts[3]));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return books;
    }
}
