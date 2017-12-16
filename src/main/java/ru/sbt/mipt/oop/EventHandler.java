package ru.sbt.mipt.oop;

/**
 * Created by Svetik on 13.12.2017.
 */
public interface EventHandler {
    void handle(SmartHome smartHome, SensorEvent event);
}