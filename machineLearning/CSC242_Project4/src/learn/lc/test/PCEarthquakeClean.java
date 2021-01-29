package learn.lc.test;

import java.io.IOException;

public class PCEarthquakeClean extends PCTest {

    public static void main(String[] args) throws IOException {
        run("learn/lc/examples/earthquake-clean.data.txt", 10000, 0.95);
    }

}

