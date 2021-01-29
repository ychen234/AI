
import java.util.ArrayList;
import java.util.Collections;

public class Entailment { 
	
	static boolean TT_Check_All(int[]knowledgebase, int [] query, ArrayList<Integer> variables, ArrayList<Boolean> model) {
		
		if (variables.size()==0) {
			if(PL_True(knowledgebase,model)==true) {
				return PL_True(query,model);
			} else {
				return true; 
			}
		}else {
			ArrayList <Integer> rest = new ArrayList<Integer>();
			for (int i = 1; i< variables.size();i++) {
				rest.add(variables.get(i));
			}
			
			//Make two model representing: model U {P=true}  and model U {P=false}
			ArrayList <Boolean> model1 = new ArrayList<Boolean>();
			ArrayList <Boolean> model2 = new ArrayList<Boolean>();
			for (int i = 0; i < model.size(); i++) {
				model1.add(null);
				model2.add(null);
			}
			
			for (int i = 0; i < model.size(); i++) {
				model1.set(i, model.get(i));
				model2.set(i, model.get(i));
			}
			
			for (int i =1; i<model.size();i++) {
				if (model1.get(i)==null && model2.get(i)==null) {
					model1.set(i, Boolean.TRUE);
					model2.set(i, Boolean.FALSE);
					break;
				}
			}
			return (TT_Check_All(knowledgebase, query, rest, model1) && TT_Check_All(knowledgebase, query, rest, model2));
		}   
	}

	
	public static boolean TT_Entails (int[] knowledgebase, int[]query) {
		ArrayList <Integer> variable = new ArrayList<Integer>();
		
		for(int i = 0; i<knowledgebase.length;i++) {
			if(variable.contains(knowledgebase[i])) {
				continue;
			}
			if(variable.contains(Math.abs(knowledgebase[i]))) {
				continue;
			}
			variable.add(Math.abs(knowledgebase[i]));
		}
		
		for(int i = 0; i<query.length;i++) {
			if(variable.contains(query[i])) {
				continue;
			}
			variable.add(query[i]);
		}
		
		Collections.sort(variable);
		variable.remove(0);//remove 0 (conjunction symbol) from the array.

		ArrayList <Boolean> model = new ArrayList<Boolean>();
		for (int i = 0; i<= variable.size(); i++) {
			model.add(null);
		}
		
		return TT_Check_All(knowledgebase, query, variable, model);
		
	}
	
	public static boolean PL_True(int[]clauses, ArrayList<Boolean>model) { 
		// method for checking if all the clauses are true
		
		int numberOfOr =0 ; 
		for (int i=0; i< clauses.length;i++) {
			if(clauses[i]!=0) {
				numberOfOr++; 		
			}else {
				int numberOfTrues = 0;
				for(int j = i-numberOfOr; j<i;j++) { 
					// Since they are connected by disjuncts, we only need one of them to be true;
					int index = Math.abs(clauses[j]);
					if(clauses[j]<0) { 
						// if the symbol is negative
						if(model.get(index)==Boolean.FALSE) {
							numberOfTrues++;
							break;
						}
					}else {
						if(model.get(index)==Boolean.TRUE) {
							numberOfTrues++;
							break;
						}
					}
				
				}
				if(numberOfTrues==0) {
					return false;
				}
				numberOfOr=0;
			}
		}
		return true;
	}
	

}
