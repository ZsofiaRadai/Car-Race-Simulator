import java.util.Random;

public class Motorcycle {
    int speed = 90;
    int distanceTraveled;
    int nameNumber;
    String name;

    public Motorcycle(int number, boolean isRaining){
        nameNumber = number;
        name = "Motorcycle " + number;
        if (isRaining){
            Random rand = new Random();
            int slower = rand.nextInt(45) + 5;
            speed -= slower;
        }
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
