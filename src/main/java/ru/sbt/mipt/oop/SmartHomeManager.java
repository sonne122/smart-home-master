package ru.sbt.mipt.oop;

/**
 * Created by Svetik on 13.12.2017.
 */
public class SmartHomeManager {
    public static void turnOnLight(Light light) {
        light.setOn(true);
    }

    public static void turnOffLight(Light light) {
        light.setOn(false);
    }

    public static void openDoor(Door door) {
        door.setOpen(true);
    }

    public static void closeDoor(Door door) {
        door.setOpen(false);
    }
}
