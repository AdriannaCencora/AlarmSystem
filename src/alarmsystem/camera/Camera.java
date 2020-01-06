package alarmsystem.camera;

import java.util.ArrayList;

public class Camera {
    private boolean on = false;
    private Recording recording;
    private ArrayList<Recording> recordings = new ArrayList<>();

    public void startRecording() {
        this.on = true;
        recording = new Recording(11, 2, 2009);
        System.out.println(recording.getRecordingDetails());
    }

    public void stopRecording() {
        this.on = false;
    }

    public void storeVideo() {
        recordings.add(recording);
    }

    public boolean searchVideo(int day, int month, int year) {
        Recording wantedRecording = new Recording(day, month, year);
        System.out.println(recording.getRecordingDetails());

        return recordings.contains(wantedRecording);

    }

    public void transmit() {
        System.out.println("Transmitting video from: " + recording.getRecordingDetails());
    }
}
