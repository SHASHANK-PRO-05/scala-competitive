package GoogleJam.DPProblem;

import java.util.ArrayList;

/**
 * Created by shanky on 10/23/17.
 */
class DPClass {
    public int parent = -1;
    public ArrayList<DPClass> child = new ArrayList<>();
    int firstMaximaSide = 0;
    int secondMaximaSide = 0;
    public int value = 0;
    public boolean solved = false;
}

public class Solution {

    public int solution(int[] A, int[] E) {
        globalMaxima = 0;
        if (A.length == 1) return 0;
        DPClass[] dpClass = new DPClass[A.length];
        for (int i = 0; i < dpClass.length; i++) {
            dpClass[i] = new DPClass();
            dpClass[i].value = A[i];
        }
        for (int i = 0; i < E.length; i = i + 2) {
            int parent = E[i] - 1;
            int child = E[i + 1] - 1;
            if (dpClass[parent].value == dpClass[child].value) {
                dpClass[parent].child.add(dpClass[child]);
            }
        }
        int maxAns = 0;
        for (int i = 0; i < dpClass.length; i++) {
            recurTheElement(dpClass[i]);
        }
        return globalMaxima;
    }

    int globalMaxima = 0;

    public int recurTheElement(DPClass dpClass) {
        if (dpClass.solved) return dpClass.firstMaximaSide + 1;
        dpClass.solved = true;
        for (int i = 0; i < dpClass.child.size(); i++) {
            int returnedValue = recurTheElement(dpClass.child.get(i));
            if (returnedValue > dpClass.firstMaximaSide) {
                dpClass.secondMaximaSide = dpClass.firstMaximaSide;
                dpClass.firstMaximaSide = returnedValue;
            } else if (returnedValue > dpClass.secondMaximaSide) {
                dpClass.secondMaximaSide = returnedValue;
            }
        }
        globalMaxima = Math.max(dpClass.firstMaximaSide + dpClass.secondMaximaSide, globalMaxima);
        return dpClass.firstMaximaSide + 1;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 1, 1, 1, 0};
        int[] edge = {1, 2, 1, 3, 2, 4, 2, 5, 4, 6};
        Solution s = new Solution();
        System.out.println(s.solution(array, edge));
    }
}
