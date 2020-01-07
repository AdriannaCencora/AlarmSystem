package alarmsystem;

public class Main {
    public static void main (String[] args) {
        Application application = new Application();
        boolean shouldStoreVideo = true;

        application.armSystem(shouldStoreVideo);

        application.checkOldRecordings();
        application.requestVideoTransmission();
        application.turnOnAlarm();
        application.turnOffAlarm();

        application.disarmSystem();

    }
}
