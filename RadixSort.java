package radixSort;

import java.util.Random;

import homework2.SingleLinkedDataQueue;
import lab1.ArrayBag;

public class RadixSort {

	static SingleLinkedDataQueue<Integer>[] theBuckets;

	
	/**
	 * a function that uses iterative radix sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public static void radixSortByIteration(int[] array) {
		@SuppressWarnings("unchecked")
		SingleLinkedDataQueue<Integer>[] theBuket = new SingleLinkedDataQueue[10];
		theBuckets = theBuket;
		for(int i = 0; i < theBuket.length; i++) {
			theBuket[i] = new SingleLinkedDataQueue<>();
		}
		for(int position = 1; position <= determineTheDigits(array); position++) {
			int hashCode = (int) Math.pow(10,position);
			int digit = -1;
			for(int index = 0; index < array.length; index++) {
				digit = array[index] / (hashCode / 10);
				digit = digit % 10;
				switch(digit) {
					case 0: 
						theBuckets[0].enqueue(array[index]);
						break;
					case 1: 
						theBuckets[1].enqueue(array[index]);
						break;
					case 2: 
						theBuckets[2].enqueue(array[index]);
						break;
					case 3: 
						theBuckets[3].enqueue(array[index]);
						break;
					case 4: 
						theBuckets[4].enqueue(array[index]);
						break;
					case 5: 
						theBuckets[5].enqueue(array[index]);
						break;
					case 6: 
						theBuckets[6].enqueue(array[index]);
						break;
					case 7: 
						theBuckets[7].enqueue(array[index]);
						break;
					case 8: 
						theBuckets[8].enqueue(array[index]);
						break;
					case 9: 
						theBuckets[9].enqueue(array[index]);
						break;
				}// end switch
			}
			int indexOfTheArray = 0;
			for(int indexOfTheBukets = 0; indexOfTheBukets < 10; indexOfTheBukets++) {
				
				while(!theBuckets[indexOfTheBukets].isEmpty()) {
						array[indexOfTheArray] = theBuckets[indexOfTheBukets].dequeue();
						indexOfTheArray++;
				}
			}
			
		}
	}// end determineTheDigits
	
	/**
	 * a function finds the the number of digits that the largest number has
	 * @param array the target array
	 * @return the number of digits that the largest number has
	 */
	private static int determineTheDigits(int[] array) {
		int max = findMax(array);
		String theLength = String.valueOf(max);
		return theLength.length();
	}// end determineTheDigits
	
	
	/**
	 *  a function finds the largest number in an array
	 * @param array the target array
	 * @return The largest number.
	 */
	private static int findMax(int[] array) {
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}//end findMax
	
	/**
	 * a function that uses iterative radix sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public static void radixSortByRecursion(int[] array) {
		@SuppressWarnings("unchecked")
		SingleLinkedDataQueue<Integer>[] theBuket = new SingleLinkedDataQueue[10];
		theBuckets = theBuket;
		for(int i = 0; i < theBuket.length; i++) {
			theBuket[i] = new SingleLinkedDataQueue<>();
		}	
		int upperbound = determineTheDigits(array);
		doRadixSort(array, 1, upperbound);
		
	}// end radixSortByRecursion
	
	/**
	 * a function that sorts entries based on decimal positions
	 * @param array the target array
	 * @param position the decimal position
	 * @param upperbound the highest decimal position
	 */
	private static void doRadixSort(int[] array, int position, int upperbound) {
		if(position <= upperbound) {
			int hashCode = (int) Math.pow(10,position);
			int digit = -1;
			for(int index = 0; index < array.length; index++) {
				digit = array[index] / (hashCode / 10);
				digit = digit % 10;
				switch(digit) {
					case 0: 
						theBuckets[0].enqueue(array[index]);
						break;
					case 1: 
						theBuckets[1].enqueue(array[index]);
						break;
					case 2: 
						theBuckets[2].enqueue(array[index]);
						break;
					case 3: 
						theBuckets[3].enqueue(array[index]);
						break;
					case 4: 
						theBuckets[4].enqueue(array[index]);
						break;
					case 5: 
						theBuckets[5].enqueue(array[index]);
						break;
					case 6: 
						theBuckets[6].enqueue(array[index]);
						break;
					case 7: 
						theBuckets[7].enqueue(array[index]);
						break;
					case 8: 
						theBuckets[8].enqueue(array[index]);
						break;
					case 9: 
						theBuckets[9].enqueue(array[index]);
						break;
				}// end switch
			}
			int indexOfTheArray = 0;
			for(int indexOfTheBukets = 0; indexOfTheBukets < 10; indexOfTheBukets++) {
				
				while(!theBuckets[indexOfTheBukets].isEmpty()) {
						array[indexOfTheArray] = theBuckets[indexOfTheBukets].dequeue();
						indexOfTheArray++;
				}
			}
			
			position++;
			doRadixSort(array, position, upperbound);

		}
		
	}// End doRadixSort

	public static void main(String[] args) {

		ArrayBag<Integer> a1 = new ArrayBag<>(10);
		ArrayBag<Integer> a2 = new ArrayBag<>(10);

		Random r = new Random();
		int[] array =new int[10];

		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(10);
			a1.add(array[i]);
			//System.out.println(array[i]);
		}
		
		
		
		System.out.println("radixSortByRecursion: ");
		radixSortByRecursion(array);

		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
			//System.out.println(array[i]);
		}

		
	}
	

}
