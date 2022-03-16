import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//setup the "input"
		int n = 500000;
		int[] data = new int[n];
		for (int i = 0; i < data.length; i++) {
			data[i] = data.length - 1 - i;
		}
		
		/*double avgTime = 0;
		
		int counter = 10;
		while (counter-- > 0) {
			long start = System.currentTimeMillis();
			insertionSort(data);
			avgTime
		}*/
		
		long start = System.currentTimeMillis();
		insertionSort(data);
		//selectionSort(data);
		//mergeSortHelper(data, 0, data.length - 1, data);
		System.out.println(System.currentTimeMillis() - start);
	}

	public static void selectionSort(int[] elements) {
	      for (int j = 0; j < elements.length - 1; j++) {
	         int minIndex = j;
	         for (int k = j + 1; k < elements.length; k++) {
	            if (elements[k] < elements[minIndex]) {
	               minIndex = k;
	            }
	         }
	         int temp = elements[j];
	         elements[j] = elements[minIndex];
	         elements[minIndex] = temp;
	      }
	}
	
	public static void insertionSort(int[] elements) {
	      for (int j = 1; j < elements.length; j++) {
	         int temp = elements[j];
	         int possibleIndex = j;
	         while (possibleIndex > 0 && temp < elements[possibleIndex - 1]) {
	            elements[possibleIndex] = elements[possibleIndex - 1];
	            possibleIndex--;
	         }
	         elements[possibleIndex] = temp;
	      }
	}
	
	private static void mergeSortHelper(int[] elements, int from, int to, int[] temp) {
		if (from < to) {
			int middle = (from + to) / 2;
			mergeSortHelper(elements, from, middle, temp);
			mergeSortHelper(elements, middle + 1, to, temp);
			merge(elements, from, middle, to, temp);
		}
	}

	private static void merge(int[] elements, int from, int mid, int to, int[] temp) {
		int i = from;
		int j = mid + 1;
		int k = from;
		
		while (i <= mid && j <= to) {
			if (elements[i] < elements[j]) {
				temp[k] = elements[i];
				i++; 
			} else {
				temp[k] = elements[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			temp[k] = elements[i];
			i++;
			k++;
		}

		while (j <= to) {
			temp[k] = elements[j];
			j++;
			k++;
		}

		for (k = from; k <= to; k++) {
			elements[k] = temp[k];
		}
	}
}
