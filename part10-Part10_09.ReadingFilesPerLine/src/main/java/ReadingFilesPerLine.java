
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File: ");
        String file = scanner.nextLine();

        read(file).stream().forEach(line -> System.out.println(line));
    }

    public static List<String> read(String file) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.lines(Paths.get(file))
                    .map(line -> line.trim())
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lines;
    }
}
