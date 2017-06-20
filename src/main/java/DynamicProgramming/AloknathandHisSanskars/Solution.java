package DynamicProgramming.AloknathandHisSanskars;

import java.io.IOException;
import java.io.InputStream;

public class Solution {
    InputStream stream = System.in;
    StringBuilder builder = new StringBuilder();
    byte[] buffer = new byte[1024];
    int ptr = 0, lenBuf = 0;

    int readByte() throws IOException {
        if (lenBuf <= ptr) {
            ptr = 0;
            lenBuf = stream.read(buffer);
        }
        return buffer[ptr++];
    }


    public static void main(String[] args) {

    }
}
