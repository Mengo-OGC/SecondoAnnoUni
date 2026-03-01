package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.Component;

public abstract class ImpComponent implements Component {
    private final static boolean ON = true;
    private final static boolean OFF = false;
    private final static boolean CONNECTED = true;
    private final static boolean DISCONNECT = false;

    private final double energyConsum;
    private boolean status;
    private boolean connected;

    public ImpComponent(final double energyConsum) {
        this.energyConsum = energyConsum;
    }

    public boolean isOn() {
        return this.status;
    }
    public boolean isConnected() {
        return this.connected;
    }
    public void turnOn() {
        if (this.status == OFF) {
            this.status = ON;
        }
    }
    public void turnOff() {
        if (this.status == ON) {
            this.status = OFF;
        }
    }
    public void connect() {
        if (this.connected == DISCONNECT) {
            this.connected = CONNECTED;
        }
    }
    public void disconnect() {
        if (this.connected == CONNECTED) {
            this.connected = DISCONNECT;
        }
    }
}
