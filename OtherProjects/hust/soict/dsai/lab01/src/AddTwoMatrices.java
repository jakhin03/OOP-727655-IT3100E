import java.util.*;

public class AddTwoMatrices{
	public static void main(String[] args) {
		int m,n;
		Scanner input = new Scanner(System.in);
		System.out.print("Input size mxn of 2 matrices:\nInput m: ");
		m = input.nextInt();
		System.out.print("Input n: ");
		n = input.nextInt();

		int[][] matrix1 = new int[m][n];
		int[][] matrix2 = new int[m][n];
		int[][] matrixSum = new int[m][n];
		System.out.println("Input 1st array:");
		for (int i=0; i<m; i++){
			for (int j=0; j<n; j++){
				System.out.printf("Input matrix1[%d][%d]: ",i,j);
				matrix1[i][j] = input.nextInt();
			}
		}
		System.out.println("Input 1st array:");
		for (int i=0; i<m; i++){
			for (int j=0; j<n; j++){
				System.out.printf("Input matrix2[%d][%d]: ",i,j);
				matrix2[i][j] = input.nextInt();
			}
		}

		System.out.println("Sum of two matrices is: ");
		for (int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				matrixSum[i][j] = matrix1[i][j] + matrix2[i][j];
				System.out.print(matrixSum[i][j]+" ");
			}
			System.out.println();
		}

	}
}