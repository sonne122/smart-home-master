package ru.sbt.mipt.oop;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Svetik on 16.12.2017.
 */
public class AlarmSystemTest {
    @Test
    public void testAlarmSystemStateOff() {
        AlarmSystem alarmSystem = new AlarmSystem("777");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getAlarmSystemState());

        alarmSystem = new AlarmSystem("777");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());

        alarmSystem.onSensorEvent(new SensorEvent(SensorEventType.DOOR_OPEN, "1"));
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());

        alarmSystem.enterPassword("777");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());
    }

    @Test
    public void testAlarmSystemStateOn() {
        AlarmSystem alarmSystem = new AlarmSystem("777");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getAlarmSystemState());

        alarmSystem.onSensorEvent(new SensorEvent(SensorEventType.DOOR_OPEN, "1"));
        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getAlarmSystemState());

        alarmSystem = new AlarmSystem("777");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getAlarmSystemState());

        alarmSystem.enterPassword("0000");
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getAlarmSystemState());

        alarmSystem.enterPassword("0030");
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getAlarmSystemState());
    }

    @Test
    public void testAlarmSystemStateAlarm() {
        AlarmSystem alarmSystem = new AlarmSystem("777");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getAlarmSystemState());

        alarmSystem.onSensorEvent(new SensorEvent(SensorEventType.DOOR_OPEN, "1"));
        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getAlarmSystemState());

        alarmSystem.onSensorEvent(new SensorEvent(SensorEventType.DOOR_OPEN, "1"));
        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getAlarmSystemState());

        alarmSystem.onSensorEvent(new SensorEvent(SensorEventType.DOOR_OPEN, "1"));
        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getAlarmSystemState());

        alarmSystem.enterPassword("777");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());
    }

    @Test
    public void testAlarmSystemStateWaitForPassword() {
        AlarmSystem alarmSystem = new AlarmSystem("777");
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getAlarmSystemState());

        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getAlarmSystemState());

        alarmSystem.onSensorEvent(new SensorEvent(SensorEventType.DOOR_OPEN, "1"));
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getAlarmSystemState());

        alarmSystem.enterPassword("777");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getAlarmSystemState());
    }
}