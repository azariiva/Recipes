import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var firstWordCharFrequencies = scanner.nextLine()
                .trim().toLowerCase().chars()
                .mapToObj(code -> (char) code)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum, HashMap::new));
        var charFrequenciesDifference = scanner.nextLine()
                .trim().toLowerCase().chars()
                .mapToObj(code -> (char) code)
                .collect(Collectors.toMap(c -> c, c -> -1, Integer::sum, () -> firstWordCharFrequencies))
                .values().stream()
                .reduce((a, b) -> Math.abs(a) + Math.abs(b))
                .orElseGet(() -> 0);

        System.out.println(charFrequenciesDifference == 0 ? "yes" : "no");
    }
}