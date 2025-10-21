package it.unibo.design.robot.api;

import it.unibo.design.robot.impl.BaseRobot;

public interface Component {
    boolean isOn();
    void turnOn();
    void turnOff();
    boolean isConnected();
    void connect();
    void disconnect();
    void action(BaseRobot br);
}
