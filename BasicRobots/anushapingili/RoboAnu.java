package anushapingili;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import java.awt.Color;

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
 * - turnLeft(degrees); / turnRight(degrees); turn my bot to the left or right
 *
 * - turnGunLeft(degrees); / turnGunRight(degrees); turn my gun to the left or right
 *
 * - turnRadarLeft(degrees); / turnRadarRight(degrees); turn my radar left or right
 *
 * Shooting
 *
 * - fire(power); fire a bullet
 *
 */
public class RoboAnu extends Robot {
    
    /**
     * The default behaviour of my bot goes in this method.
     */
    @Override
    public void run() {
        setColors(Color.CYAN,Color.ORANGE,Color.pink);
        
        
        while (true) {
            
            ahead(500);
            turnGunRight(360);
            back(500);
            turnRadarLeft(90);
            
        }
    }
    
    
    /**
     * Called when my bot scans another bot.
     */
    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        
        if (event.getDistance() < 50 && getEnergy() > 50) {
            fire(3);
        }
        else {
            fire(1);
        }
        // Call scan again, before we turn the gun
        scan();
        
    }
    
    /**
     * Called when my bot is hit by a bullet.
     */
    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        turnLeft(90 - event.getBearing()); //Turn perpendicular to the bullet to avoid future shots
        turnRight(200);
        
    }
    
    /**
     * Called when my bot crashes into another bot.
     */
    @Override
    public void onHitRobot(HitRobotEvent event) {
        back(50);
        fire(2);
        turnLeft(100);
        fire(1);
        
    }
    
    /**
     * Called when my bot crashes into a wall.
     */
    @Override
    public void onHitWall(HitWallEvent event) {
        back(20);
        turnRight(90 - event.getBearing());
        ahead(300);
        
        fire(1);
        
    }
    
    /**
     * Called when my bot wins... Do a little victory dance.
     */
    @Override
    public void onWin(WinEvent event) {
        turnLeft(10);
        turnRight(10);
        turnGunRight(360);
        System.out.println("YEAH!! I won");
        
    }
    
}
