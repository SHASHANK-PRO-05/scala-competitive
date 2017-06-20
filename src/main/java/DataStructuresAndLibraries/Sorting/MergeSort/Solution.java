package DataStructuresAndLibraries.Sorting.MergeSort;


import java.io.*;
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

    public long mergeThem(Integer[] arr, int start, int mid, int end) {
        long ans = 0L;

        int size1 = mid - start + 1;
        int size2 = end - mid;
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        long tempAns = 0l;
        for (int i = start; i <= mid; i++) {
            arr1[i - start] = arr[i];
        }
        for (int i = mid + 1; i <= end; i++) {
            arr2[i - mid - 1] = arr[i];
        }
        int i = 0, j = 0;
        int k = start;
        while (i < size1 && j < size2) {
            if (arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                if (arr1[i] != arr2[j])
                    tempAns += size1 - i;
                arr[k++] = arr2[j++];
            }
        }
        while (i < size1) {
            arr[k++] = arr1[i++];
        }
        while (j < size2) {
            arr[k++] = arr2[j++];
        }
        return tempAns;
    }

    public long mergeSplit(Integer[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            long ans = mergeSplit(arr, start, mid) +
                    mergeSplit(arr, mid + 1, end) + mergeThem(arr, start, mid, end);
            return ans;
        } else {
            return 0L;
        }
    }

    public void solve() throws IOException, InputMismatchException {
        //printWriter = new PrintWriter("output.txt");
        inputStream = new BufferedInputStream(new FileInputStream("input.txt"));
        int testCases = readInt();
        Integer[] arr = readArrayInt(testCases);
        printWriter.println(mergeSplit(arr, 0, testCases - 1));
        //printWriter.println(Arrays.deepToString(arr));
        printWriter.flush();
        printWriter.close();

    }

    public static void main(String[] args) throws IOException, InputMismatchException {

        Solution solution = new Solution();
        solution.solve();

    }
}
