package alarmsystem.systemController;

import alarmsystem.audioAlarm.AudioAlarm;

public class SystemController {
    private AudioAlarm audioAlarm = new AudioAlarm();
    private MovementObserver movementObserver;
    private ObservableMovementTracer observableMovementTracer;

    public SystemController(MovementObserver movementObserver, ObservableMovementTracer observableMovementTracer) {
        this.movementObserver = movementObserver;
        this.observableMovementTracer = observableMovementTracer;
    }

    public void start() {
        observableMovementTracer.register(movementObserver);
    }

    public void stop() {
        observableMovementTracer.unregister(movementObserver);
    }

    public void monitorSystem() {
        if (movementObserver.getMovementObserverState().equals(MovementTracerState.ABLE)) {
            audioAlarm.soundAlarm();
            alertSecurityGuard();
            System.out.println("Alarm has been enabled. Current state is " + movementObserver.getMovementObserverState());
        }

        if (movementObserver.getMovementObserverState().equals(MovementTracerState.DISABLE)) {
            audioAlarm.muteAlarm();
            observableMovementTracer.setMovementTracerState(MovementTracerState.IDLE);
            System.out.println("Alarm has been disabled. Current state is " + movementObserver.getMovementObserverState());
        }

        if (movementObserver.getMovementObserverState().equals(MovementTracerState.IDLE)) {
            System.out.println("DO NOTHING <IDLE>");
        }
    }

    private void alertSecurityGuard() {
        System.out.println("Unrecognized movement has been detected!!!!!!!!!!!!!!");
    }
}