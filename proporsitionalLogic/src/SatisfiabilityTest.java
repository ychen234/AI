import java.io.IOException;
import java.util.ArrayList;

public class SatisfiabilityTest {

	public static void main(String[] args) throws IOException {
		problem1();
		// Problem 2: N-Queen with N=4
		problem2();
		// Problem 3: we first test quinn.cnf
		problem3_1();
		// Problem 3: Then, we test aim-50-1_6-yes1-4.cnf.cnf 
		problem3_2();

	}
	
	public static void problem1() throws IOException{
		//Problem 1:
		System.out.println("Problem 1: ");
		ArrayList<Boolean> output1 = new ArrayList<Boolean>();
		output1 = GSAT.runGSAT(Clause.part3_1, 10, 10);
		if(output1!=null) {
			System.out.println("Problem 1 is satisfiable.");
		} else {
			System.out.println("Problem 1 is not satisfiable. ");
		}
	}
	
	public static void problem2() throws IOException{
		//Problem 2 
			System.out.println("\nProblem 2: N-Queen with N=4");
			int[] knowledgeBase2 = Read.read("nqueens_4.cnf");
			ArrayList<Boolean> output2 = new ArrayList<Boolean>();
			
			// Change max tries and flips here
			output2 = GSAT.runGSAT(knowledgeBase2, 50, 100);
			if(output2!=null) {
				System.out.println("N-Queen with N=4 is satisfiable.");
			}else {
				System.out.println("N-Queen with N=4 is not satisfiable in this test. Please try again.");
			}
	}
	
	public static void problem3_1() throws IOException{
		// Problem 3 -1
			System.out.println("\nProblem 3-1: we first choose quinn.cnf to test");
			int [] knowledgeBase3 = Read.read("quinn.cnf");
			ArrayList<Boolean> output3 = new ArrayList<Boolean>();
			// Change max tries and flips here
			output3 = GSAT.runGSAT(knowledgeBase3, 150, 500);
			if(output3!=null) {
				System.out.println("quinn.cnf is satisfiable.");
			}else {
				System.out.println("quinn.cnf is not satisfiable in this test. Please try again.");
			}
	}
	
	public static void problem3_2() throws IOException {
	// Problem 3 -2
			System.out.println("\nProblem 3-2: Then, we choose aim-50-1_6-yes1-4.cnf to test");
			int [] knowledgeBase4 = Read.read("aim-50-1_6-yes1-4.cnf");
			ArrayList<Boolean> output4 = new ArrayList<Boolean>();
			// Change max tries and flips here
			output4 = GSAT.runGSAT(knowledgeBase4, 500, 1000);
			if(output4!=null) {
				System.out.println("aim-50-1_6-yes1-4.cnf is satisfiable.");
			}else {
				System.out.println("aim-50-1_6-yes1-4.cnf is not satisfiable in this test. Please try again.");
			}
	}

}
