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
			turnGunRight(360);
			turnLeft(100);
			turnGunLeft(360);
			}
	}

		@Override
	    public void onScannedRobot(ScannedRobotEvent event) {

	        fire(2);
	        ahead(100);

	    }

	    @Override
	    public void onHitByBullet(HitByBulletEvent event) {

	    }

	    @Override
	    public void onHitRobot(HitRobotEvent event) {
	    	fire(1);
			back(100);

	    }

	    @Override
	    public void onHitWall(HitWallEvent event) {
	    	back(50);
	    }

	    @Override
	    public void onWin(WinEvent event) {

	    }	
	
}
