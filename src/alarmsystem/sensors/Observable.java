package alarmsystem.sensors;

import alarmsystem.systemController.Observer;

public interface Observable {

    void register(Observer o);
    void unregister(Observer o);
    void notifyObserver();
}
