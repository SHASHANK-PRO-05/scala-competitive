package cp3.QueueAndDeque.UVa10901;

/**
 * https://uva.onlinejudge.org/external/109/10901.pdf
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

class Arrival {
    public int arrival;
    public int index;
}

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
        int test = readInt();
        while (test-- != 0) {
            int n = readInt(), t = readInt(), m = readInt();
            Queue<Arrival> left = new LinkedList<>();
            Queue<Arrival> right = new LinkedList<>();
            int[] arr = new int[m];

            for (int i = 0; i < m; i++) {
                Arrival arrival = new Arrival();
                arrival.arrival = readInt();
                arrival.index = i;
                String side = readString();
                switch (side) {
                    case "left":
                        left.add(arrival);
                        break;
                    case "right":
                        right.add(arrival);
                }
            }
            int currentSide = 1;
            int currentTime = 0;

            while (!left.isEmpty() || !right.isEmpty()) {
                if (currentSide == 1 && !left.isEmpty() && left.peek().arrival <= currentTime) {
                    int temp = 0;
                    while (!left.isEmpty() && left.peek().arrival <= currentTime && temp < n) {
                        Arrival arrival = left.poll();
                        arr[arrival.index] = currentTime + t;
                        temp++;
                    }
                    currentTime += t;
                    currentSide = 2;
                } else if (currentSide == 2 && !right.isEmpty() && right.peek().arrival <= currentTime) {
                    int temp = 0;
                    while (!right.isEmpty() && right.peek().arrival <= currentTime && temp < n) {
                        Arrival arrival = right.poll();
                        arr[arrival.index] = currentTime + t;
                        temp++;
                    }
                    currentTime += t;
                    currentSide = 1;
                } else if (currentSide == 2) {
                    if (!left.isEmpty() && !right.isEmpty() && left.peek().arrival >= right.peek().arrival) {
                        currentTime = Math.max(currentTime, right.peek().arrival);
                    } else if (right.isEmpty() || (!left.isEmpty() && left.peek().arrival < right.peek().arrival)) {
                        currentSide = 1;
                        currentTime = Math.max(currentTime, left.peek().arrival) + t;
                    } else if (left.isEmpty()) {
                        currentTime = Math.max(currentTime, right.peek().arrival);
                    }
                } else if (currentSide == 1) {
                    if (!left.isEmpty() && !right.isEmpty() && left.peek().arrival <= right.peek().arrival) {
                        currentTime = Math.max(currentTime, left.peek().arrival);
                    } else if (left.isEmpty() || (!right.isEmpty() && right.peek().arrival < left.peek().arrival)) {
                        currentSide = 2;
                        currentTime = Math.max(right.peek().arrival, currentTime) + t;
                    } else if (right.isEmpty()) {
                        currentTime = Math.max(currentTime, left.peek().arrival);
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                stringBuilder.append(arr[i] + "\n");
            }
            if (test != 0)
                stringBuilder.append("\n");
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
