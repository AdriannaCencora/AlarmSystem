package alarmsystem.camera;

public class Recording {
    private int day;
    private int month;
    private int year;

    public Recording(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Recording)) {
            return false;
        }

        Recording o = (Recording) other;

        return ((year == o.year) && (month == o.month) && (day == o.day));
    }

    public String getRecordingDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(day);
        sb.append('/');
        sb.append(month);
        sb.append('/');
        sb.append(year);

        return sb.toString();
    }
}
