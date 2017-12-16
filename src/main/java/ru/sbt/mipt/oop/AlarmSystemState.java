package ru.sbt.mipt.oop;

/**
 * Created by Svetik on 16.12.2017.
 */
public interface AlarmSystemState {

    void turnOn();

    void turnOff();

    void onSensorEvent(SensorEvent sensorEvent);

    void enterPassword(String password);

    AlarmSystemStateEnum getAlarmSystemState();
}
