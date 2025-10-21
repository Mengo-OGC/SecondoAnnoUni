package it.unibo.design.robot.impl;

public class Drop extends Command {

    public Drop(double energyConsume) {
        super(energyConsume);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean action() {
        if (this.numberArmHocked > 0) {
            if (this.arms[0].isGrabbing()) {
                this.arms[0].pickDown();
                this.consumeBattery(arms[0].getConsumptionForDropDown());
            } else if (this.arms[1].isGrabbing()) {
                this.arms[1].pickDown();
                this.consumeBattery(arms[1].getConsumptionForDropDown());
            }
            this.numberArmHocked--;
            return true;
        }
        return false;    }

}
