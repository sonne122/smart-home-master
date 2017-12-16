package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

/**
 * Created by Svetik on 14.12.2017.
 */
public class EventManager {
    public static boolean isLightOnEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON;
    }

    public static boolean isLightOffEvent(SensorEvent event) {
        return event.getType() == LIGHT_OFF;
    }

    public static boolean isDoorOpenEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN;
    }

    public static boolean isDoorClosedEvent(SensorEvent event) {
        return event.getType() == DOOR_CLOSED;
    }
}
