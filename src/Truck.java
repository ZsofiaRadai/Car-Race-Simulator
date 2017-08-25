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
        double chance = Math.random();
        if (chance < 0.05) {
            speed = 0;
        } else {
            speed = 100;
        }
        distanceTraveled += speed;
    }

    public void printTruckDetails(){
        System.out.println(name + " " + distanceTraveled);
    }

}
