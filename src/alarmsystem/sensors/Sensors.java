package alarmsystem.sensors;

public class Sensors {
    private Boolean alive = false;

    public void on() {
        this.alive = true;
        System.out.println("Sensors on");
    }

    public void off() {
        this.alive = false;
        System.out.println("Sensors off");
    }

    public Boolean isAlive() {
        return alive;
    }

}
