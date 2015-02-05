package shailajasunkara;
import robocode.*;

import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Shail - a robot by (your name here)
 */
public class ShailPower extends Robot
{
	
	
	public void run() {
		
		setColors(Color.MAGENTA,Color.blue,Color.green); 

		while(true) {
			ahead(300);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		if(getEnergy() > 30){
			fire(3);
		}
		else{
			fire(1);
		}
		
	}

	public void onHitRobot(HitRobotEvent e) {
		turnRight(90);
	}


	public void onHitByBullet(HitByBulletEvent e) {
		turnRight(45);
		back(100);
	}
	
	public void onHitWall(HitWallEvent e) {
		turnRight(90);
	}	
}

