public class Truck {
    int speed = 100;
    int name;
    int distanceTraveled;
    //breakdownTurnsLeft??

    public Truck(int name, int truckSpeed){
        this.name = name;
        speed = truckSpeed;
    }

    public void moveForAnHour(){
        distanceTraveled++;
    }

    public void printTruckDetails(){
        System.out.println(name);
        System.out.println(speed);
        //System.out.println(distanceTraveled);
    }

}
