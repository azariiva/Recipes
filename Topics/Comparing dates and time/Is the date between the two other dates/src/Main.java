import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var dates = Arrays.stream(scanner.nextLine().split(" "))
                .map(LocalDate::parse)
                .toArray(LocalDate[]::new);
        Arrays.sort(dates, 1, dates.length);

        var x = dates[0];
        var m = dates[1];
        var n = dates[2];

        System.out.println(x.isAfter(m) && x.isBefore(n));
    }
}
