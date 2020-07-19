import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CSVManipulator {
    final String COMBINED_CSV_FILE = "new.csv";
    String fileName;

    CSVManipulator() {

    }

    CSVManipulator(String fileName) {
        this.fileName = fileName;
    }

    void csvToList() {
        try {
            String row = "";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            FileWriter csvWriter = new FileWriter(COMBINED_CSV_FILE, true);
            String headerLine = br.readLine();

            while ((row = br.readLine()) != null) {
                List<String> result = Arrays.asList(row.split("\\s*,\\s*"));

                csvWriter.append(String.join(",", result));
                String x = "," + fileName + "\n";
                csvWriter.append(x);

            }
            csvWriter.flush();
            csvWriter.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addHeader() {
        try {
            FileWriter csvWriter = new FileWriter(COMBINED_CSV_FILE, true);
            String header = "email_hash" + "," + "category" + "," + "filename" + "\n";
            csvWriter.append(header);

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void displayNewCSV() {
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
        }
    }
}