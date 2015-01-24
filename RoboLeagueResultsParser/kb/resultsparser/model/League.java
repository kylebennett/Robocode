package kb.resultsparser.model;

import java.util.ArrayList;

public class League {

    private int battlefieldHeight;
    private int battlefieldWidth;
    private int botsPerBattle;
    private int roundsPerBattle;

    private ArrayList<String> robots = new ArrayList<String>();

    private ArrayList<Results> finalScores;

    private ArrayList<Battle> battles = new ArrayList<Battle>();

    public void addRobot(String robot) {
        robots.add(robot);
    }

    public void addBattle(Battle b) {
        battles.add(b);
    }

    /**
     * @return the battlefieldHeight
     */
    public int getBattlefieldHeight() {
        return battlefieldHeight;
    }

    /**
     * @param battlefieldHeight
     *            the battlefieldHeight to set
     */
    public void setBattlefieldHeight(int battlefieldHeight) {
        this.battlefieldHeight = battlefieldHeight;
    }

    /**
     * @return the battlefieldWidth
     */
    public int getBattlefieldWidth() {
        return battlefieldWidth;
    }

    /**
     * @param battlefieldWidth
     *            the battlefieldWidth to set
     */
    public void setBattlefieldWidth(int battlefieldWidth) {
        this.battlefieldWidth = battlefieldWidth;
    }

    /**
     * @return the botsPerBattle
     */
    public int getBotsPerBattle() {
        return botsPerBattle;
    }

    /**
     * @param botsPerBattle
     *            the botsPerBattle to set
     */
    public void setBotsPerBattle(int botsPerBattle) {
        this.botsPerBattle = botsPerBattle;
    }

    /**
     * @return the roundsPerBattle
     */
    public int getRoundsPerBattle() {
        return roundsPerBattle;
    }

    /**
     * @param roundsPerBattle
     *            the roundsPerBattle to set
     */
    public void setRoundsPerBattle(int roundsPerBattle) {
        this.roundsPerBattle = roundsPerBattle;
    }

    /**
     * @return the robots
     */
    public ArrayList<String> getRobots() {
        return robots;
    }

    /**
     * @param robots
     *            the robots to set
     */
    public void setRobots(ArrayList<String> robots) {
        this.robots = robots;
    }

    /**
     * @return the finalScores
     */
    public ArrayList<Results> getFinalScores() {
        return finalScores;
    }

    /**
     * @param finalScores
     *            the finalScores to set
     */
    public void setFinalScores(ArrayList<Results> finalScores) {
        this.finalScores = finalScores;
    }

    /**
     * @return the battles
     */
    public ArrayList<Battle> getBattles() {
        return battles;
    }

    /**
     * @param battles
     *            the battles to set
     */
    public void setBattles(ArrayList<Battle> battles) {
        this.battles = battles;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("===== League Results =====\n\n");

        builder.append("Battlefield Size - " + battlefieldWidth + " x " + battlefieldHeight + "\n");
        builder.append("Robots per Battle - " + botsPerBattle + "\n");
        builder.append("Rounds per Battle - " + roundsPerBattle + "\n");

        builder.append("\n===== Robots =====\n\n");

        for (String name : robots) {
            builder.append("\t" + name.replace(".", " - ") + "\n");
        }

        builder.append("\n===== Battles =====\n\n");

        for (Battle b : battles) {
            builder.append(b.toString() + "\n");
        }

        builder.append("\n===== Final Scores =====\n\n");

        for (Results r : finalScores) {
            builder.append("\t" + r.toString() + "\n");
        }

        return builder.toString();
    }
}
