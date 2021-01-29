package learn.lc.test;

import java.io.IOException;

public class PCEarthquakeNoisyDecaying extends PCTest {

	public static void main(String[] args) throws IOException {
		run("learn/lc/examples/earthquake-noisy.data.txt", 10000, 0);
	}

}
