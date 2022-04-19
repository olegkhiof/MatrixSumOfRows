

public class MatrixRowSumSerial {
    private static int N;

    public MatrixRowSumSerial(Matrix matrix) {
        int[][] matrix1 = matrix.getMatrix();
        N = matrix.getN();
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
