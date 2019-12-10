package alarmsystem.sensors;

public class Sensors {
    private boolean alive = false;

    public void on() {
        this.alive = true;
        System.out.println("Sensors on");
    }

    public void off() {
        this.alive = false;
        System.out.println("Sensors off");
    }

    public boolean isAlive () {
        return alive;
    }
}
