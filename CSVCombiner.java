public class CSVCombiner {
    private UserInput userInput;

    // ------------ Constructors-------------------//
    public CSVCombiner(String[] args) {
        userInput = new UserInput(args);
    }

    // ------------ Methods-------------------//

    // Creates the new combined CSV file
    public void combineCSVFiles() {

        String[] args = userInput.getArgs();

        // Creating the header for the new file
        CSVManipulator csvManipulator = new CSVManipulator();
        csvManipulator.addHeader();

        // Creating new CSVManipulator object for each file
        // Writing data from old CSV file to new CSV file
        for (int i = 0; i < args.length; i++) {
            CSVManipulator csvManipulator1 = new CSVManipulator(args[i]);
            csvManipulator1.csvToList();
        }

        // Writing new CSV to terminal
        csvManipulator.displayNewCSV();
    }

}
