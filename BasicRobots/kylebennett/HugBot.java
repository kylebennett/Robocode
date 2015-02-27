/**
 * 
 */
package kylebennett;

import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;

/**
 * @author kylebennett
 *
 */
public class HugBot extends Robot {

	private int turnDirection = 1;

	private String currentTarget = null;

	@Override
	public void run() {

		final Color purple = new Color(125, 60, 160);
		setColors(purple, purple, purple);

		while (true) {
			turnRight(30 * turnDirection);
		}
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent event) {

		final boolean theGruffalo = event.getName().contains("TheGruffalo")
				&& getOthers() > 1;

		if (currentTarget == null && !theGruffalo) {

			currentTarget = event.getName();
		}

		if (currentTarget.equals(event.getName())) {

			turnDirection = event.getBearing() >= 0 ? 1 : -1;
			turnRight(event.getBearing() * turnDirection);

			ahead(event.getDistance() + 10);

			scan();
		}
	}

	@Override
	public void onHitByBullet(HitByBulletEvent event) {

	}

	@Override
	public void onHitRobot(HitRobotEvent event) {

		final boolean theGruffalo = event.getName().contains("TheGruffalo")
				&& getOthers() > 1;

		if (!theGruffalo) {
			turnDirection = event.getBearing() >= 0 ? 1 : -1;
			turnRight(event.getBearing());
			fire(3);
		}
	}

	@Override
	public void onHitWall(HitWallEvent event) {

	}

	@Override
	public void onRobotDeath(RobotDeathEvent event) {

		if (event.getName().equals(currentTarget)) {
			currentTarget = null;
		}
	}
}
