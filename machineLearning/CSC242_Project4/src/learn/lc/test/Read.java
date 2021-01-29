package learn.lc.test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import learn.lc.core.Example;

public class Read {
	public static List<Example> read(String filename) throws IOException {
        Vector<Double> values = new Vector<Double>();
        boolean isfinished = false;
        List<Example> examples = new ArrayList<Example>();
        FileReader r = new FileReader(new File(filename));
        StreamTokenizer st = new StreamTokenizer(r);
        st.eolIsSignificant(true);
        while (!isfinished) {
            int token = st.nextToken();
            switch (token) {
	            case StreamTokenizer.TT_NUMBER:
	                values.add(st.nval);
	                break;
	            case StreamTokenizer.TT_WORD:
	                if (!st.sval.equals(",")) {
	                    throw new IOException("bad word token: " + st.sval);
	                }
	                break;
	            case StreamTokenizer.TT_EOF:
	                    isfinished = true;
	                    break;
                case StreamTokenizer.TT_EOL:
                    int nvalues = values.size();
                    if (!examples.isEmpty() && nvalues != examples.get(0).inputs.length) {
                        throw new IOException("example length mismatch: " + values.toString());
                    }
                    Example example = new Example(nvalues);
                    example.inputs[0] = 1.0;
                    for (int i=1; i < values.size(); i++) {
                        example.inputs[i] = values.get(i-1);
                    }
                    example.output = values.lastElement();
                    examples.add(example);
                    values.clear();
                    break;
            }
        }
        r.close();
        return examples;
    }
}
