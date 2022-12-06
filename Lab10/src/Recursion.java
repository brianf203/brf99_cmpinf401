public class Recursion {

	public static void main(String[] args) {
		
		int result = sumOfDigits(234);
		System.out.println(result);
		
		int a[] = {1, 2, 3, 4, 5};
		printArrayElements(a, 0);
		
		int a1[] = {1, 2, 3};
		printCombos(a1, "", 0, 2);
		
		int a2[] = {2, 3, 7, 8, 9};
		printCombos(a2, "", 0, 3);

	}
	
	public static int sumOfDigits(int x) {
		
		if(x < 0) {
			x = x * -1;
		}
		
		if(x == 0) {
			return 0;
		}
		
		return (x % 10 + sumOfDigits(x / 10));
		
	}
	
	public static void printArrayElements(int a[], int index) {
		
		if(index != a.length) {
			System.out.println(a[index]);
			printArrayElements(a, index + 1);
		}
		
	}
	
	public static void printCombos(int[] a, String out, int startIndex, int k) {
		
		if(k == 0) {
			System.out.println("{" + out + " }");
			return;
		}
		
		if(!(startIndex > a.length - 1)) {
			printCombos(a, out + " " + a[startIndex], startIndex + 1, k - 1);
			printCombos(a, out, startIndex + 1, k);
		}
				
	}

}