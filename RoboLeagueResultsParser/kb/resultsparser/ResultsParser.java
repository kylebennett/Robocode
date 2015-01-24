package kb.resultsparser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import kb.resultsparser.model.League;

import org.xml.sax.SAXException;

/**
 * Processes the xml results files from Roboleague and outputs them into a readable format.
 * 
 * @author Kyle
 */
public class ResultsParser {

    private static final String RESULTS_FOLDER = "Results";
    private static final String XML_FILE = ".xml";
    private static final String TXT_FILE = ".txt";

    private final SAXParserFactory parserFactory = SAXParserFactory.newInstance();

    /**
     * Load the xml files from the results folder, process them, and write to a txt file.
     */
    public void parseResults() {

        ArrayList<File> results = loadResultFiles();

        System.out.println("Processing [" + results.size() + "] files...");
        long startTime = System.currentTimeMillis();

        for (File f : results) {
            parseXML(f);
        }

        long duration = (System.currentTimeMillis() - startTime);

        System.out.println("[" + results.size() + "] file(s) processed in " + duration + " ms");
    }

    /**
     * Load XML files from the Results folder
     * 
     * @return - ArrayList with xml result files.
     */
    private ArrayList<File> loadResultFiles() {

        ArrayList<File> resultFiles = new ArrayList<File>();

        File folder = new File(RESULTS_FOLDER);

        for (final File fileEntry : folder.listFiles()) {

            if (fileEntry.isFile() && fileEntry.getName().contains(XML_FILE)) {
                resultFiles.add(fileEntry);
            }
        }

        return resultFiles;

    }

    /**
     * Parse the XML file, creates a league object per xml file.
     * 
     * @param file
     *            - the xml results file.
     */
    private void parseXML(File file) {

        System.out.println("Parsing [" + file.getAbsolutePath() + "] ...");

        try {

            SAXParser parser = parserFactory.newSAXParser();
            SAXResultsHandler handler = new SAXResultsHandler();

            parser.parse(file, handler);

            writeToFile(file.getAbsolutePath(), handler.getLeague());

        } catch (IOException ioe) {
            System.out.println("IO Exception : " + ioe.getMessage());
        } catch (SAXException saxe) {
            System.out.println("SAX Exception: " + saxe.getMessage());
        } catch (ParserConfigurationException pce) {
            System.out.println("Parser Configuration Exception: " + pce.getMessage());
        }
    }

    /**
     * Write the processed League data to a txt file.
     * 
     * @param filename
     *            - The file to write to.
     * @param league
     *            - The processed league data.
     * 
     * @throws IOException
     */
    private void writeToFile(String filename, League league) throws IOException {

        FileWriter fw = null;

        try {

            String newFilename = filename.replace(XML_FILE, TXT_FILE);
            fw = new FileWriter(newFilename);
            fw.write(league.toString());

            System.out.println(newFilename + " created");

        } finally {

            fw.close();
        }
    }

}
