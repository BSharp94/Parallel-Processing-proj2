import java.util.Random;
import java.util.concurrent.*; 
import java.util.*;


class ParallelRun{


	MethodTimer timer;
	int np;

	public ParallelRun(int arraySize, int matrixSize, int np){

		this.np = np;

		timer = new MethodTimer();

		//run single
		runConstant(arraySize);

		//run linear
		runLinear(arraySize);

		//run bubble
		runBubble(arraySize);

		//run Matrix Mult
		runMatrixMult(matrixSize);

	}
	public void runConstant(int arraySize){
		int[] array = getRandArray(arraySize);

		timer.startTimer();

		ConstantTask constant = new ConstantTask(array);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(constant);


		timer.endTimer();

		System.out.println("==== Constant Results ====");
		//System.out.println(constant.getResultString());
		System.out.println(timer.getTimeString());
	}
	
	public void runLinear(int arraySize){
		int[] array = getRandArray(arraySize);
		int randIndex = getRandIndex(arraySize); 
		int searchValue = array[randIndex];
		Stack results = new Stack();

		//printArray(array);
		//System.out.println("Rand index " + randIndex + " searchValue = " + searchValue);
		timer.startTimer();

		//try{Thread.sleep(1000);}catch(Exception ex){}

		LinearTask linear = new LinearTask(array, searchValue, 0, arraySize,arraySize/np,results);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(linear);
		timer.endTimer();
		//printArray(array);
		System.out.println("==== Linear Results ====");
		//System.out.println(linear.getResultString());
		System.out.println(timer.getTimeString());

	}
	public void printArray(int[] array){
		for(int i = 0; i < array.length; i++)System.out.print(i + ") " + array[i] + " - ");

		System.out.println("\n");
	}

	public void runBubble(int arraySize){
		int[] array = getRandArray(arraySize);

		//printArray(array);
		timer.startTimer();

		BubbleTask bubble = new BubbleTask(array, 0,arraySize,arraySize/np);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(bubble);
		timer.endTimer();
		//printArray(array);

		System.out.println("=== Bubble Sort ===");
		//System.out.println(bubble.getResultString());
		System.out.println(timer.getTimeString());
	}

	public void runMatrixMult(int matrixSize){
		int[][] matrixA = getRandMatrix(matrixSize);
		int[][] matrixB = getRandMatrix(matrixSize);
		int[][] matrixResult = getRandMatrix(matrixSize);

		for(int i = 0; i < matrixSize; i++){
			for(int j = 0; j < matrixSize; j++){
				matrixResult[i][j] = 0;
			}
		}
		

		timer.startTimer();

		MatrixMultTask matrixTask = new MatrixMultTask(matrixA, matrixB, matrixResult,matrixSize, 0, matrixSize,matrixSize/np);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(matrixTask);

		timer.endTimer();

		System.out.println("=== Matrix Results ====");
		//System.out.println(matrixTask.getResultString());
		System.out.println(timer.getTimeString());


	}

	public int getRandIndex(int dataSize){

 		//Create Random number generator
		Random ran = new Random();

		//return rand index
		return ran.nextInt(dataSize);
 	}

	public int[] getRandArray(int dataSize){
	
		//Create Random number generator
		Random ran = new Random();

		//fill array
		int[] array = new int[dataSize];
		for(int i = 0; i < dataSize; i++){
			array[i] = ran.nextInt(100) + 1;
		}
		return array;
		
	}

	public int[][] getRandMatrix(int dataSize){
	
		//Create Random number generator
		Random ran = new Random();

		//fill Matrix
		int[][] array = new int[dataSize][dataSize];
		for(int i = 0; i < dataSize; i++){
			for(int j = 0; j < dataSize; j++){
				array[i][j] = ran.nextInt(100) + 1;
			}
		}
		return array;
	}

	public static void main(String args[]){
		if(args.length != 4){
			int arraySize = Integer.valueOf(args[0]);
			int matrixSize = Integer.valueOf(args[1]);
			int np = Integer.valueOf(args[2]);
			ParallelRun run = new ParallelRun(arraySize,matrixSize,np);


		}else{
			System.out.println("Error please enter 3 command line arguments");
		}

	}
}