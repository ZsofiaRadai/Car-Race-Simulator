import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Car {
    static String[] fantasyCarNames = {"Catalyst" , "Nimbus", "Vagabond", "Aeon", "Centaur",
            "Adventure", "Blaze", "Renegade", "Titan", "Empire", "Phenomenon", "QueenElizabethII"};
    static ArrayList<String> fantasyNames = new ArrayList<String>();
    int normalSpeed;
    String name;
    int distanceTraveled;
    int speedLimit;
    static Random rand = new Random();

    public Car(){
        fantasyNames.addAll(Arrays.asList(fantasyCarNames));
        double chance = Math.random();
        if (chance < 0.3){
            normalSpeed = 70;
        } else {
            normalSpeed = rand.nextInt(30) + 80;
        }
        int index1 = rand.nextInt(fantasyNames.size());
        String fantasyName1= fantasyNames.get(index1);
        int index2 = rand.nextInt(fantasyNames.size());
        String fantasyName2= fantasyNames.get(index2);
        String fantasyName = fantasyName1 + " " + fantasyName2;
        name = fantasyName;
    }

    public void setSpeedLimit(boolean isRaining){
        if (isRaining){
            normalSpeed = 70;
        } else {
            normalSpeed = rand.nextInt(30) + 80;
        }
    }

    public void moveForAnHour(){
        distanceTraveled += normalSpeed;
    }

    public void printCarDetails(){
        System.out.println(name + " " + distanceTraveled + "km");
    }

}
