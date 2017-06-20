package DynamicProgramming.MoodyNumbers;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    InputStream inputStream = System.in;
    PrintWriter printWriter = new PrintWriter(System.out);
    StringBuilder builder = new StringBuilder();
    int numChar = 0, curChar = 1;
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
        map.put(1, 1);
        map.put(4, 1);
        for (int test = 0; test < testCases; test++) {
            int n = readInt();
            int mainNum = n;
            Set<Integer> set = new HashSet<>();
            boolean found = false;
            while (true) {
                if (set.contains(n)) {
                    break;
                }
                if (map.containsKey(n) && map.get(n) == 1) {
                    found = true;
                    break;
                } else if (map.containsKey(n) && map.get(n) == 2) {
                    break;
                }
                set.add(n);
                n = check((long) n);

            }
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                if (found) map.put(it.next(), 1);
                else map.put(it.next(), 2);
            }
            if (map.get(mainNum) == 1) builder.append("YES\n");
            else builder.append("NO\n");
        }
        printWriter.print(builder);
        printWriter.flush();
        printWriter.close();
    }

    public int check(long n) {
        n = n * n;
        int num = 0;
        while (n != 0) {
            num += n % 10;
            n = n / 10;
        }
        return num;
    }

    public static void main(String[] args) throws IOException, InputMismatchException {
        Solution solution = new Solution();
        solution.solve();

    }
}
