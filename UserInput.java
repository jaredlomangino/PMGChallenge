import java.io.File;

//Gets user input from command line
//Will get passed to CSVCombiner Class

public class UserInput {
    private String[] args;

    // ------------ Constructors -------------------//

    UserInput() {

    }

    UserInput(String[] args) {
        this.args = args;
        checkValidFile();
    }

    // ------------ Methods-------------------//

    String[] getArgs() {
        return args;
    }

    // Making sure that the user input is valid
    void checkValidFile() {
        for (int i = 0; i < args.length; i++) {
            File file = new File(args[i]);
            if (!file.isFile()) {
                System.out.println(args[i] + " is not a file. Please specify a proper file and path.");
                System.exit(0);
            }
        }

    }
}