import java.util.concurrent.RecursiveAction;

public class MatrixRowSumParallelTask extends RecursiveAction {

    //initialisation of class variables

    private long[][] matrix;
    long[] result;
    private int startIndex, endIndex, threshold;



    //constructor for class
    public MatrixRowSumParallelTask(long[][] matrix,
                                   long[] result,
                                   int threshold,
                                   int first,
                                   int last) {
        this.matrix = matrix;
        this.result  = result;
        this.threshold = threshold;
        this.startIndex = first;
        this.endIndex = last;

    }

    protected void compute() {

        if (endIndex - startIndex < threshold) {
            //do task directly
            matrixRowSum();
        } else {
            //split the task into two subtasks
            int middle = (startIndex + endIndex)/2;

            MatrixRowSumParallelTask t1 = new MatrixRowSumParallelTask(	matrix,
                                                                        result,
                                                                        threshold,
                                                                        startIndex,
                                                                    middle+1 	);

            MatrixRowSumParallelTask t2 = new MatrixRowSumParallelTask(	matrix,
                                                                        result,
                                                                        threshold,
                                                                    middle+1,
                                                                        endIndex 		);

            //invoke tasks and await results
            invokeAll(t1, t2);


        }


    }

    protected void matrixRowSum() {
        for(int i = startIndex; i<endIndex; i++){
            for(int j = 0; j<matrix[0].length; j++){
                result[i] += matrix[i][j];
            }
        }
    }


}