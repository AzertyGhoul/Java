import java.util.Scanner;
import java.util.ArrayList;

public class Task_1 {

	public static ArrayList<Integer> createArray() {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter array length : ");
		int lengthArray = input.nextInt();
		ArrayList<Integer> array = new ArrayList<>(lengthArray);

		for (int i = 0; i < lengthArray; i++) {
			int numb = (int) (Math.random() * 20);
			array.add(numb);
		}

		input.close();
		return array;
	}

	public static int[][] createMatrix() {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter count of row : ");
		int row = input.nextInt();
		System.out.print("\nEnter count of column : ");
		int column = input.nextInt();

		int[][] matrix = new int[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix[i][j] = (int) (Math.random() * 10);
			}
		}

		input.close();
		return matrix;
	}

	public static void printMatrix(int[][] array, int start, int row) {
		for (int i = start; i < row; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}

			System.out.print("\n");
		}
	}

	public static void task_15() {
		Scanner input = new Scanner(System.in);

		ArrayList<Integer> array = createArray();

		System.out.print("\nEneter beginning of the segment c : ");
		int c = input.nextInt();

		System.out.print("\nEneter ending of the segment d : ");
		int d = input.nextInt();

		System.out.print("\nArray : ");
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i));
		}

		System.out.print("\nSegment of Array : ");
		for (int i = c; i <= d; i++) {
			System.out.print(array.get(i));
		}

		input.close();
	}

	public static void task_3() {
		ArrayList<Integer> array = createArray();
		int max = array.get(0);
		int min = array.get(0);
		int start = 0;
		int end = 0;

		System.out.println("\n" + array);

		for (int i = 1; i < array.size(); i++) {
			if (max <= array.get(i))
				max = array.get(i);
			if (min >= array.get(i))
				min = array.get(i);
		}

		System.out.print("\nMax value : " + max);
		System.out.print("\nMin value : " + min);

		if (array.indexOf(max) < array.indexOf(min)) {
			start = array.indexOf(max);
			end = array.indexOf(min);
		} else {
			start = array.indexOf(min);
			end = array.indexOf(max);
		}

		while (start <= end) {
			array.remove(start);
			end--;
		}

		System.out.print("\n\n" + array);

	}

	public static void task_15_2() {
		Scanner input = new Scanner(System.in);
		int[][] matrix = createMatrix();
		int sum = 0;

		System.out.print("\nMatrix\n");
		printMatrix(matrix, 0, matrix.length);

		System.out.print("\nEnter number : ");
		int number = input.nextInt();

		System.out.print("\nSum of row > number\n");
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[0].length; j++) {
				sum += matrix[i][j];

			}

			if (sum < number) {
				printMatrix(matrix, i, i + 1);
			}

			sum = 0;
		}

		input.close();
	}

	public static void task_3_2() {

	}

	public static void main(String[] args) {
		task_3_2();
	}

}
