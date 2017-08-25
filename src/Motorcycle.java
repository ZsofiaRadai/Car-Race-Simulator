import java.util.Random;

public class Motorcycle {
    int speed = 100;
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
            speed = 100 - slower;
        } else {
            speed = 100;
        }
        distanceTraveled += speed;
    }

    public void printMotorDetails(){
        System.out.println(name + " " + distanceTraveled + "km");
    }
}
