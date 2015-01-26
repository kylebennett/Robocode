package kylebennett;

import static robocode.util.Utils.normalRelativeAngleDegrees;

import java.awt.Color;

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

    private byte moveDirection = 1;

    @Override
    public void run() {

        // Make it Ginger
        setColour();

        // Move the gun and radar independently of the body
        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(true);

        while (true) {

            // switch directions every 30 turns
            if (getTime() % 30 == 0) {
                moveDirection *= -1;
            }

            // Move in a hexagonal pattern
            ahead(75);
            turnRadarLeft(360 * moveDirection);
            turnLeft(60 * moveDirection);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {

        // If I can fire...
        if (canFire(event)) {

            // turn the gun to the scanned robot
            turnGun(event.getBearing());

            // and fire!
            fire(2);
        }
    }

    private boolean canFire(ScannedRobotEvent event) {

        // if the gun heat is 0 fire, otherwise don't waste the turn
        if (getGunHeat() == 0 && getEnergy() > 20) {
            return true;
        }
        return false;
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {

        // Switch directions if I get hit
        moveDirection *= -1;

    }

    @Override
    public void onHitRobot(HitRobotEvent event) {

        // turn the gun to the other bot
        turnGun(event.getBearing());

        // point blank shot!
        fire(3);

        // back up
        back(20);

        // scan to see if its still there
        turnRadarLeft(360 * moveDirection);
    }

    @Override
    public void onHitWall(HitWallEvent event) {

        // Turn away from the wall... I think
        double turnAmt = normalRelativeAngleDegrees(event.getBearing());
        turnLeft(turnAmt);

        // move away
        ahead(100);
        turnRadarLeft(360 * moveDirection);
    }

    public void turnGun(double bearing) {

        // turn the gun to point at the other bot
        double gunTurnAmt = normalRelativeAngleDegrees(bearing + (getHeading() - getGunHeading()));
        turnGunRight(gunTurnAmt);
    }

    private void setColour() {
        setColors(Color.ORANGE, Color.BLUE, Color.ORANGE, Color.BLUE, Color.BLUE);
    }

    @Override
    public void onWin(WinEvent event) {
        turnRight(1080);
    }
}
