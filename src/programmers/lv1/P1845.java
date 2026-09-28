/*
쉬워서 패스
 */

package programmers.lv1;

import java.util.HashSet;
import java.util.Set;

public class P1845 {

    public static void main(String[] args){

        Solution s = new Solution();
        int[] nums = {3,3,3,2,2,4};
        System.out.println(s.solution(nums));
    }


    static class Solution {
        public int solution(int[] nums) {

            int N = nums.length;

            Set<Integer> pocketmonbook = new HashSet<>();

            for(Integer pocketmon : nums){
                pocketmonbook.add(pocketmon);
            }

            return Math.min(pocketmonbook.size(), N / 2);
        }
    }
}
