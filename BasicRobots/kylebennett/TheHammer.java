/**
 * 
 */
package kylebennett;

import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * @author kylebennett
 *
 */
public class TheHammer extends Robot {

	private int turnDirection = 1;

	@Override
	public void run() {
		
		Color purple = new Color(125, 60, 160);
		setColors(purple, purple, purple);

		while(true){
			turnRight(30 * turnDirection);
		}		
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {

		turnDirection = event.getBearing() >=0 ? 1 : -1; 
		turnRight(event.getBearing());
		
		ahead(event.getDistance() + 10);
		
		scan();
	}
	
	@Override
	public void onHitByBullet(HitByBulletEvent event) {

		super.onHitByBullet(event);
	}

	@Override
	public void onHitRobot(HitRobotEvent event) {

		turnDirection = event.getBearing() >=0 ? 1 : -1; 
		turnRight(event.getBearing());
		fire(2);
	}

	@Override
	public void onHitWall(HitWallEvent event) {
		// TODO Auto-generated method stub
		super.onHitWall(event);
	}


}
