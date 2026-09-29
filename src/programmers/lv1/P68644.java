/*
[문제]
프로그래머스 68644 - 두 개 뽑아서 더하기

[분류]
완전탐색 / HashSet / 정렬

[접근]
- 서로 다른 두 숫자의 모든 조합을 확인해야 한다.
- i를 기준으로 j를 i + 1부터 시작해서 같은 원소를 두 번 선택하지 않도록 했다.
- numbers[i] + numbers[j] 값을 HashSet에 넣어 중복된 합을 제거했다.
- HashSet의 값을 int 배열로 옮긴 뒤 오름차순으로 정렬했다.

[시간복잡도]
- 두 수의 모든 조합 탐색: O(N²)
- 서로 다른 합의 개수를 K라고 하면 정렬: O(K log K)
- 전체: O(N² + K log K)

[핵심]
- 두 원소 조합을 구할 때 j = i + 1부터 시작하면
  같은 원소를 선택하는 경우와 (i, j), (j, i) 중복 탐색을 막을 수 있다.
- 결과값의 중복 제거가 필요할 때 HashSet을 사용할 수 있다.
- HashSet은 순서가 보장되지 않으므로 마지막에 정렬이 필요하다.

[피드백]
- HashSet을 사용해 중복 제거를 별도 조건문 없이 처리한 점이 좋다.
- sum보다는 sums처럼 여러 합을 저장한다는 의미가 드러나는 변수명이 조금 더 좋다.
- HashSet<Integer> 대신 Set<Integer> sums = new HashSet<>(); 형태로 선언하는 습관도 추천.

- 중복 제거? -> Set 생각하기.
 */
package programmers.lv1;

import java.util.Arrays;
import java.util.HashSet;

public class P68644 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] numbers = {2,3,4,5,6,7};
        System.out.println((Arrays.toString(s.solution(numbers))));
    }


    static class Solution {
        public int[] solution(int[] numbers) {

            HashSet<Integer> sum = new HashSet<>();

            for(int i = 0; i< numbers.length-1; i++){
                for(int j = i+1 ; j <numbers.length; j++){
                    sum.add(numbers[i] + numbers[j]);
                }
            }

           int [] answer = new int[sum.size()];
            int index = 0;
            for (Integer i : sum) {
                answer[index++] = i;
            }

            Arrays.sort(answer);
            return answer;
        }
    }
}
