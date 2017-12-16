package ru.sbt.mipt.oop;

/**
 * Created by Svetik on 16.12.2017.
 */
public class AlarmSystemStateOff implements AlarmSystemState {

    private AlarmSystem alarmSystem;

    public AlarmSystemStateOff(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateOn(alarmSystem));
    }

    @Override
    public void turnOff() {
        System.out.println("The system is turned off!");
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {

    }

    @Override
    public void enterPassword(String password) {

    }

    @Override
    public AlarmSystemStateEnum getAlarmSystemState() {
        return AlarmSystemStateEnum.OFF;
    }
}
