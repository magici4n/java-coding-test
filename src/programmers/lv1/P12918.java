/*
    쉬워서 패스
 */

package programmers.lv1;

public class P12918 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("a234"));
        System.out.println(s.solution("1234"));
    }

    static class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            if(!(s.length() == 4 || s.length() == 6)){
                answer =  false;
                return answer;
            }
            for(int i = 0; i < s.length(); i++){
                if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                    answer = false;
                    break;
                }
            }
            return answer;
        }
    }
}
