package cp3.QueueAndDeque.UVa10935;
/**
 * https://uva.onlinejudge.org/external/109/10935.pdf
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

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
        int testCases = readInt();
        while (testCases != 0) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= testCases; i++) {
                queue.add(i);
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (queue.size() >= 2) {
                arrayList.add(queue.poll());
                queue.add(queue.poll());
            }
            stringBuilder.append("Discarded cards:");
            if (arrayList.size() != 0) {
                stringBuilder.append(" ");
            }
            for (int i = 0; i < arrayList.size(); i++) {
                stringBuilder.append(arrayList.get(i));

                if (arrayList.size() != i + 1)
                    stringBuilder.append(", ");
                else
                    stringBuilder.append("\n");
            }
            if (arrayList.size() == 0)
                stringBuilder.append("\n");
            stringBuilder.append("Remaining card: " + queue.poll() + "\n");
            testCases = readInt();
        }
        printWriter.print(stringBuilder);
        printWriter.flush();
        printWriter.close();
    }

    public static void main(String[] args) throws IOException, InputMismatchException {
        Main solution = new Main();
        solution.solve();

    }
}
