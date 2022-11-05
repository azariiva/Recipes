import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    private static final LocalTime GET_OUT_TIME = LocalTime.parse("19:30");
    private static final Integer TRAVEL_TIME_IN_MINUTES = 30;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.nextLine().trim());
        Stream.generate(() -> {
            var storeLine = scanner.nextLine().trim().split(" ");
            return new AbstractMap.SimpleImmutableEntry<>(storeLine[0], LocalTime.parse(storeLine[1]));
        }).limit(n).filter(e ->
                e.getValue()
                        .minusMinutes(TRAVEL_TIME_IN_MINUTES)
                        .isAfter(GET_OUT_TIME)).map(Map.Entry::getKey).forEach(System.out::println);
    }
}
