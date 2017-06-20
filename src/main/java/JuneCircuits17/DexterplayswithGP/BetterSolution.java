package JuneCircuits17.DexterplayswithGP;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class BetterSolution {

    InputStream inputStream = System.in;
    StringBuilder stringBuilder = new StringBuilder();
    PrintWriter printWriter = new PrintWriter(System.out);
    int numChar = 0, curChar = 1;
    byte[] buffer = new byte[1024];

    public <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean isSpacedChar(int c) {
        return c == ' ' || c == '\n' || c == '\t' || c == '\r' || c == -1;
    }


    public int read() throws IOException {
        if (numChar <= curChar) {
            curChar = 0;
            numChar = inputStream.read(buffer);
            if (numChar <= 0) return -1;

        }
        return buffer[curChar++];
    }

    public long readLong() throws IOException, InputMismatchException {
        long num = 0;
        int b = read();
        if (b == -1) throw new IOException();
        while (isSpacedChar(b)) b = read();
        boolean negative = false;
        if (b == '-') {
            b = read();
            negative = true;
        }
        while (!isSpacedChar(b)) {
            if (b > '9' || b < '0') throw new InputMismatchException();
            num = num * 10 + (b - '0');
            b = read();
        }
        return negative ? -num : num;
    }

    public int readInt() throws IOException, InputMismatchException {
        return (int) readLong();
    }

    public int[] readArrayInt(int n) throws IOException, InputMismatchException {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = readInt();
        }
        return array;
    }

    public long[] readArrayLong(int n) throws IOException, InputMismatchException {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = readLong();
        }
        return array;
    }

    public long advancePowMod(long mantisa, long exponent, long mod) {
        long ans = 1;
        while (exponent != 0) {
            if ((exponent & 1) != 0) {
                ans = (ans * mantisa) % mod;
            }
            mantisa = (mantisa * mantisa) % mod;
            exponent = exponent / 2;
        }
        return ans;
    }

    public String readString() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int b = read();
        while (isSpacedChar(b)) b = read();
        while (!isSpacedChar(b)) {
            stringBuilder.append((char) b);
            b = read();
        }
        return stringBuilder.toString();
    }

    public void solve() throws IOException, InputMismatchException {
        int testCases = readInt();
        while (testCases-- != 0) {
            long r = readInt();
            long S = readLong();
            long p = readLong();

            if (r != 1) {
                long m = (long) Math.ceil(Math.sqrt(p - 1));
                long beta = (S * (r - 1)) % p;
                beta = (beta + 1) % p;
                long gama = advancePowMod(advancePowMod(r, p - 2, p), m, p);
                Map<Long, Long> map = new HashMap<>();
                long temp = 1;
                map.put(1L, 0L);
                for (long i = 1; i < m; i++) {
                    temp = (temp * r) % p;
                    map.put(temp, i);
                }
                long ans = -1;
                for (long i = 0; i < m; i++) {
                    if (map.containsKey(beta)) {
                        ans = map.get(beta) + m * i;
                        break;
                    }
                    beta = (beta * gama) % p;
                }
                stringBuilder.append(ans + "\n");
            } else {
                stringBuilder.append(S + "\n");
            }
        }
        //printWriter.println("here");
        //printWriter.println(advancePowMod(3, 3, 7));
        printWriter.println(stringBuilder);
        printWriter.flush();
        printWriter.close();
    }

    public static void main(String[] args) throws IOException, InputMismatchException {
        BetterSolution solution = new BetterSolution();
        solution.solve();
    }
}

