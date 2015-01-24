package kylebennett;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

/**
 * @author Kyle Bennett
 * 
 */
public class TheGruffalo extends Robot {

    @Override
    public void run() {

        while (true) {

            ahead(100);
            turnGunLeft(360);

            turnLeft(180);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {

        fire(2);

    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {

    }

    @Override
    public void onHitRobot(HitRobotEvent event) {

    }

    @Override
    public void onHitWall(HitWallEvent event) {

    }

    @Override
    public void onWin(WinEvent event) {

    }

}
