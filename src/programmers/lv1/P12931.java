/*
    쉬워서 패스
 */

package programmers.lv1;

import java.util.*;

public class P12931 {

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("s.solution(123) = " + s.solution(987));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;

            while(n / 10 > 0){
                answer += n%10;
                n = n/10;
            }
            answer += n;


            return answer;
        }
    }
}
