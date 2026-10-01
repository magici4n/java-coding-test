/*
[문제]
프로그래머스 12915 - 문자열 내 마음대로 정렬하기

[분류]
정렬 / Comparator / 람다식 / 문자열 비교

[접근]
- Arrays.sort()에 Comparator를 전달해 정렬 기준을 직접 정의한다.
- 두 문자열의 n번째 문자를 charAt(n)으로 비교한다.
- n번째 문자가 다르면 두 문자의 차이를 반환하여 오름차순으로 정렬한다.
- n번째 문자가 같으면 compareTo()를 사용해 문자열 전체를 사전순으로 정렬한다.
- 정렬된 strings 배열을 그대로 반환한다.

[시간복잡도]
- 문자열 배열의 길이를 N, 문자열의 최대 길이를 L이라고 하면
- 정렬: O(N log N)번의 비교
- 문자열 전체 비교(compareTo): 최악 O(L)
- 전체 시간복잡도: O(N × log N × L)

[핵심]
- Arrays.sort(배열, Comparator)로 원하는 정렬 기준을 지정할 수 있다.
- Comparator의 반환값은 다음과 같다.
  음수: a가 b보다 앞에 위치
  0: 두 값의 정렬 기준이 같음
  양수: a가 b보다 뒤에 위치
- a.charAt(n) - b.charAt(n)은 두 문자의 유니코드 값 차이를 이용한 오름차순 비교다.
- a.compareTo(b)는 두 문자열 전체를 사전순으로 비교한다.
- 정렬 기준이 여러 개라면 if문으로 우선순위를 구분할 수 있다.

[피드백]
- Comparator를 활용해 문제에서 요구하는 두 가지 정렬 조건을 정확하게 구현했다.
- n번째 문자가 같은 경우 compareTo()로 2차 정렬하는 방식이 적절하다.
- 불필요한 배열 생성이나 반복문 없이 Arrays.sort()만으로 해결한 간결한 풀이이다.
- Comparator가 반환하는 값의 부호에 따라 정렬 순서가 결정된다는 점을 기억하면 좋다.

[기억할 점]
정렬 기준이 여러 개인 경우
→ Comparator에서 우선순위가 높은 조건부터 비교한다.
→ 첫 번째 기준이 같을 때 두 번째 기준으로 비교한다.
→ compareTo()를 이용하면 문자열을 사전순으로 정렬할 수 있다.
 */

package programmers.lv1;

import java.util.Arrays;

public class P12915 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, (a, b) -> {
            if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }

            return a.charAt(n) - b.charAt(n);
        });

        return strings;

    }
}