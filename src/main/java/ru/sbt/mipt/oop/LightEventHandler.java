package ru.sbt.mipt.oop;

/**
 * Created by Svetik on 15.12.2017.
 */
public class LightEventHandler implements EventHandler {
    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        // событие от источника света
        if (EventManager.isLightOnEvent(event) || EventManager.isLightOffEvent(event)) {
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    if (light.getId().equals(event.getObjectId())) {
                        if (EventManager.isLightOnEvent(event)) {
                            SmartHomeManager.turnOnLight(light);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                        } else {
                            SmartHomeManager.turnOffLight(light);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                        }
                    }
                }
            }
        }
    }
}
