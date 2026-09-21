/*
    패스
 */

package programmers.lv1;

import java.util.Arrays;

public class P42748 {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] arrays = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Arrays.toString(s.solution(arrays,commands));

        System.out.println("Result = " + Arrays.toString(s.solution(arrays,commands)));
    }

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {

            int[] answer = new int[commands.length];

            int count = 0;

            for (int[] command : commands) {


                int i = command[0];
                int j = command[1];
                int k = command[2];

                int[] slice = new int[j - i + 1];
                for (int m = 0; m < slice.length; m++) {
                    slice[m] = array[i-1];
                    i++;
                }
                Arrays.sort(slice);
                answer[count] = slice[k-1];
                count++;
            }

            return answer;
        }
    }
}
