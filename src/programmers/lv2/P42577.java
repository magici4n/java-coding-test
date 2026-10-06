/*
[문제]
프로그래머스 42577 - 전화번호 목록

[분류]
정렬 / 문자열 / 접두어 비교

[접근]
- 처음에는 모든 전화번호 쌍을 이중 반복문으로 비교했지만 O(N²)이라 시간 초과가 발생했다.
- 전화번호 목록을 문자열 사전순으로 정렬하면 접두어 관계가 있는 문자열들이 서로 가까이 붙게 된다.
- 따라서 모든 번호끼리 비교할 필요 없이 현재 문자열과 바로 이전 문자열만 비교하면 된다.
- 현재 문자열이 이전 문자열로 시작하면 접두어 관계가 존재하므로 false를 반환한다.
- 끝까지 접두어 관계가 발견되지 않으면 true를 반환한다.

[시간복잡도]
- 문자열 배열 정렬: O(N log N)
- 정렬 후 한 번 순회: O(N)
- startsWith()의 문자열 비교 비용까지 고려하면 대략 O(N log N × L)
  (L은 전화번호의 최대 길이)
- 기존 이중 반복문 O(N² × L)보다 훨씬 효율적이다.

[핵심]
- 문자열을 사전순으로 정렬하면 같은 접두어를 가진 문자열끼리 인접하게 된다.
- 따라서 접두어 여부는 인접한 문자열끼리만 비교해도 된다.
- String.startsWith(prefix)를 이용하면 해당 문자열이 특정 문자열로 시작하는지 확인할 수 있다.
- 모든 쌍을 비교하기 전에 정렬을 통해 비교 범위를 줄일 수 있는지 생각해본다.

[피드백]
- 처음 풀이에서는 모든 전화번호를 서로 비교해서 정답 로직은 맞았지만 시간복잡도가 O(N²)이라 시간 초과가 발생했다.
- 정렬 후 인접한 문자열만 비교하도록 개선하면서 탐색 범위를 크게 줄였다.
- prev와 cur을 이용한 현재 구현도 올바르다.
- 다만 더 간단하게는 phone_book[i]와 phone_book[i - 1]을 직접 비교할 수도 있다.

[기억할 점]
접두어 문자열 문제를 보면
→ 먼저 사전순 정렬을 떠올린다.
→ 정렬 후 비슷한 문자열들이 붙는지 확인한다.
→ 인접한 원소만 비교해서 전체 비교를 줄일 수 있는지 생각한다.
 */

package programmers.lv2;

import java.util.Arrays;

public class P42577 {

    public static void main(String[] args) {

        Solution s = new Solution();
        String[] phone_book = {"119", "97674223", "1195524421"};
        s.solution(phone_book);
    }
    static class Solution {
        public boolean solution(String[] phone_book) {

            Arrays.sort(phone_book);

            String prev = "";
            String cur = "";
            prev = phone_book[0];
            for(int i = 1; i< phone_book.length; i++){
                cur = phone_book[i];
                if(cur.startsWith(prev)){
                    return false;
                }
                prev = cur;
            }

            return true;
        }
    }
}



