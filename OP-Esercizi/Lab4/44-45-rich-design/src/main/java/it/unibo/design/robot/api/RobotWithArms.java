package it.unibo.design.robot.api;

public interface RobotWithArms extends Robot {
    boolean pickUp();
    boolean dropDown();
    int getCarriedItemsCount();
}
