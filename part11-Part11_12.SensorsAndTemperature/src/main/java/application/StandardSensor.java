package application;

public class StandardSensor implements Sensor {

    private int value;

    public StandardSensor(int value) {
        this.value = value;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
        // a standard sensor is always on
    }

    @Override
    public void setOff() {
        // a standard sensor can not be turned off
    }

    @Override
    public int read() {
        return this.value;
    }
}
