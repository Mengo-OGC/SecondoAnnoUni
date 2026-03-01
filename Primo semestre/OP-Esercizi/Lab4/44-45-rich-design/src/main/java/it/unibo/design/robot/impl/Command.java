package it.unibo.design.robot.impl;

public abstract class Command {
    private final double energyConsume;
    private final ComandableComponent cmp;

    public Command(
        final double energyConsume, 
        final ComandableComponent cmp
    ) {
        this.energyConsume = energyConsume;
        this.cmp = cmp;
    }

    public double getConsum() {
        return this.energyConsume;
    }

    public abstract boolean action();
}
