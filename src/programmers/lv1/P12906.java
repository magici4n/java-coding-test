/*
Deque 사용 외엔 특별한 것 없어서 패스
 */

package programmers.lv1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class P12906 {
    public static void main(String[] args) {

        Solution s = new Solution();
        int []arr = {1,1,3,3,0,1,1};
        System.out.println("result : " + Arrays.toString(s.solution(arr)));

    }

    static class Solution {
        public int[] solution(int []arr) {

            Deque<Integer> dq = new ArrayDeque<>();
            dq.offerLast(arr[0]);
            for(int i = 1; i< arr.length; i++){

                if(dq.peekLast() != arr[i]){
                    dq.offerLast(arr[i]);
                }
            }
            int[] answer = new int[dq.size()];
            int count = 0;
            while(!dq.isEmpty()){

                answer[count] = dq.pollFirst();
                count++;
            }
            return answer;
        }
    }

}
