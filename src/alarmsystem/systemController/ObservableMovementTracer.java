package alarmsystem.systemController;

import java.util.ArrayList;

public class ObservableMovementTracer implements Observable {

    private ArrayList<Observer> movementSubscribers;
    private MovementTracerState movementTracerState;

    public ObservableMovementTracer() {
        movementTracerState = MovementTracerState.IDLE;
        movementSubscribers = new ArrayList<>();
    }

    public void register(Observer o) {
        movementSubscribers.add(o);
    }

    public void unregister(Observer o) {
        movementSubscribers.remove(o);
    }

    public void notifyObserver() {
        for (Observer observer : movementSubscribers) {
            observer.update();
        }
    }

    public void setMovementTracerState(MovementTracerState newMovementTracerState) {
        this.movementTracerState = newMovementTracerState;
        notifyObserver();
    }

    public MovementTracerState getMovementTracerState() {
        return movementTracerState;
    }
}
