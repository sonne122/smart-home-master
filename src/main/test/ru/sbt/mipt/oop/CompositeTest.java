package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class CompositeTest {
    @Test
    public void testActionableComposite() {
        Set<Object> objects = new HashSet<>();

        List<Light> l1 = Arrays.asList(new Light("1", true), new Light("2", false));
        List<Door> d1 = Arrays.asList(new Door(false, "1"));
        Room hall = new Room(l1, d1,"hall");
        objects.addAll(l1);
        objects.addAll(d1);
        objects.add(hall);

        List<Light> l2 = Arrays.asList(new Light("3", true));
        List<Door> d2 = Arrays.asList(new Door(true, "2"));
        Room bathroom = new Room(l2, d2,"bathroom");
        objects.add(bathroom);
        objects.addAll(l2);
        objects.addAll(d2);

        SmartHome smartHome = new SmartHome(Arrays.asList(hall, bathroom));
        objects.add(smartHome);
        smartHome.executeAction(objects::remove);
        assertEquals(0, objects.size());
    }
}