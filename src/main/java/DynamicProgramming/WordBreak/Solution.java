package DynamicProgramming.WordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/#/description
 */

public class Solution {
    /**
     * This approach uses hashmap. try to make it 2d
     */
//    //Simple Memoization added
//    Map<String, Boolean> map = new HashMap<>();
//
//    /************************************************
//     * This function is implemented using brute force
//     ***********************************************/
//    public boolean wordBreak(String s, List<String> list) {
//        if (s.isEmpty()) return true;
//        if (map.containsKey(s)) return map.get(s);
//        for (int i = 0; i < s.length(); i++) {
//            if (list.contains(s.substring(0, i + 1)) && wordBreak(s.substring(i + 1, s.length()), list)) {
//                map.put(s, true);
//                return true;
//            }
//        }
//        map.put(s, false);
//        return false;
//    }
    public boolean wordBreak(String s, List<String> temp) {
        Set<String> list = new HashSet<>(temp);
        if (s.isEmpty()) return true;
        boolean[] memo = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.substring(0, i + 1))) {
                //System.out.println(i);
                memo[i] = true;
                continue;
            }
            for (int j = 0; j <= i; j++) {
                //if (memo[j] == true)
                //   System.out.println(i + ":" + j + ":" + s.substring(0, j + 1) + " " + s.substring(j + 1, i + 1) + " " + memo[j]);
                if (memo[j] && list.contains(s.substring(j + 1, i + 1))) {
                    memo[i] = true;
                }
            }
        }
        return memo[s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leecode";
        String strings[] = {"leet", "code"};
        System.out.println(solution.wordBreak(s, Arrays.asList(strings)));
    }

}
