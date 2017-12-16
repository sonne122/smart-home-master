package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Svetik on 16.12.2017.
 */
public class ScenarioRunnerTest {
    Door door1 = new Door(false,"1");
    Door testingDoor = new Door(true, "2");
    Light light1 = new Light("1", true);
    Light light2 = new Light("2", false);
    Room room1 = new Room(Arrays.asList(light1),Arrays.asList(door1),"bedroom");
    Room room2 = new Room(Arrays.asList(light2),Arrays.asList(testingDoor),"hall");
    SmartHome smartHome = new SmartHome(Arrays.asList(room1,room2));
    ScenarioRunner handler = new ScenarioRunner();

    @Test
    public void testDoorsClosed(){
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, testingDoor.getId());
        handler.handle(smartHome,event);
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                assertFalse(light.isOn());
            }
        }
    }
    @Test
    public void testDoorsOpened(){
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, testingDoor.getId());
        handler.handle(smartHome,event);
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.equals(light1)) {
                    assertTrue(light.isOn());
                } else if (light.equals(light2)){
                    assertFalse(light.isOn());
                }
            }
        }
    }

}