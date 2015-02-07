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
    private double moveDistance = 100;
	private double adjustment = 3;

    @Override
    public void run() {

        // Make it Ginger
        setColour();

        // Move the gun and radar independently of the body
        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(true);

        while (true) {
        	
            // switch directions every 30 turns
            if (getTime() % 10 == 0) {
                moveDirection *= -1;
            }

            // Move in a hexagonal pattern
            ahead(moveDistance);
            turnRadarLeft(360 * moveDirection);
            turnLeft(60 * moveDirection);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
    	
    	double turnAmount = getGunTurnAmount(event.getBearing());
    	
    	turnAmount = (turnAmount > 0 && event.getVelocity() > 0) ? turnAmount + adjustment  : turnAmount - adjustment;
    	
    	turnGunRight(turnAmount);
    	
    	if(canFire()){
    		fire(2);
    	}
    }
    
	private double getGunTurnAmount(double bearing) {
		
		double absoluteBearing = getHeading() + bearing;
    	return normalRelativeAngleDegrees(absoluteBearing - 
    	    getGunHeading());
	}

    private boolean canFire() {

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
    	getGunTurnAmount(event.getBearing());

        // point blank shot!
        fire(3);

        // back up
        back(moveDistance);

        // scan to see if its still there
        turnRadarLeft(360 * moveDirection);
    }

    @Override
    public void onHitWall(HitWallEvent event) {

        // Turn away from the wall... I think
        double turnAmt = normalRelativeAngleDegrees(event.getBearing());
        
        turnLeft(turnAmt);

        // move away
        ahead(moveDistance);
        turnRadarLeft(360 * moveDirection);
    }
        
    private void setColour() {
    	
    	Color ginger = new Color(240, 170, 10);
        setColors(ginger, Color.BLUE, ginger);
    }

    @Override
    public void onWin(WinEvent event) {
        turnRight(1080);
    }
}
