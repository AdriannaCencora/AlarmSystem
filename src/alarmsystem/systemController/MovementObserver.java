package alarmsystem.systemController;

public class MovementObserver implements Observer {
    private MovementTracerState movementObserverState = MovementTracerState.IDLE;
    private ObservableMovementTracer observableMovementTracer;

    public MovementObserver(ObservableMovementTracer observableMovementTracer) {
        this.observableMovementTracer = observableMovementTracer;
    }

    public void update() {
        movementObserverState = observableMovementTracer.getMovementTracerState();
    }

    public MovementTracerState getMovementObserverState() {
        return movementObserverState;
    }
}
