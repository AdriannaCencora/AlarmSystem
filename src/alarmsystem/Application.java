package alarmsystem;

import alarmsystem.camera.Camera;
import alarmsystem.sensors.ObservableSensorsTracer;
import alarmsystem.sensors.SensorsContext;
import alarmsystem.systemController.ObserverSystemController;

public class Application {
    private SensorsContext sensorsContext;
    private Camera camera;
    private ObserverSystemController observerSystemController = new ObserverSystemController();
    private ObservableSensorsTracer observableSensorsTracer = new ObservableSensorsTracer();

   public Application() {
       observerSystemController = new ObserverSystemController();
       observableSensorsTracer = new ObservableSensorsTracer();
       sensorsContext = new SensorsContext(observerSystemController, observableSensorsTracer);
       camera = new Camera();
   }

    public void armSystem(boolean shouldStoreVideo) {
        sensorsContext.on();
        camera.startRecording();
        if (shouldStoreVideo) {
            camera.storeVideo();
        }
    }

    public void disarmSystem() {
        sensorsContext.off();
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
        observableSensorsTracer.setMovementTracerState(true);
    }

    public void turnOffAlarm() {
        observableSensorsTracer.setMovementTracerState(false);
    }



}
