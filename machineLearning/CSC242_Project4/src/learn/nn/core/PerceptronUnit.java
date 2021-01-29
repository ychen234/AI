package learn.nn.core;

import learn.math.util.VectorOps;

/**
 * A PerceptronUnit is a Unit that uses a hard threshold
 * activation function.
 */
public class PerceptronUnit extends NeuronUnit {
	
	/**
	 * The activation function for a Perceptron is a hard 0/1 threshold
	 * at z=0. (AIMA Fig 18.7)
	 */
	@Override
	public double activation(double z) {
		// This must be implemented by you
		  if (z >= 0)
	            return 1;
	        else
	            return 0;
	}
	
	/**
	 * Update this unit's weights using the Perceptron learning
	 * rule (AIMA Eq 18.7).
	 * Remember: If there are n input attributes in vector x,
	 * then there are n+1 weights including the bias weight w_0. 
	 */
	@Override
	public void update(double[] x, double y, double alpha) {
		// This must be implemented by you
		 	double h;
	        double[] weights = new double[incomingConnections.size()];
	        for (int i = 0; i < weights.length; i++) {
	            weights[i] = incomingConnections.get(i).weight;
	        }
	        
	        if (x.length == weights.length) {
	            h = activation(VectorOps.dot(weights, x));
	        }else {
	            h = activation(VectorOps.dot1(weights, x));
	        }

	        for (int i = 0; i < incomingConnections.size(); i++) {
	            double wi;
	            if (i == 0) {
	                wi = weights[i] + alpha * (y - h) * 1;
	            }else {
	                wi = weights[i] + alpha * (y - h) * x[i-1];
	            }
	            incomingConnections.get(i).weight = wi;
	        }
	}
}
