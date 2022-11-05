import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ConcreteComponent - Geek.
 **/
class Geek {

    private String type;
    private List<String> languages;
    private int experience;

    public Geek(String type, List<String> languages, int experience) {
        this.type = type;
        this.languages = languages;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Type : " + type + "\n" +
                "Languages : " + languages + "\n" +
                "Experience : " + experience + " years";
    }

}

/**
 * Builder interface describe step of object creation.
 **/
interface Builder {
    void setType(String type);

    void setLanguages(List<String> languages);

    void setExperience(int experience);
}

/**
 * Concrete Builder build Geek component.
 **/
class GeekBuilder implements Builder {

    private String type;
    private List<String> languages;
    private int experience;

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Geek getResult() {
        return new Geek(type, languages, experience);
    }
}

/**
 * Builder Director.
 */
class GeekDirector {
    public void buildAdmin(Builder builder) {
        builder.setType("Admin");
        builder.setLanguages(List.of("Perl", "PowerShell"));
        builder.setExperience(10);
    }

    public void buildBackend(Builder builder) {
        builder.setType("Backend");
        builder.setLanguages(List.of("Python", "PHP"));
        builder.setExperience(5);
    }

    public void buildRockstar(Builder builder) {
        builder.setType("Rockstar");
        builder.setLanguages(List.of("Java", "Kotlin", "Scala", "Angular"));
        builder.setExperience(20);
    }
}

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String geekName = scanner.nextLine();
        final String geekType = scanner.nextLine();
        scanner.close();
        GeekDirector director = new GeekDirector();
        GeekBuilder builder = new GeekBuilder();
        Geek geek = null;
        if ("Rockstar".equals(geekType)) {
            director.buildRockstar(builder);
            geek = builder.getResult();
        } else if ("Backend".equals(geekType)) {
            director.buildBackend(builder);
            geek = builder.getResult();
        } else if ("Admin".equals(geekType)) {
            director.buildAdmin(builder);
            geek = builder.getResult();
        } else {
            System.out.println("Error");
            return;
        }
        System.out.println("Geek " + geekName + " created.");
        System.out.println(geek);

    }
}