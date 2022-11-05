import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.nextLine().trim());
        var latestOne = Stream.generate(() -> LocalDateTime.parse(scanner.nextLine().trim()))
                .limit(n)
                .reduce((a, b) -> {
                    if (a.isAfter(b)) {
                        return a;
                    }
                    return b;
                }).get();
        System.out.println(latestOne);
    }
}