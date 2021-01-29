package learn.lc.test;

import java.io.IOException;
import learn.lc.test.LCTest;

public class LCEarthquakeNoisyDecaying extends LCTest  {
    public static void main(String[] args) throws IOException {
    	run("learn/lc/examples/earthquake-noisy.data.txt", 10000, 0);
    }
}
