import java.util.concurrent.*;
import java.util.*;

class BubbleTask extends RecursiveAction{

	int[] array;
	int hi,lo;
	int threshold;

	public BubbleTask(int[] array,int lo, int hi, int threshold){
		this.array = array;
		this.lo = lo;
		this.hi = hi;
		this.threshold = threshold;



	}
	public void compute(){
		if (hi - lo < threshold) {
    		for (int i = lo; i < hi; ++i){
				bubblesort();    			
     		}
     	}else {
       		int mid = (lo + hi) >>> 1;
       		invokeAll(new BubbleTask(array, lo, mid,threshold),
            new BubbleTask(array, mid, hi,threshold));
     	}

	}
	public void bubblesort(){
		int temp = 0;
		for(int i = lo; i < hi; i++){
			for(int j = lo + 1; j < (hi); j++){

					if(array[j-1] > array[j]){
						temp = array[j-1];
						array[j-1] = array[j];
						array[j] = temp;
					}

			}
		}
	}
	public String getResultString(){
		String resultString = "Bubble Sort Results: ";
		for(int i = 0; i < array.length; i++){
			resultString = resultString + array[i] + " ";
		}
		return resultString;
	}
}