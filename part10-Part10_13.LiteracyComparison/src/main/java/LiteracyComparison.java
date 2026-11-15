
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LiteracyComparison {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.trim())
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        List<String> results = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");

            String gender = parts[parts.length - 4].trim().replace(" (%)", "");
            String country = parts[parts.length - 3].trim();
            String year = parts[parts.length - 2].trim();
            String rate = parts[parts.length - 1].trim();

            results.add(country + " (" + year + "), " + gender + ", " + rate);
        }

        Collections.sort(results, (first, second) -> {
            double firstRate = Double.valueOf(first.substring(first.lastIndexOf(",") + 1).trim());
            double secondRate = Double.valueOf(second.substring(second.lastIndexOf(",") + 1).trim());

            if (firstRate < secondRate) {
                return -1;
            } else if (firstRate > secondRate) {
                return 1;
            }

            return 0;
        });

        results.stream().forEach(result -> System.out.println(result));
    }
}
