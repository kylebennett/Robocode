package kb.resultsparser.model;

import java.util.ArrayList;

/**
 * @author Kyle
 *
 */
public class Battle {

    private ArrayList<Results> results;

    /**
     * @return the results
     */
    public ArrayList<Results> getResults() {
        return results;
    }

    /**
     * @param results
     *            the results to set
     */
    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (Results r : results) {
            builder.append("\t" + r + "\n");
        }

        return builder.toString();
    }
}
