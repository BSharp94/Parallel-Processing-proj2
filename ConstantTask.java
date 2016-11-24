import java.util.concurrent.*;

class ConstantTask extends RecursiveAction{

	int[] array;
	int result;

	public ConstantTask(int[] array){
		this.array = array;
	}

	protected void compute(){
		this.result = array[0];
	}
	public String getResultString(){
		return "Constant Result = " + result;
	}

}