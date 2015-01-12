/**
 * 
 */
package yournamegoeshere;

import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 *
 */
public class ExampleRobot extends Robot {

    /**
     * 
     */
    @Override
    public void run() {

        while (true) {

        }
    }

    /**
     * 
     */
    @Override
    public void onScannedRobot(ScannedRobotEvent event) {

        fireBullet(2);

    }
}
