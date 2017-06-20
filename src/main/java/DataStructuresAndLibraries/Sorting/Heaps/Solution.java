package DataStructuresAndLibraries.Sorting.Heaps;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

    InputStream inputStream = System.in;
    StringBuilder stringBuilder = new StringBuilder();

    PrintWriter printWriter;
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

    public void heapify(Integer[] arr, int size, int parent) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int curr = parent;
        if (left <= size && arr[left] > arr[curr]) {
            curr = left;
        }
        if (right <= size && arr[right] > arr[curr]) {
            curr = right;
        }
        if (arr[parent] < arr[curr]) {
            this.swap(arr, parent, curr);
            heapify(arr, size, curr);
        }
    }

    public void reHeapify(Integer[] arr, int size, int index) {

        while (index != 0) {
            if (index % 2 == 0) {
                index = (index / 2) - 1;
            } else {
                index = index / 2;
            }
            heapify(arr, size, index);
        }
    }

    public void solve() throws IOException, InputMismatchException {
        int testCases = readInt();
        Integer[] temp = new Integer[testCases];
        Arrays.fill(temp, -1);
        for (int i = 0; i < testCases; i++) {
            temp[i] = readInt();
            if (i >= 2) {
                reHeapify(temp, i, i);
                for (int j = i; j >= i - 2; j--) {
                    this.swap(temp, 0, j);
                    heapify(temp, j - 1, 0);
                }
                stringBuilder.append(temp[i] + " " + temp[i - 1] + " " + temp[i - 2] + "\n");
                reHeapify(temp, i - 2, i - 2);
                reHeapify(temp, i - 1, i - 1);
                reHeapify(temp, i, i);
//                reHeapify(temp, i, i - 1);
//                reHeapify(temp, i, i - 2);
            } else {
                stringBuilder.append("-1\n");
            }
        }
        printWriter.print(stringBuilder);
        printWriter.flush();
        printWriter.close();
    }

    public static void main(String[] args) throws IOException, InputMismatchException {

        Solution solution = new Solution();
        solution.printWriter = new PrintWriter("test.txt");
        solution.solve();

    }
}
