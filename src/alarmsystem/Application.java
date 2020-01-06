package alarmsystem;

import alarmsystem.camera.Camera;
import alarmsystem.sensors.Sensors;

public class Application {

    private Sensors sensors;
    private Camera camera;

   public Application() {
       sensors = new Sensors();
       camera = new Camera();
   }

    public void armSystem(boolean shouldStoreVideo) {
        sensors.on();
        camera.startRecording();
        if (shouldStoreVideo) {
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
    }

    public void turnOnAlarm() {
    }

    public void turnOffAlarm() {
    }



}
