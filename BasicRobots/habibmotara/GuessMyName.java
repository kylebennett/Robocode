package habibmotara;

import java.awt.AWTException;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;


/**
 * MyRobot - a robot by (Habib Motara)
 */

public class GuessMyName extends Robot {

	public GuessMyName() throws AWTException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * run: MyRobot default behavior
	 */
	public void run() {
		// Initialization of the robot
		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(90);
			turnLeft(100);
			turnGunLeft(90);
			}
	}

		@Override
	    public void onScannedRobot(ScannedRobotEvent event) {

	        fire(2);
	        ahead(100);

	    }

	    @Override
	    public void onHitByBullet(HitByBulletEvent event) {
	    	back(10);
	    }

	    @Override
	    public void onHitRobot(HitRobotEvent event) {
			back(100);
			fire(1);

	    }

	    @Override
	    public void onHitWall(HitWallEvent event) {
	    	back(20);
	    }	
	
}
