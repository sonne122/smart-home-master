package ru.sbt.mipt.oop;

/**
 * Created by Samsung on Svetik on 14.12.2017.
 */
public class ScenarioRunner implements EventHandler {
    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        if (EventManager.isDoorClosedEvent(event)) {
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(event.getObjectId())) {
                        if (room.getName().equals("hall")) {
                            for (Room homeRoom : smartHome.getRooms()) {
                                for (Light light : homeRoom.getLights()) {
                                    SmartHomeManager.turnOffLight(light);
                                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                    Application.sendCommand(command);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("All lights were turned off.");
        }
    }
}