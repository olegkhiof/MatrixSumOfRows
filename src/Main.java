import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //ignore ripped off https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static String fileName;

    public static void main(String args[]) throws IOException{
        String[] fileNameArray;
        int threshold = 0;
        boolean ok = false;
        double startTime, endTime, serialTime, parallelTime;

        //ascii logo
        System.out.println(decor());
        //Finds all files in Input folder, and then prints to console.
        fileNameArray = folderReader();
        printFileNameArray(folderReader());

        //verifies that userinput matches a file in the Input folder.
        inputVerifier(inputReader(), fileNameArray);

        System.out.println("File: \"" + fileName + "\" is being read... ");
        Matrix matrix = new Matrix(fileName);
        System.out.println(ANSI_GREEN + "Matrix loaded!" + ANSI_RESET);
        System.out.println("Enter threshold (integer): ");
        threshold = Integer.parseInt(inputReader());





        MatrixRowSumSerial serial = new MatrixRowSumSerial(matrix);



        MatrixRowSumParallel parallel = new MatrixRowSumParallel(matrix, threshold);


        startTime = System.currentTimeMillis();
        long[] serialResult = serial.sumRows(matrix.getMatrix());
        endTime = System.currentTimeMillis();
        serialTime = endTime - startTime;
        System.out.println("serial: " + serialTime);

        startTime = System.currentTimeMillis();

        long[] parallelResult = parallel.sumRows(matrix.getMatrix());
        endTime = System.currentTimeMillis();

        parallelTime = endTime - startTime;
        System.out.println("parallel: " + parallelTime);

        System.out.println(Arrays.toString(matrix.getMatrix()[0]) + "\n");
        System.out.println(Arrays.toString(serialResult) + "\n");
        System.out.println(Arrays.toString(parallelResult));







    }


    public static String[] folderReader(){
        File file = new File("src\\Input");
        File[] files = file.listFiles();
        String[] tempFileNameArray = new String[files.length];
        for(int i = 0; i<files.length; i++){
            tempFileNameArray[i] = files[i].getName();
        }
        return tempFileNameArray;
    }

    public static void printFileNameArray(String[] fileArray){
        System.out.println("Please choose a file from the list below:");
        for(int i = 0; i < fileArray.length; i++){
            System.out.println(fileArray[i]);
        }
    }

    public static String inputReader(){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static void inputVerifier(String userInput, String[] fileNameArray) throws FileNotFoundException {

        //verifies that userinput is in the filename array, if not recursively run
        for(int i = 0; i < fileNameArray.length; i++){
            if(fileNameArray[i].equals(userInput)){
                fileName = userInput;
                break;
            }
            else if (i==fileNameArray.length-1){
                System.out.println(ANSI_RED+ "ERROR!\nFilename: \"" + userInput +
                        "\" does not exist in the Input folder. Did you misspell it? \n" + ANSI_RESET);
                inputVerifier(inputReader(), fileNameArray);;
            }
        }
    }



    //ignore this it's just for decoration :)
    public static String decor(){

        String decor = ANSI_GREEN +
                "    __  ___      __       _         ____                   _____                                    \n" +
                        "   /  |/  /___ _/ /______(_)  __   / __ \\____ _      __   / ___/__  ______ ___  ____ ___  ___  _____\n" +
                        "  / /|_/ / __ `/ __/ ___/ / |/_/  / /_/ / __ \\ | /| / /   \\__ \\/ / / / __ `__ \\/ __ `__ \\/ _ \\/ ___/\n" +
                        " / /  / / /_/ / /_/ /  / />  <   / _, _/ /_/ / |/ |/ /   ___/ / /_/ / / / / / / / / / / /  __/ /    \n" +
                        "/_/  /_/\\__,_/\\__/_/  /_/_/|_|  /_/ |_|\\____/|__/|__/   /____/\\__,_/_/ /_/ /_/_/ /_/ /_/\\___/_/     \n" +
                        "                                                                                                    \n" + ANSI_RESET;
        return decor;
    }
}
