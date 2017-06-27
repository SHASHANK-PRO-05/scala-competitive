package cp3.QueueAndDeque.UVa540;

/**
 * https://uva.onlinejudge.org/external/5/540.pdf
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
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
        int numberTeam = readInt();
        int scenario = 0;
        int[] teamSetup = new int[1000000];
        boolean[] teamIn = new boolean[1001];
        while (numberTeam != 0) {
            scenario++;
            Queue<Integer>[] temp = new Queue[numberTeam];

            for (int i = 0; i < numberTeam; i++) {
                int size = readInt();
                teamIn[i] = false;
                temp[i] = new ConcurrentLinkedDeque<>();
                for (int j = 0; j < size; j++) {
                    teamSetup[readInt()] = i;
                }
            }
            Queue<Integer> firstSetup = new ConcurrentLinkedQueue<>();
            String command = readString();
            stringBuilder.append("Scenario #" + scenario).append("\n");
            while (!command.equals("STOP")) {
                switch (command) {
                    case "ENQUEUE":
                        int num = readInt();
                        int teamNumber = teamSetup[num];
                        if (teamIn[teamNumber]) {
                            temp[teamNumber].add(num);
                        } else {
                            teamIn[teamNumber] = true;
                            firstSetup.add(teamNumber);
                            temp[teamNumber].add(num);
                        }
                        break;
                    case "DEQUEUE":
                        int start = firstSetup.peek();
                        int numberToprint = temp[start].poll();
                        stringBuilder.append(numberToprint + "\n");
                        if (temp[start].size() == 0) {
                            firstSetup.poll();
                            teamIn[start] = false;
                        }
                        break;
                }
                command = readString();
            }
            stringBuilder.append("\n");
            numberTeam = readInt();
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