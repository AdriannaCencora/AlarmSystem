package alarmsystem;

public class ObserverAlarmController implements Observer {
    private boolean alarmOn = false;

    public void muteAlarm() {
        alarmOn = false;
        System.out.println("Alarm has been muted");
    }

    public void soundAlarm() {
        alarmOn = true;
        System.out.println("<!!!!!!!!SOME LOAD ALARM SOUND!!!!!!!>");
    }

    public void alertSecurityGuard() {
        System.out.println("Unrecognized movement has been detected!!!!!!!!!!!!!!");
    }

    public void update(Object o) {
    }
}
