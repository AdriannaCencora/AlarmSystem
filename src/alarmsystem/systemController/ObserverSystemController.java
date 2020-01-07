package alarmsystem.systemController;

import alarmsystem.systemController.Observer;

public class ObserverSystemController implements Observer {
    private Boolean alarmOn = false;

    public void alertSecurityGuard() {
        System.out.println("Unrecognized movement has been detected!!!!!!!!!!!!!!");
    }

    public void update(Boolean alarmStatus) {
        alarmOn = alarmStatus;
    }
/*
    public void monitorMovement () {
        while (system is running) {
            if ObserverSystemController.alarmOn == true
                    alert admin and turn on alarm
        }
    }

 */
}
