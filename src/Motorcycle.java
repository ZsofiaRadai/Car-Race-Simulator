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

    public void moveForAnHour(){
        distanceTraveled++;
    }

    public void printMotorDetails(){
        System.out.println(nameNumber);
        System.out.println(name);
        System.out.println(speed);
        System.out.println(distanceTraveled);
    }
}
