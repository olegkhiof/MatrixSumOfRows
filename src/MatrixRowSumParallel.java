import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class MatrixRowSumParallel {
    private static int N;
    private static int threshold;


    public MatrixRowSumParallel (Matrix matrix, int threshold){
        int[][] matrix1 = matrix.getMatrix();
        N = matrix.getN();
        int m = matrix.getM();
        MatrixRowSumParallel.threshold = threshold;
    }

    public static long[] sumRows(int[][] matrix){
        ForkJoinPool pool= ForkJoinPool.commonPool();
        long[] result = new long[N];
        MatrixRowSumParallelTask task = new MatrixRowSumParallelTask(matrix, result, threshold, 0, N);
        task.fork();
        task.join();
        result = task.result;
        return result;

    } 


}
