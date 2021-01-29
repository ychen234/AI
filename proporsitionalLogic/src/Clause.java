
public class Clause {
	
	// Part2 Problem1:
	// p is true : 1
	// p  => Q: -1 & 2
	public static int[] problem1 = {1,0,-1,2,0};

	// Part2 Problem2: 
	// Set P11 = 1,  P12 = 2,  P13 = 3,  P21 = 4,  P22 = 5,  P31 = 6,  B11 = 7,  B12 = 8,  B21 = 9
	public static int[] wumpus = {1,0,-7,2,4,0,-2,7,0,-4,7,0,-9,1,5,6,0,-1,9,0,-5,9,0,-6,9,0,-8,1,5,3,0,-1,8,0,-5,8,0,-3,8,0};

	//Part2 Problem3:
	// mythical = 1,  mortal = 2,  mammal = 3, horned = 4, magical =5
	// mythical => not mortal: -1 -2  0
	// not mythical => mortal & mammal: 1  2  0  1  3  0 
	// (not mortal V mammal) => horned: 2  4  0  -3  4  0
	// horned => magical: -4  5  0
	public static int[] unicorn = {-1,-2,0,1,2,0,1,3,0,2,4,0,-3,4,0,-4,5,0};
	
	
	//Part3 Problem1:
	// (x1 U x3 U -x4) & (x4) & (x2 U -x3)
	public static int[] part3_1 = {1,3,-4,0,4,0,2,-3,0};
	
	
	public static int[] sum(int [] a, int [] b) {
		int[] sum = new int[a.length+b.length];
		for (int i = 0; i < a.length; i++) {
			sum[i] = a[i];
		}
		for(int i = 0; i<b.length;i++) {
			sum[i+a.length] = b[i];
		}
		return sum;
	}

}
