package IndiaHacks17.HackerwithTeam;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
                ans = (ans * mantisa);
            }
            mantisa = (mantisa * mantisa);
            exponent = exponent / 2;
        }
        return ans;
    }

    Integer[] segmentTree;
    Integer[] arr;
    int n, q;
    int segmentTreeSize;

    int getMid(int ss, int se) {
        return ss + (se - ss) / 2;
    }

    public void updateSegmentTree(int ss, int se, int i, int diff, int si) {
        if (ss > i || se < i) return;
        segmentTree[si] = segmentTree[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateSegmentTree(ss, mid, i, diff, si * 2 + 1);
            updateSegmentTree(mid + 1, se, i, diff, si * 2 + 2);
        }
    }

    //   public void sumSegmentTree(int ss,)
    public int constructSegmentTree(int ss, int se, int si) {
        if (ss == se) {
            segmentTree[si] = arr[ss];
            return segmentTree[si];
        }
        int mid = getMid(ss, se);
        segmentTree[si] = constructSegmentTree(ss, mid, si * 2 + 1) +
                constructSegmentTree(mid + 1, se, si * 2 + 2);
        return segmentTree[si];
    }

    public int getSum(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se)
            return segmentTree[si];
        if (se < qs || qe < ss) return 0;
        int mid = getMid(ss, se);
        return getSum(ss, mid, qs, qe, si * 2 + 1) +
                getSum(mid + 1, se, qs, qe, si * 2 + 2);
    }

    public void solve() throws IOException, InputMismatchException {
        n = readInt();
        q = readInt();
        segmentTreeSize = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        segmentTreeSize = 2 * (int) Math.pow(2, segmentTreeSize) - 1;
        segmentTree = new Integer[segmentTreeSize];
        Arrays.fill(segmentTree, 0);
        arr = readArrayInt(n);
        constructSegmentTree(0, n - 1, 0);
        //System.out.println(Arrays.deepToString(segmentTree));
        while (q-- != 0) {
            int i = readInt();
            if (i == 1) {
                int l = readInt() - 1;
                int r = readInt() - 1;
                int k = readInt();
                long ans = 0;
                for (int j = l; j <= r; j++) {
                    int temp = j - k;
                    if (temp <= 0) temp = 0;
                    ans += getSum(0, n - 1, temp, j, 0);
                }
                printWriter.println(ans);
            } else {
                int j = readInt() - 1;
                int x = readInt();
                int diff = x - arr[j];
                arr[j] = x;
                updateSegmentTree(0, n - 1, j, diff, 0);
            }
        }
        printWriter.flush();
        printWriter.close();
    }

    public static void main(String[] args) throws IOException, InputMismatchException {
        Solution solution = new Solution();
        solution.solve();

    }
}
