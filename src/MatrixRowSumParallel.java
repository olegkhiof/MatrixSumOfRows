import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class MatrixRowSumParallel {
    private static int N, M;
    private static int threshold;
    private int[][] matrix;


    public MatrixRowSumParallel (Matrix matrix, int threshold){
        this.matrix = matrix.getMatrix();
        this.N = matrix.getN();
        this.M = matrix.getM();
        this.threshold = threshold;
    }

    public static long[] sumRows(int[][] matrix){
        ForkJoinPool pool= ForkJoinPool.commonPool();
        long[] result = new long[N];
        MatrixRowSumParallelTask task = new MatrixRowSumParallelTask(matrix, result, threshold, 0, N);

        pool.invoke(task);
        result = task.result;
        return result;

    } 


}
