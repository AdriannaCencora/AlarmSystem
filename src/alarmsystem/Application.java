package alarmsystem;

import alarmsystem.camera.Camera;
import alarmsystem.sensors.Sensors;

public class Application {

    private Sensors sensors;
    private Camera camera;
    private ObserverAlarmController alarmControllerObserver;
    private ObservableMovementMonitor observableMovementMonitor;

   public Application() {

       sensors = new Sensors();
       camera = new Camera();
       alarmControllerObserver = new ObserverAlarmController();
       observableMovementMonitor = new ObservableMovementMonitor();
   }

    public void armSystem(boolean shouldStoreVideo) {
        sensors.on();
        observableMovementMonitor.register(alarmControllerObserver);

        camera.startRecording();
        if (shouldStoreVideo == true) {
            camera.storeVideo();
        }
    }

    public void disarmSystem() {
        sensors.off();
        camera.stopRecording();
    }

    public void checkOldRecordings() {
       if (camera.searchVideo(11, 2, 2009))
           System.out.println("Video exists.");
       else
           System.out.println("Video doesn't exists");

    }

    public void requestVideoTransmission() {
        camera.transmit();
        observableMovementMonitor.setMovementDetectedStatus(true);
    }

    public void turnOnAlarm() {
        alarmControllerObserver.soundAlarm();
        alarmControllerObserver.alertSecurityGuard();
    }

    public void turnOffAlarm() {
        alarmControllerObserver.muteAlarm();
    }



}
