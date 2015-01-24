package kb.resultsparser.model;

/**
 * @author Kyle
 *
 */
public class Results {

    public static final String BOT_NAME_ATTRIBUTE = "id";
    public static final String TOTAL_SCORE_ATTRIBUTE = "total_score";

    private final String name;
    private final int score;

    public Results(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {

        return name + " : " + score;
    }
}
