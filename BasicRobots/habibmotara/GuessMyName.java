package habibmotara;

import java.awt.AWTException;
import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;


/**
 * MyRobot - a robot by (Habib Motara)
 */

public class GuessMyName extends Robot {
	double previousEnergy = 100;
	int movementDirection = 1;
	int gunDirection = 1;
	private HitByBulletEvent e;
	
	public void run() {
	    turnGunRight(99999);
	}
	public GuessMyName() throws AWTException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * run: MyRobot default behavior
	 */
	
	public void setColors() {
		setColors(Color.yellow,Color.blue,Color.red); // body,gun,radar
	}
	
	public void run1() {
		// Initialization of the robot
		
		 	setColors(Color.yellow,Color.blue,Color.red); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior
			ahead(100);
			turnGunRight(90);
			turnLeft(100);
			turnGunLeft(90);
			}
	}

		@Override
	    public void onScannedRobot(ScannedRobotEvent event) {
			fire (2);
			int distance = 0;
			
			if(distance>200)
			{
			fire(2);
	        back(100);
			}
			if(distance<200)
	        {
	           fire(2);
	        }
	        else if(distance<500)
	        {
	           fire(2);
	        }
	        else if(distance<800)
	        {
	           fire(2);
	        }
	        else
	        {
	           ahead(100);
	        }	
			e = null;
			turnRight(e.getBearing()+90-
			         30*movementDirection);
			gunDirection = -gunDirection;
		    turnGunRight(99999*gunDirection);
	    }

		@Override
	    public void onHitByBullet(HitByBulletEvent event) {
	    	back(10);
	    	fire(2);
	    }

	    @Override
	    public void onHitRobot(HitRobotEvent event) {
			back(100);
			fire(2);

	    }

	    @Override
	    public void onHitWall(HitWallEvent event) {
	    	back(20);
	    }	
	
}
