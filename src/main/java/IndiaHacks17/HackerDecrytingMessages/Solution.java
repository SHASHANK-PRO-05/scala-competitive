package IndiaHacks17.HackerDecrytingMessages;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class Solution {

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

    public void solve() throws IOException, InputMismatchException {
        int n = readInt();
        int q = readInt();
        int[] arr = readArrayInt(n);
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] checkPrimes = new boolean[1998];
        for (int i = 2; i < 1998; i++) {
            if (!checkPrimes[i]) {
                primes.add(i);
                int j = i * i;
                while (j > 0 && j < 1998) {
                    checkPrimes[j] = true;
                    j = j + i;
                }
            }
        }
        boolean[] yesOrNo = new boolean[1000001];
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                long temp1 = (long) primes.get(i) * (long) primes.get(j);
                if (temp1 < 1000001) {
                    yesOrNo[(int) temp1] = true;
                    temp.add((int) temp1);
                    //System.out.println(temp1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < temp.size() && (long) temp.get(j) * arr[i] < 1000001; j++) {
                long temp1 = temp.get(j) * arr[i];
                while (temp1 < 1000001) {
                    yesOrNo[(int) temp1] = true;
                    temp1 *= arr[i];
                }
            }
        }
        while (q-- != 0) {
            int x = readInt();
            if (yesOrNo[x]) {
                printWriter.println("YES");
            } else {
                printWriter.println("NO");
            }
        }
        printWriter.flush();
        printWriter.close();
    }

    public static void main(String[] args) throws IOException, InputMismatchException {
        Solution solution = new Solution();
        solution.solve();

    }
}
