package alarmsystem;

import alarmsystem.camera.Camera;
import alarmsystem.systemController.MovementTracerState;
import alarmsystem.systemController.ObservableMovementTracer;
import alarmsystem.sensors.Sensors;
import alarmsystem.systemController.MovementObserver;
import alarmsystem.systemController.SystemController;

public class Application {
    private Sensors sensors;
    private Camera camera;
    private ObservableMovementTracer observableMovementTracer;
    private MovementObserver movementObserver;
    private SystemController systemController;

    public Application() {
        observableMovementTracer = new ObservableMovementTracer();
        movementObserver = new MovementObserver(observableMovementTracer);
        sensors = new Sensors();
        camera = new Camera();
        systemController = new SystemController(movementObserver, observableMovementTracer);

    }

    public void armSystem(boolean shouldStoreVideo, int day, int month, int year) {
        sensors.on();
        camera.startRecording(day, month, year);
        if (shouldStoreVideo) {
            camera.storeVideo();
        }
        systemController.start();
    }

    public void disarmSystem() {
        sensors.off();
        camera.stopRecording();
        systemController.stop();

    }

    public void checkOldRecordings(int day, int month, int year) {
        if (camera.searchVideo(day, month, year))
            System.out.println("Video exists.");
        else
            System.out.println("Video doesn't exists");

    }

    public void requestVideoTransmission() {
        camera.transmit();
    }

    public void turnOnAlarm() {
        observableMovementTracer.setMovementTracerState(MovementTracerState.ABLE);
    }

    public void turnOffAlarm() {
        observableMovementTracer.setMovementTracerState(MovementTracerState.DISABLE);
    }


}
