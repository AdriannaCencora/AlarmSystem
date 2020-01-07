package alarmsystem.sensors;

import alarmsystem.systemController.Observer;

import java.util.ArrayList;

public class ObservableSensorsTracer implements Observable {

    private ArrayList<Observer> movementSubscribers;
    private Boolean movementTracerState;

    public ObservableSensorsTracer() {
        movementTracerState = false;
        movementSubscribers = new ArrayList<>();
    }

    public void register(Observer o) {
        movementSubscribers.add(o);
    }

    public void unregister(Observer o) {
        int observerIndex = movementSubscribers.indexOf(o);
        movementSubscribers.remove(observerIndex);
    }

    public void notifyObserver() {
        for (Observer observer : movementSubscribers) {
            observer.update(movementTracerState);
        }
    }

    public void setMovementTracerState(Boolean newMovementTracerState) {
        this.movementTracerState = newMovementTracerState;
        notifyObserver();
    }

    public boolean getMovementTracerState() {
        return movementTracerState;
    }
}
