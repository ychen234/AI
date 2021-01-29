public class ModelChecking {

	public static void main(String[] args) {
		// part2 problem1
		problem1();
		// part2 problem2
		problem2();
		// part2 problem3
		problem3();	
		
	}
	
	public static void problem1() {
		// problem1
			int [] knowledgeBase1 = Clause.problem1;
			int[] q1 = {2,0};
			System.out.println("Problem 1: ");
			if(Entailment.TT_Entails(knowledgeBase1, q1)==false) {
					System.out.println("{ P, P=>Q } does not entail Q");
				}else {  
					System.out.println("{ P, P=>Q } entails Q");
			}
						
	}
	
	public static void problem2() {
		// problem 2
			System.out.println("\nProblem 2: ");
			int [] knowledgeBase2_1 = Clause.wumpus;
				
			System.out.println("\nR4: Not B11");
			// B11 = 7
			int [] q2_1 = {-7,0};
			int [] knowledgeBase2_2 = Clause.sum(knowledgeBase2_1, q2_1);
				
			// Check -P12
			int [] q2_2 = {-2,0};
			// Check -P21
			int [] q2_3 = {-4,0};
				
			if(Entailment.TT_Entails(knowledgeBase2_2, q2_2)==false) {
				System.out.println("It doesn't entail -P12.");
				if(Entailment.TT_Entails(knowledgeBase2_2, q2_3)==false) {
					System.out.println("It doesn't entail -P21.");
				}else {
					System.out.println("It entails -P21.");
				}
			}else if(Entailment.TT_Entails(knowledgeBase2_2, q2_3)==false){
				System.out.println("It doesn't entail -P21.");
				System.out.println("It entails -P12.");
			}else {	
				System.out.println("It entails -P12 and -P21.");
			}
			
			// Check P22&-P22
			int [] q2_4 = {5,0,-5,0};
			if(Entailment.TT_Entails(knowledgeBase2_2, q2_4)==false) {
				System.out.println("It doesn't entail P22 or -P22.");
			}else {
				System.out.println("It entails P22 or -P22");
			}
			
			// R5
			System.out.println("\nR5: B21 ");
			// B21 = 9
			int [] q2_5 = {9,0};
			int [] knowledgeBase2_3 = Clause.sum(knowledgeBase2_2, q2_5);
			//Check P22 U P31
			int [] q2_6 = {5,6,0};
			if(Entailment.TT_Entails(knowledgeBase2_3, q2_6)) {
				System.out.println("It doesn't entail P22 or P31");
			}else {
				System.out.println("It entails P22 or P31");
			}
			
			// Check P22 / not P22 / P31 / not P31
			// P22 = 5, P31 = 6
			int [] q2_7 = {5,0};
			int [] q2_8 = {-5,0};
			int [] q2_9 = {6,0};
			int [] q2_10 = {-6,0};
			if(Entailment.TT_Entails(knowledgeBase2_3, q2_7)==false) {
				System.out.println("It doesn't entail P22.");
			}else {
				System.out.println("It entails P22.");
			}
			
			if(Entailment.TT_Entails(knowledgeBase2_3, q2_8)==false) {
				System.out.println("It doesn't entail -P22.");
			}else {
				System.out.println("It entails -P22.");
			}
			
			if(Entailment.TT_Entails(knowledgeBase2_3, q2_9)==false) {
				System.out.println("It doesn't entail P31.");
			}else {
				System.out.println("It entails P31.");
			}
			
			if(Entailment.TT_Entails(knowledgeBase2_3, q2_10)==false) {
				System.out.println("It doesn't entail -P31.");
			}else {
				System.out.println("It entails -P31. ");
			}
			
			// R6
			System.out.println("\nR6: -B12");
			// B12 = 8
			int [] q2_11 = {-8,0};
			int [] knowledgeBase2_4 = Clause.sum(knowledgeBase2_3, q2_11);
			
			// Check -P22 & P31
			int [] q2_12 = {-5,0,6,0};
			if(Entailment.TT_Entails(knowledgeBase2_4, q2_12)==false) {
				System.out.println("It doesn't entail -P22 and P31. ");
			}else {
				System.out.println("It entails -P22 and P31. ");
			}
			
	}
	
	public static void problem3() {
		// Problem 3
			System.out.println("\nProblem 3: ");
			int [] unicorn = Clause.unicorn;
			
			// question a: 
			int [] a = {1,0};
			if(Entailment.TT_Entails(unicorn, a)==false) {
				System.out.println("a): We cannot prove that unicorn is mythical");
			}else {
				System.out.println("a): We can prove that unicorn is mythical");
			}
			
			//question b:
			int [] b = {5,0};
			if(Entailment.TT_Entails(unicorn, b)==false) {
				System.out.println("b): We cannot prove that unicorn is magical");
			}else {
				System.out.println("b): We can prove that unicorn is magical");
			}
			
			//question c:
			int [] c = {4,0};
			if(Entailment.TT_Entails(unicorn, c)==false) {
				System.out.println("c): We cannot prove that unicorn is horned");
			}else {
				System.out.println("c): We can prove that unicorn is horned");
			}
	}
}