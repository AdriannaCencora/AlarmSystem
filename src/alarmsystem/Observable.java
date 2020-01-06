package alarmsystem;

public interface Observable {

    void register(Observer o);
    void unregister(Observer o);
    void notifyObserver();
}
