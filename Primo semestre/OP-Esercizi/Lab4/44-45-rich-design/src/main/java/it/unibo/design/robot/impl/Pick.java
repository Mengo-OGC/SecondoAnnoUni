package it.unibo.design.robot.impl;

public class Pick extends Command {
    public Pick(final double energyConsume, final ComandableComponent cmp) {
        super(energyConsume, cmp);
    }

    @Override
    public boolean action() {
        if (super.)
            if (!super.ge.isGrabbing()) {
                this.arms[0].pickUp();
                this.consumeBattery(arms[0].getConsumptionForPickUp());
            } else if (!this.arms[1].isGrabbing()) {
                this.arms[1].pickUp();
                this.consumeBattery(arms[1].getConsumptionForPickUp());
            return true;
        }
        return false;
    }

}
