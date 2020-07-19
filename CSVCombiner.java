import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CSVCombiner {
    UserInput userInput = new UserInput();
    String[] args = userInput.getArgs();

    CSVCombiner(String[] args) {
        this.args = args;
    }

    void combineCSVFiles() {
        CSVManipulator csvManipulator = new CSVManipulator();
        csvManipulator.addHeader();

        for (int i = 0; i < args.length; i++) {
            CSVManipulator csvManipulator1 = new CSVManipulator(args[i]);
            csvManipulator1.csvToList();
        }
        csvManipulator.displayNewCSV();
    }

    ////////////////////////////////////////////
    public class UserInput {
        String[] args;

        String[] getArgs() {
            return args;
        }
    }

    ////////////////////////////////////////////
    public class CSVManipulator {
        String fileName;
        List<String> csvList;

        CSVManipulator() {

        }

        CSVManipulator(String fileName) {
            this.fileName = fileName;
        }

        void csvToList() {
            try {
                String row = "";
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                FileWriter csvWriter = new FileWriter("new.csv", true);
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
                FileWriter csvWriter = new FileWriter("new.csv", true);
                String header = "email_hash" + "," + "category" + "," + "filename" + "\n";
                csvWriter.append(header);

                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void displayNewCSV() {
            File file = new File("new.csv");
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

}
