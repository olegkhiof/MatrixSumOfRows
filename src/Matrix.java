import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private int m, n;
    private int[][] matrix;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Matrix(String inputFile) throws FileNotFoundException {
        readFromFile(inputFile);
    }

    public void readFromFile(String fileName) throws FileNotFoundException {
        File matrixFile = new File("src\\Input\\" + fileName);

        //ripped from MatrixMatrixMul
        Scanner scanner1 = new Scanner(matrixFile);
        Scanner scanner2 = new Scanner(matrixFile);
        Scanner scanner3 = new Scanner(matrixFile);

        scanner1.nextLine();	// Skips first line
        scanner2.nextLine();
        scanner3.nextLine();

        int Rows = 0;
        int Columns;
        int Count = 0;
        try {
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        while(scanner1.hasNextLine()){ // Find rows
            scanner1.nextLine();
            Rows++;
        }
        while(scanner2.hasNextInt()){ // Find elements
            scanner2.nextInt();
            Count++;
        }

        Columns = Count/Rows;  // Calculate columns

        int[][] k = new int[Rows][Columns];
        // Creating matrix
        for (int i = 0; i < Rows; i++)
            for(int j = 0; j < Columns; j++) {
                k[i][j] = scanner3.nextInt();
            }
        n = Rows;
        m = Columns;
        matrix = k;
    }

    public void writeToFile(String fileName){

    }

    public void printToConsole(){
        for(int i= 0; i < n; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    //setters
    public void setM(int m) {
        m = m;
    }

    public void setN(int n) {
        n = n;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    //getters
    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public int[][] getMatrix() {
        return matrix;
    }

}
