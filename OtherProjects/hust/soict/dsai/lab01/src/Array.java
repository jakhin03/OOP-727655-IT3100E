import java.util.*;

public class Array{
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void arraySort(int[] arr){
		for (int i=0; i<arr.length; i++){
			for (int j = 0; j<arr.length; j++){
				if (arr[i] < arr[j]){
					swap(arr,i,j);
				}
			}
		}
	}

	private static int sumArray(int[] arr){
		int sum = 0;
		for (int i=0; i<arr.length; i++){
			sum += arr[i];
		}
		return sum;
	}

	private static double averageArray(int[] arr){
		return (double)sumArray(arr)/(double)arr.length;
	}

	public static void main(String[] args) {
		int n;
		Scanner input = new Scanner(System.in);
		System.out.print("Input n: ");
		n = input.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n; i++){
			System.out.printf("Input array[%d]: ",i);
			arr[i] = input.nextInt();
		}
		arraySort(arr);
		System.out.printf("Sorted array: %s\nSum of array: %d\nAverage of array: %,.2f", Arrays.toString(arr), sumArray(arr), averageArray(arr));
	}
}