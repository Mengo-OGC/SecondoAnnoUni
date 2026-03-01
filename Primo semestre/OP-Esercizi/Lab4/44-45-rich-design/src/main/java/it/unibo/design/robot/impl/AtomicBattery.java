package it.unibo.design.robot.impl;

public class AtomicBattery extends ImpComponent {
    private final static double energyConsum = 0;

    public AtomicBattery() {
        super(energyConsum);
    }

    @Override
    public void action(final BaseRobot br) {
        br.recharge();
    }

}
