import java.util.*;

public class Main {
    static boolean isRaining;
    static String[] fantasyCarNames = {"Catalyst" , "Nimbus", "Vagabond", "Aeon", "Centaur",
            "Adventure", "Blaze", "Renegade", "Titan", "Empire", "Phenomenon", "QueenElisabethII"};
    static ArrayList<String> fantasyNames = new ArrayList<String>();
    static List<Motorcycle> motors = new ArrayList<Motorcycle>();
    static List<Truck> trucks = new ArrayList<Truck>();
    static Object[] vehicles = new Object[30];
    static Random rand = new Random();

    static void createCars(){
        fantasyNames.addAll(Arrays.asList(fantasyCarNames));
        Collections.shuffle(fantasyNames);
        for (int i = 0; i < 10; i++){
            int  speed;
            double chance = Math.random();
            if (chance < 0.3){
                speed = 70;
            } else {
                speed = rand.nextInt(30) + 80;
            }

            int idx = new Random().nextInt(fantasyNames.size());
            String fantasyName = (fantasyNames.get(i));

            vehicles[i] = new Car(speed, fantasyName);
        }
    }

    public static void createMotors(){
        int motorSpeed = 100;
        for (int i = 1; i <= 10; i++){
            if (isRaining){
                Random rand = new Random();
                int slower = rand.nextInt(45) + 5;
                motorSpeed -= slower;
            }
            motors.add(new Motorcycle(i, motorSpeed));
        }
    }

    public static void createTrucks() {
        int truckSpeed = 100;
        for (int i = 1; i <= 10; i++) {
            double chance = Math.random();
            if (chance < 0.05) {
                truckSpeed = 0;
            }
            int truckName = rand.nextInt(1000) + 0;
            trucks.add(new Truck(truckName, truckSpeed));
        }
    }

    static boolean decideIfIsRaining() {
        double chance = Math.random();
        if (chance < 0.3) {
            isRaining = true;
        } else {
            isRaining = false;
        }
        return isRaining;
    }

    static void simulateRace(){
        for (Object o: vehicles){
            for (int round = 0; round < 50; round++){
                boolean isRaining = decideIfIsRaining();
                if (o instanceof Car){
                    ((Car) o).setSpeedLimit(isRaining);
                    ((Car) o).moveForAnHour();
                }
            }
        }
    }

    static void printRaceResults(){
        for (Object o: vehicles){
            if (o instanceof Car){
                ((Car) o).printCarDetails();
            }
        }
    }
    public static void main (String[] args){
        decideIfIsRaining();
        createCars();
        createMotors();
        createTrucks();
        simulateRace();
        printRaceResults();
    }
}
