package alarmsystem.camera;

import java.util.ArrayList;

public class Camera {

    private boolean alive;
    private boolean transmitting;
    private boolean storingVideo;
    private Recording recording;
    private ArrayList<Recording> recordings;

    public Camera() {
        alive = false;
        transmitting = false;
        storingVideo = false;
        recordings =  new ArrayList<>();
    }

    public void startRecording(int day, int month, int year) {
        alive = true;
        recording = new Recording(day, month, year);
        System.out.println(recording.getRecordingDetails());
    }

    public void stopRecording() {
        this.alive = false;
    }

    public void storeVideo() {
        storingVideo = true;
        recordings.add(recording);
    }

    public boolean searchVideo(int day, int month, int year) {
        Recording wantedRecording = new Recording(day, month, year);
        if (recordings.contains(wantedRecording))
            return true;
        else
            return false;
    }

    public void transmit() {
        transmitting = true;
        System.out.println("Transmitting video from: " + recording.getRecordingDetails());
    }
    public boolean isAlive() {
        return alive;
    }

    public boolean isTransmitting() {
        return transmitting;
    }

    public boolean isStoringVideo() {
        return storingVideo;
    }

    public ArrayList<Recording> getRecordings() {
        return recordings;
    }

}

