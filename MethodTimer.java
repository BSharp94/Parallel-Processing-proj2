

class MethodTimer{
	
	//Timer Variables
	float startTime;
	float endTime;
	float timeDiff;

	public MethodTimer(){
		startTime = 0.0f;
		endTime = 0.0f;
		timeDiff = 0.0f;
	}

	public void startTimer(){

		//record time
		startTime = System.currentTimeMillis();
	}
	public void endTimer(){

		//record time
		endTime = System.currentTimeMillis();
		
		//calc diff
		timeDiff = endTime - startTime;
	}
	public String getTimeString(){
		
		return "Time Diff in Millis: " + String.valueOf(timeDiff);
	}

}


