package ru.sbt.mipt.oop;

import java.util.Scanner;

/**
 * Created by Svetik on 16.12.2017.
 */
public class AlarmSystemStateAlarm implements AlarmSystemState {

    private AlarmSystem alarmSystem;

    public AlarmSystemStateAlarm(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
        System.out.println("Before turn off the alarm system.");
    }

    @Override
    public void turnOff() {
        System.out.println("Enter the password");
        enterPassword(String.valueOf("777"));
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {

    }

    @Override
    public void enterPassword(String password) {
        if (alarmSystem.isPasswordCorrect(password)) {
            alarmSystem.setAlarmSystemState(new AlarmSystemStateOff(alarmSystem));
        }
    }

    @Override
    public AlarmSystemStateEnum getAlarmSystemState() {
        return AlarmSystemStateEnum.ALARM;
    }
}
