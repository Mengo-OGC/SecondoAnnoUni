package it.unibo.design.robot.impl;

public class BaseArm {
    private final String armName;
    private final double consumForPickUp;
    private final double consumForDropDown;
    private boolean hooked;

    public BaseArm(
        final String armName, 
        final double consumForPickUp, 
        final double consumForDropDown
    ) {
        this.armName = armName;
        this.consumForPickUp = consumForPickUp;
        this.consumForDropDown = consumForDropDown;
    }

    public boolean isGrabbing() {
        return this.hooked;
    }

    public void pickUp() {
        this.hooked = true;
    }

    public void pickDown() {
        this.hooked = false;
    }

    public double getConsumptionForPickUp() {
        return this.consumForPickUp;
    }

    public double getConsumptionForDropDown() {
        return this.consumForDropDown;
    }

    @Override
    public String toString() {
        return "[" + this.armName + "]: Costo aggancio " + 
        this.consumForPickUp + ", Costo sgancio " +
        this.consumForDropDown + ", Stato agganciamento " + 
        this.hooked;
    }
}
