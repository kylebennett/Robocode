package kb.resultsparser;

import java.util.ArrayList;

import kb.resultsparser.model.Battle;
import kb.resultsparser.model.League;
import kb.resultsparser.model.Results;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Kyle
 *
 */
public class SAXResultsHandler extends DefaultHandler {

    public enum elements {
        LEAGUE, COMPETITOR, SEASON, SEASON_TOTALS, GROUPING, RESULTS;
    }

    private static final String BATTLEFIELD_HEIGHT_ATTRIBUTE = "battlefield_height";
    private static final String BATTLEFIELD_WIDTH_ATTRIBUTE = "battlefield_width";
    private static final String BOTS_PER_BATTLE_ATTRIBUTE = "opponents_per_grouping";
    private static final String ROUNDS_PER_BATTLE_ATTRIBUTE = "rounds_per_grouping";

    private static final String BOT_NAME_ATTRIBUTE = "classname";

    private League league;

    private ArrayList<Results> currResults;

    private Battle currBattle;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (elements.valueOf(qName)) {

        case LEAGUE:
            league = new League();
            setLeagueAttributes(attributes);
            break;

        case COMPETITOR:
            league.addRobot(attributes.getValue(BOT_NAME_ATTRIBUTE));
            break;

        case SEASON:
            // do nothing
            break;

        case SEASON_TOTALS:
            currResults = new ArrayList<Results>();
            break;

        case GROUPING:
            currBattle = new Battle();
            currResults = new ArrayList<Results>();
            break;

        case RESULTS:
            Results r = processResults(attributes);
            currResults.add(r);
            break;

        default:
            System.out.println("UnknownElement");
            break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        switch (elements.valueOf(qName)) {

        case LEAGUE:
            // do nothing
            break;

        case COMPETITOR:
            // do nothing
            break;

        case SEASON:
            // do nothing
            break;

        case SEASON_TOTALS:
            league.setFinalScores(currResults);
            break;

        case GROUPING:
            currBattle.setResults(currResults);
            league.addBattle(currBattle);
            break;

        case RESULTS:
            // do nothing
            break;

        default:
            System.out.println("UnknownElement");
            break;
        }
    }

    /**
     * Set the general attributes of the league.
     * 
     * @param attributes
     */
    private void setLeagueAttributes(Attributes attributes) {

        league.setBattlefieldHeight(Integer.parseInt(attributes.getValue(BATTLEFIELD_HEIGHT_ATTRIBUTE)));
        league.setBattlefieldWidth(Integer.parseInt(attributes.getValue(BATTLEFIELD_WIDTH_ATTRIBUTE)));
        league.setBotsPerBattle(Integer.parseInt(attributes.getValue(BOTS_PER_BATTLE_ATTRIBUTE)));
        league.setRoundsPerBattle(Integer.parseInt(attributes.getValue(ROUNDS_PER_BATTLE_ATTRIBUTE)));
    }

    /**
     * Create a results Object from the given attributes.
     * 
     * @param attributes
     * @return
     */
    private Results processResults(Attributes attributes) {

        String name = attributes.getValue(Results.BOT_NAME_ATTRIBUTE);
        int score = Integer.parseInt(attributes.getValue(Results.TOTAL_SCORE_ATTRIBUTE));

        Results r = new Results(name, score);

        return r;
    }

    /**
     * @return the league
     */
    public League getLeague() {
        return league;
    }

}
