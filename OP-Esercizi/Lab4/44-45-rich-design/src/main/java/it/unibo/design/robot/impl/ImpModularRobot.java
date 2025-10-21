package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.Component;

public class ImpModularRobot extends BaseRobot {
    private final Component[] components;

    public ImpModularRobot(final String robotName) {
        super(robotName);
        this.components = new Component[4];
    }

    public void doCycle() {

    }

    public void attachComponent(Component cmp) {

    }

    public void detachComponent(Component cmp) {

    }

    public int getComponentCarried() {
        return this.components.length;
    }
}