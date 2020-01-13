package alarmsystem.systemController;

import alarmsystem.audioAlarm.AudioAlarm;


public class SystemController {
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

    public static void monitorSystem(MovementTracerState currentState) {
        if (currentState.equals(MovementTracerState.ABLE)) {
            AudioAlarm.soundAlarm();
            alertSecurityGuard();
            System.out.println("Alarm has been enabled. Current state is " + currentState);
        }

        if (currentState.equals(MovementTracerState.DISABLE)) {
            AudioAlarm.muteAlarm();
            System.out.println("Alarm has been disabled. Current state is " + currentState);
        }

        if (currentState.equals(MovementTracerState.IDLE)) {
            System.out.println("DO NOTHING <IDLE>");
        }
    }
    private  static void alertSecurityGuard() {
        System.out.println("Unrecognized movement has been detected!!!!!!!!!!!!!!");
    }
}