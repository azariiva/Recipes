import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    private static final int UPPER_LIMIT = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var sum = 0;
        for (Integer num : (Iterable<Integer>) Stream.generate(scanner::nextLine)
                .map(Integer::parseInt).takeWhile(i -> i != 0)::iterator) {
            if (sum >= UPPER_LIMIT) break;
            sum += num;
        }
        if (sum >= UPPER_LIMIT) sum -= UPPER_LIMIT;
        System.out.println(sum);
    }
}
