package radixSort;

import java.util.Random;

import homework2.SingleLinkedDataQueue;
import lab1.ArrayBag;

public class RadixSort {

	static SingleLinkedDataQueue<Integer>[] theBukets;

	
	public static void radixSortByIteration(int[] array) {
		@SuppressWarnings("unchecked")
		SingleLinkedDataQueue<Integer>[] theBuket = new SingleLinkedDataQueue[10];
		theBukets = theBuket;
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
						theBukets[0].enqueue(array[index]);
						break;
					case 1: 
						theBukets[1].enqueue(array[index]);
						break;
					case 2: 
						theBukets[2].enqueue(array[index]);
						break;
					case 3: 
						theBukets[3].enqueue(array[index]);
						break;
					case 4: 
						theBukets[4].enqueue(array[index]);
						break;
					case 5: 
						theBukets[5].enqueue(array[index]);
						break;
					case 6: 
						theBukets[6].enqueue(array[index]);
						break;
					case 7: 
						theBukets[7].enqueue(array[index]);
						break;
					case 8: 
						theBukets[8].enqueue(array[index]);
						break;
					case 9: 
						theBukets[9].enqueue(array[index]);
						break;
				}// end switch
			}
			int indexOfTheArray = 0;
			for(int indexOfTheBukets = 0; indexOfTheBukets < 10; indexOfTheBukets++) {
				
				while(!theBukets[indexOfTheBukets].isEmpty()) {
						array[indexOfTheArray] = theBukets[indexOfTheBukets].dequeue();
						indexOfTheArray++;
				}
			}
			
			
		}
	}
	
	private static int determineTheDigits(int[] array) {
		int max = findMax(array);
		String theLength = String.valueOf(max);
		return theLength.length();
	}
	private static int findMax(int[] array) {
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}
	
	public static void radixSortByRecursion(int[] array) {
		@SuppressWarnings("unchecked")
		SingleLinkedDataQueue<Integer>[] theBuket = new SingleLinkedDataQueue[10];
		theBukets = theBuket;
		for(int i = 0; i < theBuket.length; i++) {
			theBuket[i] = new SingleLinkedDataQueue<>();
		}	
		int upperbound = determineTheDigits(array);
		doRadixSort(array, 1, upperbound);
		
	}
	
	private static void doRadixSort(int[] array, int position, int upperbound) {
		if(position <= upperbound) {
			int hashCode = (int) Math.pow(10,position);
			int digit = -1;
			for(int index = 0; index < array.length; index++) {
				digit = array[index] / (hashCode / 10);
				digit = digit % 10;
				switch(digit) {
					case 0: 
						theBukets[0].enqueue(array[index]);
						break;
					case 1: 
						theBukets[1].enqueue(array[index]);
						break;
					case 2: 
						theBukets[2].enqueue(array[index]);
						break;
					case 3: 
						theBukets[3].enqueue(array[index]);
						break;
					case 4: 
						theBukets[4].enqueue(array[index]);
						break;
					case 5: 
						theBukets[5].enqueue(array[index]);
						break;
					case 6: 
						theBukets[6].enqueue(array[index]);
						break;
					case 7: 
						theBukets[7].enqueue(array[index]);
						break;
					case 8: 
						theBukets[8].enqueue(array[index]);
						break;
					case 9: 
						theBukets[9].enqueue(array[index]);
						break;
				}// end switch
			}
			int indexOfTheArray = 0;
			for(int indexOfTheBukets = 0; indexOfTheBukets < 10; indexOfTheBukets++) {
				
				while(!theBukets[indexOfTheBukets].isEmpty()) {
						array[indexOfTheArray] = theBukets[indexOfTheBukets].dequeue();
						indexOfTheArray++;
				}
			}
			
			position++;
			doRadixSort(array, position, upperbound);

		}
		
	}

	public static void main(String[] args) {

		ArrayBag<Integer> a1 = new ArrayBag<>(100000);
		ArrayBag<Integer> a2 = new ArrayBag<>(100000);

		Random r = new Random();
		int[] array =new int[100000];

		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(100000);
			a1.add(array[i]);
			//System.out.println(array[i]);
		}
		
		System.out.println("radixSortByRecursion: ");
		long starttimes = System.nanoTime();
		radixSortByRecursion(array);
		long endtimes = System.nanoTime();
		
		long  b = (endtimes - starttimes) / 1000000;
		System.out.println(b);
		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
			//System.out.println(array[i]);
		}
		boolean pass = true;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				System.out.println("*****Failed");
				pass = false;
				break;
			}
		}
		
		if(a1.equals(a2) && pass) {
			System.out.println("Sorted.");
		}
		
	}
	

}
