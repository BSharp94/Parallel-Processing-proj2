

class test{

	public static void main(String args[]){
	try{
		MethodTimer timer = new MethodTimer();
		timer.startTimer();
		Thread.sleep(30000);
		timer.endTimer();
		System.out.println(timer.getTimeString());
	}catch(Exception ex){ex.printStackTrace();}

	}
}
