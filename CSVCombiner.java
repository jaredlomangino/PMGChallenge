public class CSVCombiner {
    private UserInput userinput = new UserInput();

    // ------------ Constructors-------------------//
    CSVCombiner(String[] args) {
        UserInput userInput = new UserInput(args);
        args = userInput.getArgs();
    }

    // ------------ Methods-------------------//

    // Creates the new combined CSV file
    void combineCSVFiles(String[] args) {

        // Ensure all the files are valid files
        userinput.checkValidFile(args);

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
