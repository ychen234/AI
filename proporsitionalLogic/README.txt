CSC 242 Project2

Collaborators (NetID):
	Yaozhong Huang (yhuang94)
	Qianqian Gu (qgu3)
	Yihe Chen (ychen234)

We use Read.java to build a class for converting DIMACS CNF file to set of integers. This is mainly used for reading CNF files in part3.

Part1: 
we represent clauses as sets of integers in the class Clause.java, where the number i means that xi is in the clause, and the number −i means that ¬xi is in the clause. 

Part2: 
Part 2 has been done in ModelChecking.java and Entailment.java. 
We implement TT_Entail algorithm in the class Entailment.java

To check part 2, run ModelChecking.java.

Part3: 
Part 3 has been done in SatisfiabilityTest.java. 
We implement the GSAT algorithm in the class GSAT.java using the local search approach.

To check part 3, run SatisfiabilityTest.java.
We test quinn.cnf and aim-50-1_6-yes1-4.cnf for problem 3.
For problem 1, problem 2, problem 3-1 (quinn.cnf), our program can always quickly and successfully find the solution.
For problem 3-2 (aim-50-1_6-yes1-4.cnf), because we did not try a large number of max_flips and max_tries, we didn’t get a solution for this one. However, it is theoretically possible and to find a solution, it takes many tries and a lot of time to get the result.

The default maxFlips and maxTries for problem 1 is {10 , 10}
The default maxFlips and maxTries for problem 2 is {50 , 100}
The default maxFlips and maxTries for problem 3-1 is {150 , 500}
The default maxFlips and maxTries for problem 3-3 is {500 , 1000}

Clause.java: represents clauses
Read.java: read DIMACS CNF files
Entailment.java: implements TT_Entail
ModelChecking.java: contains main method for part 2
GSAT.java: implements GSAT
SatisfiabilityTest.java: contain main method for part 3
