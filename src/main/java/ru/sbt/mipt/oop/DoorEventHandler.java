package ru.sbt.mipt.oop;

/**
 * Created by Svetik on 14.12.2017.
 */
public class DoorEventHandler implements EventHandler {
    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        // событие от двери
        if (EventManager.isDoorOpenEvent(event) || EventManager.isDoorClosedEvent(event)) {
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(event.getObjectId())) {
                        if (EventManager.isDoorOpenEvent(event)) {
                            SmartHomeManager.openDoor(door);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                        } else {
                            SmartHomeManager.closeDoor(door);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        }
                    }
                }
            }
        }
    }
}
