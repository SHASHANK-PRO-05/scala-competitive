package DynamicProgramming.Cormen;

public class PipeCutting {
    /**
     * Highly inefficient code
     *
     * @param n
     * @param p
     * @return
     */
    public int cutRod(int n, int[] p) {
        if (n == 0) return 0;
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + cutRod(n - i, p));
        }
        return q;
    }
}
