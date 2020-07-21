import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CSVManipulator {
    private final String COMBINED_CSV_FILE = "new.csv";
    private String fileName;

    // ------------ Constructors-------------------//
    public CSVManipulator() {

    }

    public CSVManipulator(String fileName) {
        this.fileName = fileName;
    }

    // ------------ Methods-------------------//

    // Reads data from CSV file into List
    // Writes data from List to new CSV
    public void csvToList() {

        try {
            String row = "";
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            // True parameter ensures new files will be concatenated
            FileWriter csvWriter = new FileWriter(COMBINED_CSV_FILE, true);

            // Clears first line of the first file so I can add a custom header
            String headerLine = br.readLine();

            while ((row = br.readLine()) != null) {
                List<String> result = Arrays.asList(row.split("\\s*,\\s*"));

                csvWriter.append(String.join(",", result));
                String fileNameColumn = "," + fileName + "\n";
                csvWriter.append(fileNameColumn);

            }
            csvWriter.flush();
            csvWriter.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Method for adding custom column headers
    public void addHeader() {
        try {
            FileWriter csvWriter = new FileWriter(COMBINED_CSV_FILE, true);
            String header = "email_hash" + "," + "category" + "," + "filename" + "\n";
            csvWriter.append(header);

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Writes the combined CSV to the terminal
    public void displayNewCSV() {
        File file = new File(COMBINED_CSV_FILE);
        String row = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((row = br.readLine()) != null) {
                List<String> result = Arrays.asList(row.split("\\s*,\\s*"));
                System.out.println(result);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}