package alarmsystem;

public class Main {
    public static void main (String[] args) {
        Application application = new Application();

        boolean shouldStoreVideo = true;
        int day = 15;
        int month = 8;
        int year = 1999;

        application.armSystem(shouldStoreVideo, day, month, year);

        application.checkOldRecordings(day, month, year);
        application.requestVideoTransmission();
        application.turnOnAlarm();
        application.turnOffAlarm();

        application.disarmSystem();

    }
}
