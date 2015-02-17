package glennBoylan;
import robocode.*;
import java.awt.Color;
import java.awt.Graphics2D;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * MetalMickyGB - a robot by (Mr Glenn)
 */
public class MetalMickyGB extends Robot
{
	/**
	 * run: MetalMickyGB's default behavior
	 */
	
	private Double bearing = 10.0;

	public void run() {
		// Initialization of the robot should be put here
		setColors(Color.black, Color.red, Color.yellow); // body,gun,radar
		
		// Move the gun and radar independently of the body
        //setAdjustGunForRobotTurn(true);
        //setAdjustRadarForGunTurn(true);
		
		// Robot main loop
		while(true) {
			//ahead(100);
			turnRadarRight(360);
			//turnRight(bearing);
		
			
		}
	}
	
	public void onPaint(Graphics2D g)
	{
	}

	public void onScannedRobot(ScannedRobotEvent e) {
	
		bearing = e.getBearing();
		double nmeHeading = e.getHeading();
		double myHeading = getHeading();
		if (e.getDistance()<=300 && e.getVelocity()<5){
			turnRight(bearing);
			fire(20);
			if (e.getDistance()<=200){
				scan();}
			ahead(10);
			
		}
		else{
			turnRight(e.getBearing()+20);
			ahead(e.getDistance()/2);
			//scan();
			turnRight(e.getBearing());
			scan();
				
		}
		
	}
	
	public void onHitRobot(HitRobotEvent e)
	{
		turnRight(e.getBearing());
		fire(5);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		/*
		turnRight(90);
		back(60);
		turnLeft(e.getBearing());
		turnRadarRight(360);*/
	}
	
	public void onHitWall(HitWallEvent e) {
		back(getVelocity()*-1);
	}	
}
