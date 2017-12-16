package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Svetik on 16.12.2017.
 */
public class LightEventHandlerTest {
    LightEventHandler handler = new LightEventHandler();
    Light light = new Light("1", false);
    SmartHome smartHome = new SmartHome(Arrays.asList(new Room(Arrays.asList(light), Collections.EMPTY_LIST,"bedroom")));

    @Test
    public void testLightIsOn(){
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, light.getId());
        assertFalse(light.isOn());
        handler.handle(smartHome, event);
        assertTrue(light.isOn());
    }

    @Test
    public void testLightIsOff(){
        light.setOn(true);
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, light.getId());
        assertTrue(light.isOn());
        handler.handle(smartHome, event);
        assertTrue(!light.isOn());
    }
}