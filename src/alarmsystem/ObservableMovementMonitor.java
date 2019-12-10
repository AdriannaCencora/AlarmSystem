package alarmsystem;

import java.util.ArrayList;

public class ObservableMovementMonitor implements Observable {

    private ArrayList<Observer> observers;
    private boolean movementDetected;

    public ObservableMovementMonitor() {
        movementDetected = false;
        observers = new ArrayList<Observer>();
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void unregister(Observer o) {
        int observerIndex = observers.indexOf(o);
        observers.remove(observerIndex);
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(movementDetected);
        }
    }

    public void setMovementDetectedStatus (boolean movementDetected) {
        this.movementDetected = movementDetected;
        notifyObserver();
    }
}
