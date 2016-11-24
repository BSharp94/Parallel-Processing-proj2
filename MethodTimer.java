import java.util.Date;

class MethodTimer{
	
	//Timer Variables
	long startTime;
	long endTime;
	float timeDiff;

	public MethodTimer(){
		startTime = 0l;
		endTime = 0l;
		timeDiff = 0l;
	}

	public void startTimer(){

		//record time
		startTime =  System.nanoTime();
	}
	public void endTimer(){

		//record time
		endTime = System.nanoTime();
		
		//calc diff
		timeDiff = (endTime - startTime);
	}
	public String getTimeString(){
		
		return "Time Diff in Seconds: " + timeDiff/1000000000;
	}

}


