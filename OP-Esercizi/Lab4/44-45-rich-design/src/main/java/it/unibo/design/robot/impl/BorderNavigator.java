package it.unibo.design.robot.impl;

import it.unibo.design.robot.environment.api.Position2D;
import it.unibo.design.robot.environment.impl.RobotEnvironment;

import java.util.Arrays;

public class BorderNavigator extends ImpComponent {
    private final static double energyConsum = 0.2;

    public BorderNavigator() {
        super(energyConsum);
    }

    @Override
    public void action(BaseRobot br) {
        int i = calcInitialDirection(br.getPosition());
        for (int j = 0; j < 5; j++) {
            boolean go = true;
            do {
                switch (i) {
                    case 0:
                        go = br.moveLeft();
                        break;
                    case 1:
                        go = br.moveUp();
                        break;
                    case 2:
                        go = br.moveRight();
                        break;
                    case 3:
                        go = br.moveDown();
                        break;
                }
            } while (go);
            i++;
        }

    }

    /*
     * 0 = left
     * 1 = right
     * 2 = top
     * 3 = down
     */
    private int calcInitialDirection(final Position2D p2d) {
        final int x = p2d.getX();
        final int y = p2d.getY();
        final int dx = RobotEnvironment.X_UPPER_LIMIT - p2d.getX();
        final int dy = RobotEnvironment.Y_UPPER_LIMIT - p2d.getY();
        int[] arr = { p2d.getX(), p2d.getY(), dx, dy };
        Arrays.sort(arr);
        final int min = arr[0];
        if (min == x) {
            return 0;
        } else if (min == y) {
            return 1;
        } else if (min == dx) {
            return 2;
        } else {
            return 3;
        }
    }

}
