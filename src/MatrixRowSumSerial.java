

public class MatrixRowSumSerial {
    private static int N;
    private static int[][] matrix;

    public MatrixRowSumSerial(Matrix matrix) {
        this.matrix = matrix.getMatrix();
        this.N = matrix.getN();
    }


    public static long[] sumRows(int[][] matrix){
        long[] sumRowsArray = new long[N];

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                sumRowsArray[i] += matrix[i][j];
            }
        }
        return sumRowsArray;
    }
}
