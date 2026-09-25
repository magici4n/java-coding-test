/*
[문제]
Programmers 42576 - 완주하지 못한 선수

[분류]
해시 / HashMap / 문자열 / 빈도수 계산

[접근]
participant를 순회하면서 각 이름의 등장 횟수를 HashMap에 저장한다.

completion을 순회하면서 완주한 선수의 이름에 해당하는 값을 1씩 감소시킨다.

모든 처리가 끝난 뒤 값이 0이 아닌 이름이
완주하지 못한 선수이므로 해당 이름을 반환한다.

동명이인이 존재할 수 있기 때문에 Set이 아니라
이름별 개수를 저장할 수 있는 Map을 사용한다.

[시간복잡도]
O(N)

participant 순회 : O(N)
completion 순회 : O(N)
HashMap 탐색 : O(N)

HashMap의 get/put은 평균 O(1)이므로 전체는 O(N)

[공간복잡도]
O(N)

참가자의 이름과 등장 횟수를 HashMap에 저장한다.

[핵심 포인트]
1. HashMap으로 빈도수 세기

   map.put(key, map.getOrDefault(key, 0) + 1);

2. getOrDefault()

   map.getOrDefault(key, 0)

   key가 존재하면 기존 value 반환
   key가 없으면 0 반환

3. participant는 +1

   attend.put(name, attend.getOrDefault(name, 0) + 1);

4. completion은 -1

   attend.put(name, attend.get(name) - 1);

5. 최종적으로 value가 0이 아닌 key가 정답

6. 동명이인이 있기 때문에 HashSet으로는 해결할 수 없다.

[피드백]
- 처음에는 Map이 필요한지 고민했지만,
  동명이인을 처리하기 위해 이름별 등장 횟수를 저장해야 한다는 점을 이해했다.

- participant에서 +1, completion에서 -1 하는 방식으로
  두 배열의 차이를 표현할 수 있었다.

- getOrDefault(key, 0)를 이용한 빈도수 계산 패턴을 익혔다.

- HashMap을 사용할 때
  "값 자체를 저장하는가?"보다
  "각 값이 몇 번 등장했는가?"를 저장할 수 있다는 점을 기억하기.

[다시 볼 포인트]
빈도수 문제를 보면 다음 형태를 떠올리기.

Map<T, Integer> map = new HashMap<>();

for (...) {
    map.put(key, map.getOrDefault(key, 0) + 1);
}
*/

package programmers.lv1;


import java.util.HashMap;
import java.util.Map;

public class P42576 {

    public static void main(String[] args) {
        Solution s = new Solution();
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {


            Map<String, Integer> attend = new HashMap<>();

            for (String name : participant) {
                attend.put(name, attend.getOrDefault(name, 0) + 1);
            }

            for (String name : completion) {
                attend.put(name, attend.get(name) - 1);
            }

            for (String name : attend.keySet()) {
                if (attend.get(name) != 0) {
                    return name;
                }
            }

            return "";
        }
    }
}
