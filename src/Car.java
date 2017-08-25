import java.util.Random;

public class Car {
    int normalSpeed;
    String name;
    int distanceTraveled;
    int speedLimit;
    static Random rand = new Random();

    public Car(int speed, String fantasyName){
        normalSpeed = speed;
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

    public void printSpeed(){
        System.out.println(normalSpeed);
    }

}
