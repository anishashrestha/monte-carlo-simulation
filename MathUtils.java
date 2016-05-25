
public class MathUtils {
	
public static double getPercentileInSortedArray(double[] arr, int percentile){
		
		int len = arr.length;
		
		if (percentile == 100)
			return arr[len - 1];
		double index = len*percentile/100.0;
		
		if (index % 1 == 0){ //if number is a whole number
			double index1 = index - 1;
			return (arr[(int)index1]  + arr[(int)index]) / 2  ;
		}
		else
			return arr[(int)index ];
			
	}

}
