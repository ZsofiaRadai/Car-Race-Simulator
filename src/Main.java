import java.util.*;

public class Main {
    static boolean isRaining;
    static String[] fantasyCarNames = {"Catalyst" , "Nimbus", "Vagabond", "Aeon", "Centaur",
            "Adventure", "Blaze", "Renegade", "Titan", "Empire", "Phenomenon", "QueenElizabethII"};
    static ArrayList<String> fantasyNames = new ArrayList<String>();
    static Object[] vehicles = new Object[31];
    static Random rand = new Random();

    static void createVehicles(){
        fantasyNames.addAll(Arrays.asList(fantasyCarNames));
        Collections.shuffle(fantasyNames);

        int carSpeed;
        int motorSpeed = 100;
        int truckSpeed = 100;
        int motorIndex = 10;
        int truckIndex = 20;

        for (int i = 0; i < 10; i++){
            motorIndex++;
            truckIndex++;
            double chance = Math.random();
            if (chance < 0.3){
                carSpeed = 70;
            } else {
                carSpeed = rand.nextInt(30) + 80;
            }
            if (isRaining){
                Random rand = new Random();
                int slower = rand.nextInt(45) + 5;
                motorSpeed -= slower;
            }
            if (chance < 0.05) {
                truckSpeed = 0;
            }

            int truckName = rand.nextInt(1000) + 0;
            String fantasyName = (fantasyNames.get(i));

            vehicles[i] = new Car(carSpeed, fantasyName);
            vehicles[motorIndex] = new Motorcycle(i+1, motorSpeed);
            vehicles[truckIndex] = new Truck(truckName, truckSpeed);
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
                }else if (o instanceof Motorcycle){
                    ((Motorcycle) o).moveForAnHour(isRaining);
                }else if (o instanceof Truck){
                    ((Truck) o).moveForAnHour();
                }
            }
        }
    }

    static void printRaceResults() {
        for (Object o : vehicles) {
            if (o instanceof Car) {
                ((Car) o).printCarDetails();
            }else if (o instanceof Motorcycle){
                ((Motorcycle) o).printMotorDetails();
            }else if (o instanceof Truck){
                ((Truck) o).printTruckDetails();
            }
        }
    }
    public static void main (String[] args){
        decideIfIsRaining();
        createVehicles();
        simulateRace();
        printRaceResults();
    }
}
