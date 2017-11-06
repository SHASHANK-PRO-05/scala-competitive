package GoogleJam.String;

/**
 * Created by shanky on 10/23/17.
 */
public class Solution {
    public String solution(String S, int K) {
        StringBuilder stringBuilder = new StringBuilder(S).reverse();
        StringBuilder answer = new StringBuilder("");
        int k = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) != '-') {
                answer = answer.append(stringBuilder.charAt(i));
                if (k == K - 1 && i != stringBuilder.length() - 1) {
                    answer = answer.append("-");
                }
                k = (k + 1) % K;
            }
        }
        return answer.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("2-4A0r7-4k", 4));
    }
}
