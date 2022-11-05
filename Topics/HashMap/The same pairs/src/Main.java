import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        var intersection = map1.entrySet();
        intersection.retainAll(map2.entrySet());
        System.out.println(intersection.size());
    }
}