import java.util.concurrent.*;

class MatrixMultTask extends RecursiveAction{

	int[][] matrixA;
	int[][] matrixB;
	int[][] matrixResult;
	int matrixSize;

	int lo, hi,threshold;

	public MatrixMultTask(int[][] matrixA, int[][] matrixB,int[][] matrixResult,int matrixSize, int lo, int hi, int threshold){
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixResult = matrixResult;
		this.matrixSize = matrixSize;
		this.threshold = threshold;
		this.lo = lo;
		this.hi = hi;
	
	}

	@Override
	public void compute(){
		if (hi - lo < threshold) {

			
			matrixMult();
     	}else {
       		int mid = (lo + hi) >>> 1;
       		invokeAll(	new MatrixMultTask(matrixA,matrixB,matrixResult,matrixSize, lo, mid,threshold),
                		new MatrixMultTask(matrixA,matrixB,matrixResult,matrixSize, mid, hi,threshold));
    	}

	}
	public void matrixMult(){
		for(int i = lo; i < hi; i++){
			for(int j = 0; j < matrixSize; j++){
				for(int k = 0; k < matrixSize; k++){
					matrixResult[i][j] += (matrixA[k][j] * matrixB[i][k]);
				}
			}

		}
	}
	public String getResultString(){
		String results = "Matrix Results\n";
		for(int i = 0; i < matrixSize; i++){
			for(int j = 0; j < matrixSize; j++){
				results = results + matrixResult[i][j] + " ";
			}
			results = results + "\n";
		}
		return results;
	}
}