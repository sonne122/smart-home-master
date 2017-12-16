package ru.sbt.mipt.oop;

/**
 * Created by Svetik on 16.12.2017.
 */
public class AlarmSystemStateOn implements AlarmSystemState {

    private AlarmSystem alarmSystem;

    public AlarmSystemStateOn(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
        System.out.println("The system is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Enter the password");
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
        alarmSystem.enterPassword(String.valueOf("777"));
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
        }
    }

    @Override
    public void enterPassword(String password) {

    }

    @Override
    public AlarmSystemStateEnum getAlarmSystemState() {
        return AlarmSystemStateEnum.ON;
    }

}
