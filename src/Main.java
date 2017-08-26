import java.util.*;

public class Main {
    static boolean isRaining;
    static Object[] vehicles = new Object[31];
    static HashMap<String, Integer> vehicleDistances= new HashMap();
    static Random rand = new Random();

    static void createVehicles(){

        int motorIndex = 10;
        int truckIndex = 20;

        for (int i = 0; i < 10; i++){
            motorIndex++;
            truckIndex++;

            vehicles[i] = new Car();
            vehicles[motorIndex] = new Motorcycle(i+1, isRaining);
            vehicles[truckIndex] = new Truck();
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
                vehicleDistances.put(((Car) o).name, ((Car) o).distanceTraveled);
            }else if (o instanceof Motorcycle){
                ((Motorcycle) o).printMotorDetails();
                vehicleDistances.put(((Motorcycle) o).name, ((Motorcycle) o).distanceTraveled);
            }else if (o instanceof Truck){
                ((Truck) o).printTruckDetails();
                String truckName = Integer.toString(((Truck) o).name);
                vehicleDistances.put(truckName, ((Truck) o).distanceTraveled);
            }
        }
    }

    static void whoIsWinner() {
        int longestDistance = 0;
        for (Integer value : vehicleDistances.values()) {
            if (value > longestDistance) {
                longestDistance = value;
            }
        }
        for (String name : vehicleDistances.keySet()) {
            if (vehicleDistances.get(name).equals(longestDistance)) {
                System.out.println();
                System.out.println("The winner is: " + name + ", driven: " + longestDistance + "km");
            }
        }
    }

    public static void main (String[] args){
        decideIfIsRaining();
        createVehicles();
        simulateRace();
        printRaceResults();
        whoIsWinner();
    }
}
