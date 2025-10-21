package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotWithArms;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {
    private static final int ARMS_NUMBER = 2;
    private BaseArm[] arms = {new BaseArm("a1", 0, 0), new BaseArm("a2", 0, 0)};
    private int numberArmHocked;

    public RobotWithTwoArms(final String robotName) {
        super(robotName);
    }

    @Override
    public boolean pickUp() {
        if (this.numberArmHocked < this.ARMS_NUMBER) {
            if (!this.arms[0].isGrabbing()) {
                this.arms[0].pickUp();
                this.consumeBattery(arms[0].getConsumptionForPickUp());
            } else if (!this.arms[1].isGrabbing()) {
                this.arms[1].pickUp();
                this.consumeBattery(arms[1].getConsumptionForPickUp());
            }
            this.numberArmHocked++;
            return true;
        }
        return false;
    }

    @Override
    public boolean dropDown() {
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
        return false;
    }

    @Override
    protected double getBatteryRequirementForMovement() {
        return MOVEMENT_DELTA_CONSUMPTION + this.getCarriedItemsCount() * 0.1;
    }

    @Override
    public int getCarriedItemsCount() {
        return this.numberArmHocked;
    }

}
