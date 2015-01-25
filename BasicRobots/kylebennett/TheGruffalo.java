package kylebennett;

import java.awt.Color;
import java.util.Random;

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
	private Random random = new Random();
	
    @Override
    public void run() {
    	
    	setColour();

        while (true) {

        	if(getTime() % 60 == 0){
        		turnLeft(45 * moveDirection);
        	}
        	
            ahead(getMoveDistance() * moveDirection);
            turnGunLeft(360 * moveDirection);
            
            moveDirection *= -1;      
        }
    }

    private void setColour() {
		setColors(Color.BLUE, Color.ORANGE, Color.BLUE, Color.ORANGE, Color.ORANGE);
	}

	private int getMoveDistance() {
    	
		return random.nextInt(200) + 100;
	}

	@Override
    public void onScannedRobot(ScannedRobotEvent event) {
    	
    	if(canFire(event) ){
    		fire(3);
    	}
    }

    private boolean canFire(ScannedRobotEvent event) {

    	if(getGunHeat() == 0){
    		return true;
    	}
		return false;
	}

	@Override
    public void onHitByBullet(HitByBulletEvent event) {
    	turnLeft(60 * moveDirection);
    	ahead(50 * moveDirection);
    	turnGunLeft(360 * moveDirection);
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
    	turnLeft(180);
    	ahead(50 * moveDirection);
    	turnGunLeft(360 * moveDirection);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
    	turnLeft(180);
    	ahead(50 * moveDirection);
    	turnGunLeft(360 * moveDirection);
    }

    @Override
    public void onWin(WinEvent event) {

    }
}
