import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var inputArgs = scanner.nextLine().split(" ");
        var date = LocalDate.parse(inputArgs[0]);
        var numOfDays = Integer.parseInt(inputArgs[1]);
        System.out.println(date.plusDays(numOfDays).getYear() > date.getYear());
    }
}