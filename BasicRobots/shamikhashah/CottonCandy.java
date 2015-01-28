package shamikhashah;

import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

public class CottonCandy extends Robot
{
    /**
     * The default behaviour of your bot goes in this method.
     */
    @Override
    public void run()
    {
        // Set colors

        setBodyColor(new Color(255, 192, 203));
        setGunColor(new Color(160, 32, 240));
        setRadarColor(new Color(255, 0, 0));
        setBulletColor(new Color(255, 165, 0));
        setScanColor(new Color(0, 255, 0));

        while (true)
        {

            // your code goes here
            zigZag();

        }
    }

    /**
     * Called when your bot scans another bot.
     */
    @Override
    public void onScannedRobot(ScannedRobotEvent event)
    {
        fire(1);
    }

    /**
     * Called when your bot is hit by a bullet.
     */
    @Override
    public void onHitByBullet(HitByBulletEvent event)
    {

    }

    /**
     * Called when your bot ccrashes into another bot.
     */
    @Override
    public void onHitRobot(HitRobotEvent event)
    {
        turnLeft(180);
        ahead(1000);
    }

    /**
     * Called when your bot crashes into a wall.
     */
    @Override
    public void onHitWall(HitWallEvent event)
    {
        turnLeft(180);
        ahead(1000);
    }

    /**
     * Called when your bot wins... Do a little victory dance.
     */
    @Override
    public void onWin(WinEvent event)
    {

    }

    private void zigZag()
    {
        turnLeft(45);
        ahead(1000);
        turnRight(90);
        ahead(1000);
        turnLeft(45);

    }

}
