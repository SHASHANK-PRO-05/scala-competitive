package CodeForcesEdu23.TreasureHunt;


import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

    InputStream inputStream = System.in;
    StringBuilder stringBuilder = new StringBuilder();
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
        int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
        int x = readInt(), y = readInt();
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.min(y1, y2);
        boolean[][] arr = new boolean[maxX - minX + 1][maxY - minY + 1];
        arr[x1 - minX][y1 - minY] = true;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (i - minX - x >= 0 && j - minY - y >= 0 && arr[i - minX - x][j - minY - y]) {
                    arr[i - minX][j - minY] = true;
                } else if (i - minX - x >= 0 && j - minY + y <= maxX - minX && arr[i - minX - x][j - minY + y]) {
                    arr[i - minX][j - minY] = true;
                } else if (i - minX + x <= maxX - minX && j - minY - y >= 0 && arr[i - minX + x][j - minY - y]) {
                    arr[i - minX][j - minY] = true;
                } else if (i - minX + x <= maxX - minX && j - minY + y <= maxX - minY && arr[i - minX + x][j - minY + y]) {
                    arr[i - minX][j - minY] = true;
                }
            }
        }
        

    }

    public static void main(String[] args) throws IOException, InputMismatchException {
        Solution solution = new Solution();
        solution.solve();

    }
}