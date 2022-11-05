import java.util.Scanner;

class Robot {

    private String cpu;
    private int legs;
    private int hands;
    private int eyes;

    Robot(String cpu, int legs, int hands, int eyes) {
        this.cpu = cpu;
        this.legs = legs;
        this.hands = hands;
        this.eyes = eyes;
    }

    public static class RobotBuilder {

        private String cpu;
        private int legs;
        private int hands;
        private int eyes;

        RobotBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        RobotBuilder setLegs(int legs) {
            this.legs = legs;
            return this;
        }

        RobotBuilder setHands(int hands) {
            this.hands = hands;
            return this;
        }

        RobotBuilder setEyes(int eyes) {
            this.eyes = eyes;
            return this;
        }

        Robot build() {
            return new Robot(cpu, legs, hands, eyes);
        }
    }

    @Override
    public String toString() {
        return "CPU : " + cpu + "\n" +
                "Legs : " + legs + "\n" +
                "Hands : " + hands + "\n" +
                "Eyes : " + eyes + "\n";
    }
}

class TestDrive {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Robot.RobotBuilder robotBuilder = new Robot.RobotBuilder();
        robotBuilder.setCpu("Intel Core i5");
        int legs = scanner.nextInt();
        robotBuilder.setLegs(legs);
        int hands = scanner.nextInt();
        robotBuilder.setHands(hands);
        int eyes = scanner.nextInt();
        robotBuilder.setEyes(eyes);
        Robot robot = robotBuilder.build();

        System.out.println(robot);
        scanner.close();
    }
}