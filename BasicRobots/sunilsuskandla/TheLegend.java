/**
 * 
 */
package sunilsuskandla;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

/**
 * This robot extends a basic robot.
 * 
 * See http://robowiki.net/wiki/Robocode/My_First_Robot for a good beginner tutorial.
 * 
 * All movement and shooting methods have been defined, you just need to slot them in where you want
 * them.
 * 
 * Movement
 * 
 * - ahead(distance); Move forward, distance in pixels
 * 
 * - back(distance); move backwards, distance in pixels
 * 
 * - turnLeft(degrees); / turnRight(degrees); turn your bot to the left or right
 * 
 * - turnGunLeft(degrees); / turnGunRight(degrees); turn your gun to the left or right
 * 
 * - turnRadarLeft(degrees); / turnRadarRight(degrees); turn your radar left or right
 * 
 * Shooting
 * 
 * - fire(power); fire a bullet
 * 
 */
public class TheLegend extends Robot {

    /**
     * The default behaviour of your bot goes in this method.
     */
    @Override
    public void run() 
    {
        while (true)
        {

            // My code
                  	
        	ahead(100);
        	turnRight(90);
        	// back(50);
        	// turnLeft(60);   	      	
        	
        }
    }

    /**
     * Called when your bot scans another bot.
     */
    @Override
    public void onScannedRobot(ScannedRobotEvent event) 
    
    {
    	
    	double distance = event.getDistance();
    	
    	if(distance<300)
    	{
    	   fire(3.5);
    	}
    	else if(distance<500)
    	{
    	   fire(2.5);
    	}
    	else if(distance<800)
    	{
    	   fire(1.5);
    	}
    	else
    	{
    	   fire(0.5);
    	}
    	

    }

    /**
     * Called when your bot is hit by a bullet.
     */
    @Override
    public void onHitByBullet(HitByBulletEvent event) 
    
    {
    	
    	back(30);
    	    	
    }

    /**
     * Called when your bot ccrashes into another bot.
     */
    @Override
    public void onHitRobot(HitRobotEvent event) {
    	
    	back(30);
    	fire(3);

    }

    /**
     * Called when your bot crashes into a wall.
     */
    @Override
    public void onHitWall(HitWallEvent event) {
    	
    	back(50);

    }

    /**
     * Called when your bot wins... Do a little victory dance.
     */
    @Override
    public void onWin(WinEvent event) {
    	ahead(10);
    	turnLeft(10);
    	ahead(10);
    	turnRight(10);
    	

    }

}
