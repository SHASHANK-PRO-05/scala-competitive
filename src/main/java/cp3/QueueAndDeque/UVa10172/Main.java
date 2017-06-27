package cp3.QueueAndDeque.UVa10172;

/**
 * http://uva.onlinejudge.org/external/101/10172.pdf
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

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
        int t = readInt();
        while (t-- != 0) {
            int n = readInt(), stackSize = readInt(), queueSize = readInt();
            Queue<Integer>[] queues = new ConcurrentLinkedQueue[n];
            int toBeChecked = 0;
            for (int i = 0; i < n; i++) {
                queues[i] = new ConcurrentLinkedQueue<>();
                int size = readInt();
                for (int j = 0; j < size; j++) queues[i].add(readInt());
                toBeChecked += size;
            }
            Stack<Integer> stack = new Stack<>();
            long ans = 0;
            int i = 0;
            while (toBeChecked != 0) {
                while (!stack.isEmpty() && (queues[i].size() != queueSize || stack.peek() == i + 1)) {
                    if (stack.peek() == i + 1) {
                        stack.pop();
                        toBeChecked--;
                    } else {
                        queues[i].add(stack.pop());
                    }
                    ans += 1;
                }
                while (stack.size() != stackSize && !queues[i].isEmpty()) {
                    stack.push(queues[i].poll());
                    ans += 1;
                }
                if (toBeChecked != 0) {
                    ans += 2;
                }
                i = (i + 1) % n;
            }
            stringBuilder.append(ans + "\n");
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
