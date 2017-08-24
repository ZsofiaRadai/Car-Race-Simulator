public class Car {
    int normalSpeed;
    String name;
    int distanceTraveled;
    int speedLimit;

    public Car(int speed, String fantasyName){
        normalSpeed = speed;
        name = fantasyName;
    }

    public void setSpeedLimit(int limit){
        speedLimit = limit;
    }

    public void moveForAnHour(){
        distanceTraveled++;
    }

    public void printCarDetails(){
        System.out.println(name);
        System.out.println(normalSpeed);
        System.out.println(distanceTraveled);
    }

}
