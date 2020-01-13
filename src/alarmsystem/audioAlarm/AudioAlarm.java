package alarmsystem.audioAlarm;

public class AudioAlarm {
    private static boolean isTurnedOn = false;
    public static void muteAlarm() {
        isTurnedOn = false;
        System.out.println("Alarm has been muted");
    }

    public static void soundAlarm() {
        isTurnedOn = true;
        System.out.println("<!!!!!!!!SOME LOAD ALARM SOUND!!!!!!!>");
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }


}
