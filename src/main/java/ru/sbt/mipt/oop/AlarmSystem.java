package ru.sbt.mipt.oop;

/**
 * Created by Svetik on 16.12.2017.
 */
public class AlarmSystem implements AlarmSystemState {

    private AlarmSystemState alarmSystemState;
    private String password;

    public AlarmSystem() {
        this.alarmSystemState = new AlarmSystemStateOn(this);
    }

    public AlarmSystem(String password) {
        this.password = password;
        alarmSystemState = new AlarmSystemStateOff(this);
    }

    @Override
    public void turnOn() {
        alarmSystemState.turnOn();
    }

    @Override
    public void turnOff() {
        alarmSystemState.turnOff();
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        alarmSystemState.onSensorEvent(sensorEvent);
    }

    @Override
    public void enterPassword(String password) {
        alarmSystemState.enterPassword(password);
    }

    @Override
    public AlarmSystemStateEnum getAlarmSystemState() {
        return alarmSystemState.getAlarmSystemState();
    }

    public void setAlarmSystemState(AlarmSystemState state) {
        alarmSystemState = state;
    }

    public boolean isPasswordCorrect(String password) {
        if (this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
