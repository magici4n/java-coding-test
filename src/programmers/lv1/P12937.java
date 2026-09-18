/*
    너무 쉬워서 패스
 */

package programmers.lv1;

public class P12937 {
    public static void main(String[] args){
        Solution s = new Solution();

        System.out.println("s.solution() = " + s.solution(1));
        System.out.println("s.solution() = " + s.solution(2));

    }


    static class Solution {
        public String solution(int num) {

            return (num % 2 == 0) ? "Even" : "Odd";
        }
    }

}
