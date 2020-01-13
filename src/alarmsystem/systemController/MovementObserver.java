package alarmsystem.systemController;

public class MovementObserver implements Observer {
    private MovementTracerState movementObserverState;
    private ObservableMovementTracer observableMovementTracer;

    public MovementObserver(ObservableMovementTracer observableMovementTracer) {
        movementObserverState = MovementTracerState.IDLE;
        this.observableMovementTracer = observableMovementTracer;
    }

    public void update(MovementTracerState movementTracerState) {
        movementObserverState = movementTracerState;
        SystemController.monitorSystem(movementObserverState);
    }

    public MovementTracerState getMovementObserverState() {
        return movementObserverState;
    }
}
