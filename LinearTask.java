import java.util.concurrent.*;
import java.util.*;

class LinearTask extends RecursiveAction{

	int[] array;
	Stack results;
	int searchValue;

	int hi,lo;
	int threshold;

	public LinearTask(int[] array,int searchValue, int lo, int hi, int threshold,  Stack results){
		this.array = array;
		this.searchValue = searchValue;
		this.results = results;
		this.lo = lo;
		this.hi = hi;
		this.threshold = threshold;

	}
	@Override
	public void compute(){
		if (hi - lo < threshold) {
    		for (int i = lo; i < hi; ++i){
    			
    			
    			if(array[i] == searchValue) results.push(i);
     		}
     	}else {
       		int mid = (lo + hi) >>> 1;
       		invokeAll(new LinearTask(array,searchValue, lo, mid,threshold,results),
            new LinearTask(array,searchValue, mid, hi,threshold,results));
     	}
	}

	public String getResultString(){
		String resultString = "Linear Results: ";
		while(!results.empty())
			resultString = resultString + results.pop() + " ";

		return resultString ;
	}
}