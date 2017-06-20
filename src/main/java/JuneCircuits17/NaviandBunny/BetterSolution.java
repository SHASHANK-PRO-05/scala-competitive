package JuneCircuits17.NaviandBunny;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

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

    String s;
    long[][][] dp;
    boolean[] visited;
    int d;
    ArrayList<ArrayList<Integer>> arrayLists;
    long mod = 1000000007;

    public long recur(int index, int currentCount) {
        if (visited[index]) return 0;
        if (currentCount == s.length() - 1 && index == s.length() - 1) {
            return 1;
        } else if (index == s.length() - 1) return 0;
        visited[index] = true;
        long ans = 0;
        for (int i = 0; i < arrayLists.get(index).size(); i++) {
            //if (visited[arrayLists.get(index).get(i)]) continue;
            if (dp[index][arrayLists.get(index).get(i)][currentCount + 1] == 0) {
                dp[index][arrayLists.get(index).get(i)][currentCount + 1] = 0;

                // if (dp[index][arrayLists.get(index).get(i)][currentCount + 1] == 0) {

            }
            //dp[index][arrayLists.get(index).get(i)][currentCount + 1] = -1;
            // }
            // if (dp[index][arrayLists.get(index).get(i)][currentCount + 1] != -1)
            ans = (ans + dp[index][arrayLists.get(index).get(i)][currentCount + 1]) % mod;
        }
        visited[index] = false;

        return ans;
    }

    public void solve() throws IOException, InputMismatchException {
        s = readString();
        d = readInt();
        visited = new boolean[s.length()];
        dp = new long[s.length()][s.length()][s.length()];
        arrayLists = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                arrayLists.add(new ArrayList<>());
                continue;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (s.charAt(i) == '?') {
                for (int j = 1; j <= d; j++) {
                    if (i - j > 0) arrayList.add(i - j);
                    if (i + j < s.length()) arrayList.add(i + j);
                }
            } else {
                int tempNum = (s.charAt(i) - '0');
                if (i - tempNum > 0) arrayList.add(i - tempNum);
                if (i + tempNum < s.length()) arrayList.add(i + tempNum);
            }
            arrayLists.add(arrayList);
        }
       /* for (int i = 0; i < s.length() - 1; i++) {
            System.out.println(arrayLists.get(i));
        }*/
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        long ans = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() == s.length() - 1 && stack.size() == s.length()) {
                ans = (ans + 1) % mod;
            } else if (!visited[stack.peek()]) {
                visited[stack.peek()] = true;
                for (int i = 0; i < arrayLists.get(stack.peek()).size(); i++) {
                    if (!visited[arrayLists.get(stack.peek()).get(i)]) {
                        stack.push(arrayLists.get(stack.peek()).get(i));
                    }
                }
            }

        }

        printWriter.flush();
        printWriter.close();
    }

    public static void main(String[] args) throws IOException, InputMismatchException {
        BetterSolution solution = new BetterSolution();
        solution.solve();

    }
}
