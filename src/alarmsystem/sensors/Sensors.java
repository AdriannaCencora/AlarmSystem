package alarmsystem.sensors;

import alarmsystem.ObservableMovementMonitor;
import alarmsystem.ObserverAlarmController;

public class Sensors {
    private boolean alive = false;
    private ObserverAlarmController alarmControllerObserver = new ObserverAlarmController();
    private ObservableMovementMonitor observableMovementMonitor = new ObservableMovementMonitor();

    public void on() {
        this.alive = true;
        observableMovementMonitor.register(alarmControllerObserver);
        System.out.println("Sensors on");
    }

    public void off() {
        this.alive = false;
        observableMovementMonitor.unregister(alarmControllerObserver);
        System.out.println("Sensors off");
    }

    public boolean isAlive () {
        return alive;
    }
}
