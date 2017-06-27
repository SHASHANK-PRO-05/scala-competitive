package cp3.QueueAndDeque.MonkandChamberofSecrets;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Temp {
    public int index;
    public int elementVal;
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
        int n = readInt(), x = readInt();
        ArrayList<Temp> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Temp node = new Temp();
            node.index = i + 1;
            node.elementVal = readInt();
            arrayList.add(node);
        }
        for (int i = 0; i < x; i++) {
            Temp max = arrayList.get(0);
            for (int j = 1; j < arrayList.size() && j < x; j++) {
                Temp temp = arrayList.get(j);
                if (temp.elementVal > max.elementVal)
                    max = temp;
            }
            int arrayListSize = arrayList.size();
            stringBuilder.append(max.index + " ");
            for (int j = 0; j < arrayListSize && j < x; j++) {
                Temp temp = arrayList.remove(0);
                if (temp != max) {
                    if (temp.elementVal != 0)
                        temp.elementVal--;
                    arrayList.add(temp);
                }
            }
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
