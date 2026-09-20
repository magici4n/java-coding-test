/*
    쉬워서 패스
 */

package programmers.lv1;

public class P12919 {
    public static void main(String[] args){
        Solution s = new Solution();
        String[] seoul = {"Jane", "Kim"};
        System.out.println(s.solution(seoul));
    }

    static class Solution {
        public String solution(String[] seoul) {
            String answer = "";

            int count = 0;

            for (String s : seoul) {

                if(s.equals("Kim")){
                    break;
                }
                count++;
            }
            answer = "김서방은 " + count + "에 있다.";
            return answer;
        }
    }
}
