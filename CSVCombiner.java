

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
}
