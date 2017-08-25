public class Car {
    int normalSpeed;
    String name;
    int distanceTraveled;
    int speedLimit;

    public Car(int speed, String fantasyName){
        normalSpeed = speed;
        name = fantasyName;
    }

    public void setSpeedLimit(boolean isRaining){
        if (isRaining){
            normalSpeed = 70;
        }
    }

    public void moveForAnHour(){

        distanceTraveled += normalSpeed;
    }

    public void printCarDetails(){
        System.out.println(name + " " + distanceTraveled);
    }

}
