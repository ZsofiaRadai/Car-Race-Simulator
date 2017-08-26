import java.util.Random;

public class Truck {
    int speed = 90;
    int name;
    int distanceTraveled;
    //breakdownTurnsLeft??
    static Random rand = new Random();

    public Truck(){
        this.name = name;
        double chance = Math.random();
        if (chance < 0.05) {
            speed = 0;
        } else {
            speed = 90;
        }
        int truckName = rand.nextInt(1000) + 0;
        name = truckName;
    }

    public void moveForAnHour(){
        double chance = Math.random();
        if (chance < 0.05) {
            speed = 0;
        } else {
            speed = 90;
        }
        distanceTraveled += speed;
    }

    public void printTruckDetails(){
        System.out.println(name + " " + distanceTraveled + "km");
    }

}
