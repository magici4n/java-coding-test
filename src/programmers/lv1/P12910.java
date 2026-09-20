/*
람다 사용을 생각해보면 좋다.
int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
 */

package programmers.lv1;

import java.util.Arrays;

public class P12910 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] arr = {5, 9, 7, 10};
        int divisor = 5;

        System.out.println(Arrays.toString(s.solution(arr, divisor)));


    }

    static class Solution {
        public int[] solution(int[] arr, int divisor) {
            int[] tmp = new int[arr.length];

            int count=0;

            for (int i : arr) {
                if(i % divisor == 0){
                    tmp[count] = i;
                    count++;
                }
            }


            int[] answer = new int[count];

            if(count == 0){
                return new int[]{-1};
            }else{
                for(int i = 0; i < count; i++){
                    answer[i] = tmp[i];
                }
            }

            Arrays.sort(answer);
            return answer;
        }
    }
}
