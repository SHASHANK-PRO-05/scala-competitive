package JuneCircuits17.DexterplayswithGP;

import java.io.PrintWriter;

/**
 * Created by shanky on 6/16/17.
 */
public class Tester {
    public static void main(String[] args) throws Exception {
        PrintWriter printWriter = new PrintWriter("TestingData.txt");
        printWriter.println("1");
        long prime = 10000000;
        for (int i = 0; i < 1; i++) {
            int n = 100;
            printWriter.println(n);
            for (int j = 0; j < n; j++) {
                printWriter.print((int) (Math.random() * 100) + " ");
            }
            printWriter.println();
        }
        printWriter.flush();
        printWriter.close();
    }
}
