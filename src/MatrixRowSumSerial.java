

public class MatrixRowSumSerial {
    private static int N;
    private static long[][] matrix;

    public MatrixRowSumSerial(Matrix matrix) {
        this.matrix = matrix.getMatrix();
        this.N = matrix.getN();
    }


    public static long[] sumRows(long[][] matrix){
        long[] sumRowsArray = new long[N];

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                sumRowsArray[i] += matrix[i][j];
            }

        }
        return sumRowsArray;

    }
}
