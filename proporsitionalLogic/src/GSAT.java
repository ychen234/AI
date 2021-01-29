import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GSAT {	
	
	public static int hillClimbing(int [] clauses, ArrayList<Boolean> model, int variable) { //return the index 
		ArrayList<Boolean> temp = new ArrayList<Boolean>();
		for( int i = 0; i<model.size(); i++) {
			temp.add(model.get(i));
		}
		
		int numberOfOr =0 ;

		temp.set(variable, opposite(temp.get(variable)));
	
		int numberOfTrues = 0;
		for (int i=0; i< clauses.length;i++) {
			if(clauses[i]!=0) {
				numberOfOr++;	
			}else {
				for(int j = i-numberOfOr; j<i;j++) { 
					int index = Math.abs(clauses[j]);
					if(clauses[j]<0) { 
						// if the variable is negative
						if(temp.get(index)==Boolean.FALSE) {
							numberOfTrues++;
							break;
						}
					}else {
						if(temp.get(index)==Boolean.TRUE) {
							numberOfTrues++;
							break;		
						}
					}
				
				}
				numberOfOr=0; // move into next conjunction 
			}
		}
		return numberOfTrues;
	}
	
	public static ArrayList<Boolean> runGSAT(int[] clauses,int maxFlips, int maxTries) {
		Random r = new Random();
		ArrayList <Integer> variables = new ArrayList<Integer>();
		variables = calcVariables(clauses);
		ArrayList <Boolean> model = new ArrayList<Boolean>();
		for (int i = 0; i<= variables.size(); i++) {
			model.add(null);
		}
		for(int i = 0; i < maxTries; i++) {
			for(int j = 1; j<model.size(); j++) {
				model.set(j, r.nextBoolean()); 
			}
			for(int k =1; k<maxFlips; k++) {
				if(Entailment.PL_True(clauses, model)==true) {
					System.out.println("This set of clauses is satisfiable and this is the truth table: ");
					System.out.println(model);
					return model;
				}
				
				int [] temp = new int[model.size()];
				temp[0] = 0;
				for (int j =1; j<model.size();j++) {
					temp[j] = hillClimbing(clauses,model,j);
				}
				int max = temp[0];
				int index = 0;

				for (int c = 0; c < temp.length; c++) {
					if (max <= temp[c]) {
							max = temp[c];
							index = c;	
					}
				}
				model.set(index, opposite(model.get(index)));
			}		
		}
		
		System.out.println("Cannot find an assignment that makes all the clauses true");
		return null;
	}
	
	public static boolean opposite(Boolean b) {
		if (b == true) {
			return false;
		}else {
			return true;
		}
	}
	
	public static ArrayList< Integer> calcVariables(int [] knowledgeBase){
		// calculate how many variables in the clauses (exclude 0--symbol of conjunction )
		ArrayList <Integer> variables = new ArrayList<Integer>();
		for(int i = 0; i<knowledgeBase.length;i++) {
			if(variables.contains(knowledgeBase[i])) {
				continue;
			}
			if(variables.contains(Math.abs(knowledgeBase[i]))) {
				continue;
			}
			variables.add(Math.abs(knowledgeBase[i]));
		}
		Collections.sort(variables);
		variables.remove(0);
		return variables;
	}

	

}


