/**
 * 
 */
package waleeddeeba;

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
public class LordSugar extends Robot {

    /**
     * The default behaviour of your bot goes in this method.
     */
    @Override
    public void run() {

        while (true) {
        	double distance = Math.random()*300;
            double angle = Math.random()*45;
     	 turnRight(angle);
          ahead(distance);
          ahead(50);
          turnGunRight(90);
          back(70);
          turnGunRight(30);
        }
    }

    /**
     * Called when your bot scans another bot.
     */
    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
     	fire(3);
    	double distance = Math.random()*300;
       double angle = Math.random()*45;
	 turnRight(angle);
     ahead(distance);
   
    }

    /**
     * Called when your bot is hit by a bullet.
     */
    @Override
    public void onHitByBullet(HitByBulletEvent event) {
    	   double distance = Math.random()*300;
           double angle = Math.random()*45;
    	 turnRight(angle);
         ahead(distance);
         ahead(50);
         turnGunRight(90);
         back(67);
         turnGunRight(90);
    }

    /**
     * Called when your bot ccrashes into another bot.
     */
    @Override
    public void onHitRobot(HitRobotEvent event) {
    	fire(3);
    }

    /**
     * Called when your bot crashes into a wall.
     */
    @Override
    public void onHitWall(HitWallEvent event) {
    	   double distance = Math.random()*500;
           double angle = Math.random()*75;
    	 turnRight(angle);
         ahead(distance);
         fire(3);
    }

    /**
     * Called when your bot wins... Do a little victory dance.
     */
    @Override
    public void onWin(WinEvent event) {

    }

}
