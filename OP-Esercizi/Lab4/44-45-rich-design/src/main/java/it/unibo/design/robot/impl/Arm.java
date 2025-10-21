package it.unibo.design.robot.impl;

public class Arm extends ComandableComponent {
    protected final BaseArm ba;

    public Arm() {
        super({new Pick(), new Drop()});
        ba = new BaseArm("", 0.1, 0.2);
    }

    @Override
    public void sendComand(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendComand'");
    }

    @Override
    protected double getBatteryRequirementForMovement() {
        return MOVEMENT_DELTA_CONSUMPTION + this.getCarriedItemsCount() * 0.1;
    }

}
