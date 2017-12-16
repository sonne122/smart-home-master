package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.List;

import static ru.sbt.mipt.oop.Application.getNextSensorEvent;

/**
 * Created by Samsung on 08.12.2017.
 */
public class SensorEventObserver {

    private List<EventHandler> eventHandlers = new ArrayList<>();
    private SmartHome smartHome;

    public SensorEventObserver(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    public void startEventHandlingCycle(){
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler eventHandler : eventHandlers) {
                eventHandler.handle(smartHome, event);
            }
            event = getNextSensorEvent();
        }
    }

    public void addHandler(EventHandler eventHandler){
        eventHandlers.add(eventHandler);
    }
    public void setHandlers(List<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }
}