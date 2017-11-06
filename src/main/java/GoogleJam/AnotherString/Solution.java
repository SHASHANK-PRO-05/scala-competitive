package GoogleJam.AnotherString;

/**
 * Created by shanky on 10/23/17.
 */
public class Solution {
    public int solution(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int check = 0;
        while (sb.length() < B.length()) {
            sb.append(A);
            check++;
        }
        if (sb.toString().contains(B)) return check;
        if (sb.append(A).toString().contains(B)) return check + 1;
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("abcd","cdabcdab"));
    }
}
