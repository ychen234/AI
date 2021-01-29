package learn.lc.test;

import java.io.IOException;

public class PCHouse extends PCTest {
	public static void main(String[] args) throws IOException {
		run("learn/lc/examples/house-votes-84.data.num.txt", 10000, 0.95);
	}

}