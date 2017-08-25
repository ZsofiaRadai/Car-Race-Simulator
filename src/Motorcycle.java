import java.util.Random;

public class Motorcycle {
    int speed = 90;
    int distanceTraveled;
    int nameNumber;
    String name;

    public Motorcycle(int number, int motorSpeed){
        nameNumber = number;
        name = "Motorcycle " + number;
        speed = motorSpeed;
    }

    public void moveForAnHour(boolean isRaining){
        if (isRaining){
            Random rand = new Random();
            int slower = rand.nextInt(45) + 5;
            speed = 90 - slower;
        } else {
            speed = 90;
        }
        distanceTraveled += speed;
    }

    public void printMotorDetails(){
        System.out.println(name + " " + distanceTraveled + "km");
    }
}
