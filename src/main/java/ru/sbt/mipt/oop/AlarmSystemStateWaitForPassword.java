package ru.sbt.mipt.oop;

/**
 * Created by Svetik on 16.12.2017.
 */
public class AlarmSystemStateWaitForPassword implements AlarmSystemState {

    private AlarmSystem alarmSystem;

    public AlarmSystemStateWaitForPassword(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {

    }

    @Override
    public void enterPassword(String password) {
        int i = 0;
        while (true) {
            if (alarmSystem.isPasswordCorrect(password)) {
                alarmSystem.setAlarmSystemState(new AlarmSystemStateOff(alarmSystem));
                break;
            } else {
                i ++;
                if (i == 3) {
                    alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
                    break;
                }
            }
        }
    }

    @Override
    public AlarmSystemStateEnum getAlarmSystemState() {
        return AlarmSystemStateEnum.WAIT_FOR_PASSWORD;
    }
}
