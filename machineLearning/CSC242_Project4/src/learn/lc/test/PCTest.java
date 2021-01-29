package learn.lc.test;
import java.io.IOException;
import java.util.List;

import learn.lc.core.DecayingLearningRateSchedule;
import learn.lc.core.Example;
import learn.lc.core.PerceptronClassifier;

public class PCTest {
    public static void main(String[] argv) throws IOException {
        if (argv.length < 3) {
            System.out.println("Wrong input!");
            System.exit(-1);
        }
        String filename = argv[0];
        int iterations = Integer.parseInt(argv[1]);
        double learningrate = Double.parseDouble(argv[2]);
        run(filename, iterations, learningrate);
    }
 
    public static void run(String filename, int iterations, double learningrate) throws IOException {
        System.out.println("filename: " + filename);
        System.out.println("Number of steps: " + iterations);
        System.out.println("Fixed learning rate: " + learningrate);
        System.out.println();
        List<Example> examples = Read.read(filename);
        int ninputs = examples.get(0).inputs.length;

        System.out.println("Step \t Accuracy");
        PerceptronClassifier classifier = new PerceptronClassifier(ninputs) {
            @Override
            public void trainingReport(List<Example> examples, int step, int nsteps) {
                double accuracy = accuracy(examples);
                System.out.println(step + "\t" + accuracy);
            }
        };
        if (learningrate > 0) {
            classifier.train(examples, iterations, learningrate);
        } else {
            classifier.train(examples, 100000, new DecayingLearningRateSchedule());
        }

        System.out.println();

        for (int i = 0; i < classifier.weights.length; i++) {
            System.out.println("w" + i + ": " + classifier.weights[i]);
        }
        System.out.println();
    }

}
