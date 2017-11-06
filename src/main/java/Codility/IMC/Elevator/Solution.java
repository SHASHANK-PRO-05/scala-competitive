package Codility.IMC.Elevator;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by shanky on 10/5/17.
 */
public class Solution {
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        int ans = 0;
        for (int i = 0; i < A.length; ) {
            int currentSize = 0;
            int currentWeight = 0;
            Set<Integer> numberFloors = new HashSet<>();
            //checking if some boundary case has occured
            if (A[i] > Y) break;
            while (i < A.length && currentSize + 1 <= X && currentWeight + A[i] <= Y) {
                numberFloors.add(B[i]);
                currentSize++;
                currentWeight += A[i];
                i++;
            }
            ans = ans + numberFloors.size() + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] array = {1, 2};
        int[] array2 = {1, 2};
        Solution s = new Solution();
        System.out.println(s.solution(array, array2, 5, 2, 1));
    }
}
