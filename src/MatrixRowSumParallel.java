import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class MatrixRowSumParallel {
    private static int N, M;
    private static int threshold;
    private static int[][] matrix;
    static double parallelTime;


    public MatrixRowSumParallel (Matrix matrix, int threshold){
        this.matrix = matrix.getMatrix();
        this.N = matrix.getN();
        this.M = matrix.getM();
        this.threshold = threshold;
    }

    public static long[] sumRows(int[][] matrix){
        ForkJoinPool pool= new ForkJoinPool(8);
        long[] result = new long[N];
        MatrixRowSumParallelTask task = new MatrixRowSumParallelTask(matrix, result, threshold, 0, N);
        double startTime = System.currentTimeMillis();
        pool.invoke(task);
        double endTime = System.currentTimeMillis();
        parallelTime = endTime - startTime;
        result = task.getResult();
        return result;

    }
    public double getParallelTime(){
        return parallelTime;
    }


}
