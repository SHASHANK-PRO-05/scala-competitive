package Codility.IMC.ValidPassword;

/**
 * Created by shanky on 10/5/17.
 */
public class Solution {
    public int solution(String S) {
        //This thing will be returned
        int ans = -1;
        //string movements will be done on this
        int start = 0;
        int end = 0;
        //iterator
        int pointer = 0;
        boolean found = false;
        while (pointer < S.length()) {
            if (S.charAt(pointer) >= 'a' && S.charAt(pointer) <= 'z') {
                //WE DON'T KNOW IF THIS WILL COUNT TO VALID PASSWORD
                //FOR THAT WE HAVE USED FOUND IN CASE THE THINGS ARE
                //EXPANDING ON THIS CHAR
                end++;
                if (found) {
                    ans = Math.max(ans, end - start);
                }
            } else if (S.charAt(pointer) >= '0' && S.charAt(pointer) <= '9') {
                //RESET everything
                start = end = pointer + 1;
                found = false;
            } else {
                //FOUND A VALID PASSWORD
                end++;
                ans = Math.max(ans, end - start);
                found = true;
            }
            pointer++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("BBBB0bbbbbbbbbbA"));
    }
}
