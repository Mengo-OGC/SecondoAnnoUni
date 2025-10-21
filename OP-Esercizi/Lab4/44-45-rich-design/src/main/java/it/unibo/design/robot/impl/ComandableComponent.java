package it.unibo.design.robot.impl;

public abstract class ComandableComponent {
    private final Command[] comands;

    public ComandableComponent(final Command[] comands) {
        this.comands = comands;
    }

    public int availableCommands() {
        return this.comands.length;
    }

    public abstract void sendComand(final int id);
}
