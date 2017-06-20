package IndiaHacks17.HackerswithBits;


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

    public Integer[] readArrayInt(int n) throws IOException, InputMismatchException {
        Integer[] array = new Integer[n];
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

    public int maxSubarray(Integer[] arr, int n) {
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cur++;
                ans = Math.max(ans, cur);
            } else {
                cur = 0;
            }
        }
        return ans;
    }

    public void solve() throws IOException, InputMismatchException {
        int n = readInt();
        Integer[] arr = readArrayInt(n);
        ArrayList<Integer> zeros = new ArrayList<Integer>();
        ArrayList<Integer> ones = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) zeros.add(i);
            else ones.add(i);
        }
        int ans = 0;
        if (n != 1) {
            if (zeros.size() != 0) {
                for (int i = 0; i < zeros.size(); i++) {
                    for (int j = 0; j < ones.size(); j++) {
                        this.swap(arr, zeros.get(i), ones.get(j));
                        ans = Math.max(ans, maxSubarray(arr, n));
                        this.swap(arr, zeros.get(i), ones.get(j));
                    }
                }
            } else {
                ans = n;
            }
        } else {
            if (arr[0] == 1) ans = 1;
            else ans = 0;
        }
        printWriter.println(ans);
        printWriter.flush();
        printWriter.close();

    }

    public static void main(String[] args) throws IOException, InputMismatchException {
        Solution solution = new Solution();
        solution.solve();

    }
}
