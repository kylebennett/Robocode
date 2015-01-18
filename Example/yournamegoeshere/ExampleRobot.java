/**
 * 
 */
package yournamegoeshere;

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
public class ExampleRobot extends Robot {

    /**
     * The default behaviour of your bot goes in this method.
     */
    @Override
    public void run() {

        while (true) {

            // your code goes here

        }
    }

    /**
     * Called when your bot scans another bot.
     */
    @Override
    public void onScannedRobot(ScannedRobotEvent event) {

    }

    /**
     * Called when your bot is hit by a bullet.
     */
    @Override
    public void onHitByBullet(HitByBulletEvent event) {

    }

    /**
     * Called when your bot ccrashes into another bot.
     */
    @Override
    public void onHitRobot(HitRobotEvent event) {

    }

    /**
     * Called when your bot crashes into a wall.
     */
    @Override
    public void onHitWall(HitWallEvent event) {

    }

    /**
     * Called when your bot wins... Do a little victory dance.
     */
    @Override
    public void onWin(WinEvent event) {

    }

}
