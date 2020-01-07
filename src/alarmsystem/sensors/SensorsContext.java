package alarmsystem.sensors;

import alarmsystem.systemController.ObserverSystemController;

public class SensorsContext {
    private Boolean alive = false;

    public SensorsContext(ObserverSystemController observerSystemController, ObservableSensorsTracer observableSensorsTracer) {
        this.observerSystemController = observerSystemController;
        this.observableSensorsTracer = observableSensorsTracer;
    }

    private ObserverSystemController observerSystemController;
    private ObservableSensorsTracer observableSensorsTracer;

    public void on() {
        this.alive = true;
        observableSensorsTracer.register(observerSystemController);
        System.out.println("Sensors on");
    }

    public void off() {
        this.alive = false;
        observableSensorsTracer.unregister(observerSystemController);
        System.out.println("Sensors off");
    }

    public void changeMovementDetectorState(Boolean newState) {
        observableSensorsTracer.setMovementTracerState(newState);
    }
}
