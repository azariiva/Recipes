import java.util.*;
import java.util.stream.Collectors;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        return Arrays.stream(strings)
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum, TreeMap::new));
    }

    public static void printMap(Map<String, Integer> map) {
        map.forEach((k, v) -> System.out.printf("%s : %d\n", k, v));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}