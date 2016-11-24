import java.util.Random;
import java.io.PrintWriter;
 

class SingleRun{
	
	//global timer variable
	static MethodTimer timer;
	int arraySize, matrixSize;

	public SingleRun(MethodTimer timer, int arraySize, int matrixSize){
		
		//set timer
		this.timer = timer;

		this.arraySize = arraySize;
		this.matrixSize = matrixSize;

		System.out.println("ArraySize = " + arraySize);
		System.out.println("MatrixSize = " + matrixSize + "x" + matrixSize);

		//run constant method
		runConstant(arraySize);

		//run linear method
		int randIndex = getRandIndex(arraySize);
		runLinear(arraySize,randIndex);

		//run bubble method
		runBubble(arraySize);

		//run matrix Mult
		runMatrix(matrixSize);

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

/*

		int constantResult = array[0];
		try{
			Thread.sleep(1000);
		}catch(Exception ex){ex.printStackTrace();}

*/

	public  void runConstant(int dataSize){

		//generate an array
		int[] array = getRandArray(dataSize);

		//Start Timer
		timer.startTimer();

		//get constant
		int constantResult = array[0];
		
		//End Timer
		timer.endTimer();

		//Report 

		//System.out.println("\n====CONSTANT=========");
		System.out.println("Const. - " + timer.getTimeString());
		//System.out.println("Constant value: array[0] = " + constantResult);

	}


	public void runLinear(int dataSize, int searchIndex){

		//generate an array		
		int[] array = getRandArray(dataSize);
		int searchValue = array[searchIndex];

		//Start Timer
		timer.startTimer();

		//do linear search
		int index = 0;
		for(int i = 0; i < dataSize; i++){
			if(array[i] == searchValue){

				//record index and break
				index = i;
				i = dataSize;

			}
		}

		//End Timer
		timer.endTimer();

		//Report
		//System.out.println("\n====LINEAR========="); 
		System.out.println("Linear - " + timer.getTimeString());
		
		//System.out.println("Value to search: " + String.valueOf(searchValue) + "\nFound value v[" + String.valueOf(index) + "] = "  + String.valueOf(array[index]));
		
	}
	public void runBubble(int dataSize){

		//generate an array
		int[] array = getRandArray(dataSize);

		//Start Timer
		timer.startTimer();

		//run bubble sort
		for(int i = 0; i < dataSize; i++){
			for(int j = 1; j<(dataSize);j++){
				if(array[j-1] > array[j]){
					//swap 
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}

		}

		//End Timer
		timer.endTimer();

		//Report 
		//System.out.println("\n====Bubble========="); 
		System.out.println("Bubble - " + timer.getTimeString());
		/*
		if(print){
			for(int i = 0; i < dataSize; i++){
				System.out.print(String.valueOf(array[i] + " "));
			}
			System.out.println();
		}*/
	}
	/*
	public void printMatrix(int[][] array, int dataSize,String writeFile){
		PrintWriter writer;

		if(!writeFile.equals("")){
			writer =  new PrintWriter(writeFile, "UTF-8");
		}

		for(int i = 0; i < dataSize; i++){
			for(int j = 0; j < dataSize; j++){
				if(writer == null){
					System.out.print(array[i][j] + " ");
				}else{
					writer.print(array[i][j] = "");
				}
			}
			if(writer == null){
				System.out.println();
			}else{
				writer.print(array[i][j] + "");
			}
		}
	}*/
	public void runMatrix(int dataSize){

		//Generate Matricies
		int[][] matrixA = getRandMatrix(dataSize);
		int[][] matrixB = getRandMatrix(dataSize);
		int[][] matrixResult = new int[dataSize][dataSize];

		//Start Timer
		timer.startTimer();

		//Multiply Matrix
		for(int i = 0; i < dataSize; i++){
			for(int j = 0; j < dataSize; j++){
				for(int k = 0; k < dataSize; k++){
					matrixResult[i][j] += matrixA[i][k] * matrixB[k][j];
				}
			}

		}

		
		//End Timer
		timer.endTimer();

		//Report 
		//System.out.println("\n====Matrix Mult========="); 
		System.out.println("Matrix - " + timer.getTimeString());
		
		
			//System.out.println("MatrixA:");
			//printMatrix(matrixA,dataSize,"");
		
			//System.out.println("MatrixB:");
			//printMatrix(matrixB,dataSize);

			//System.out.println("MatrixResult:");
			//printMatrix(matrixResult,dataSize);
		
	}

	public static void main(String args[]){

		
		if(args.length == 2){
			int aSize = Integer.valueOf(args[0]);
			int mSize = Integer.valueOf(args[1]);

			//Create Timer
			timer = new MethodTimer();	
				
			SingleRun run = new SingleRun(timer,aSize, mSize);
		
		}else{
			System.out.println("Please Enter 2 command line arguments. << array size >> << matrix size >>");

		}
	

	}
}

