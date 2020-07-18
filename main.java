import java.io.*;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            String fileName = args[i];
            String row = "";

            csvToList(fileName, row);
        }

    }

    public static void csvToList(String fileName, String row) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            FileWriter csvWriter = new FileWriter("new.csv", true);
            String headerLine = br.readLine();

            while ((row = br.readLine()) != null) {
                List<String> result = Arrays.asList(row.split("\\s*,\\s*"));

                for (int j = 0; j < result.size() - 1; j++) {
                    csvWriter.append(String.join(",", result));
                    csvWriter.append(",");
                    csvWriter.append(fileName);
                    csvWriter.append("\n");
                }
                System.out.println(result);

            }
            csvWriter.flush();
            csvWriter.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
