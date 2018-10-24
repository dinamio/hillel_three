package lab_1;

public class MaxElemArray {
	
	public static void main(String[] args) {
		   
		   int[] myArray = {1, 7, 12, 10, 4};
		   int maxValue = myArray[0];
		   
		   for (int i = 1; i < myArray.length; i++) {
		        if (myArray[i] > maxValue) {
		        	maxValue = myArray[i];
		        }
		   }
		   System.out.println("Максимальное значение в массиве: " + maxValue);
	}
}

