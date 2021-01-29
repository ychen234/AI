package learn.lc.test;

import java.io.IOException;
import learn.lc.test.LCTest;

public class LCEarthquakeClean extends LCTest  {
    public static void main(String[] args) throws IOException {
        run("learn/lc/examples/earthquake-clean.data.txt", 10000, 0.95);
    }
}
