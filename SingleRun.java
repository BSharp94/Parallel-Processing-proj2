import java.util.Random;

class SingleRun{
	
	//global timer variable
	static MethodTimer timer;

	public SingleRun(MethodTimer timer,int dataSize){
		
		//set timer
		this.timer = timer;

		//run constant method
		runConstant(dataSize);

		//run linear method
		int randIndex = getRandIndex(dataSize);
		runLinear(dataSize,randIndex);

		//run bubble method
		runBubble(dataSize);

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

		System.out.println("\n====CONSTANT=========");
		System.out.println("Constant Time Search : - " + timer.getTimeString());
		System.out.println("Constant value: array[0] = " + constantResult);

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
		System.out.println("\n====LINEAR========="); 
		System.out.println("Value to search: " + String.valueOf(searchValue) + "\nFound value v[" + String.valueOf(index) + "] = "  + String.valueOf(array[index]));
		System.out.println("Linear - " + timer.getTimeString());

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
		System.out.println("\n====Bubble========="); 
		System.out.println("Bubble - " + timer.getTimeString());
		for(int i = 0; i < dataSize; i++){
			System.out.print(String.valueOf(array[i] + " "));
		}
		System.out.println();
	}
	public static void runMatrix(){

		//Start Timer
		timer.startTimer();

		try{
			Thread.sleep(3000);
		}catch(Exception ex){}
		
		//End Timer
		timer.endTimer();

		//Report 
		System.out.println("Matrix - " + timer.getTimeString());

	}

	public static void main(String args[]){

		//Create Timer
		timer = new MethodTimer();

		SingleRun run = new SingleRun(timer,100);

	}
}