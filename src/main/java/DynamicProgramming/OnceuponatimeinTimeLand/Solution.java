package DynamicProgramming.OnceuponatimeinTimeLand;


import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

    InputStream inputStream = System.in;
    StringBuilder stringBuilder = new StringBuilder();
    int numChar = 0, curChar = 0;
    byte[] buffer = new byte[1024];

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

    public void solve() throws IOException, InputMismatchException {
        int testCases = readInt();
        while (testCases-- != 0) {
            int n = readInt();
            int k = readInt();
            long[] array = readArrayLong(n);
            long[] dp = new long[n];
            for (int i = n - 1; i >= 0; i--) {
                int temp = i + k + 1;
                long thisNum = array[i];
                if (temp < n) {
                    thisNum = Math.max(thisNum, thisNum + dp[temp]);
                }
                if (i < n - 1) {
                    dp[i] = Math.max(thisNum, dp[i + 1]);
                } else {
                    dp[i] = Math.max(dp[i], thisNum);
                }
            }
            stringBuilder.append(dp[0] + "\n");
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) throws IOException, InputMismatchException {
        Solution solution = new Solution();
        solution.solve();

    }
}