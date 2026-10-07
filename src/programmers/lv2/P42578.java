/*
[문제]
프로그래머스 42578 - 의상

[분류]
HashMap / 경우의 수 / 조합

[접근]
- 의상 이름 자체는 중요하지 않고, 의상 종류별 개수만 알면 된다.
- HashMap을 사용해 각 의상 종류가 몇 개 있는지 센다.
- 각 종류마다 "하나를 입는 경우 + 아무것도 입지 않는 경우"가 있으므로
  선택 가능한 경우의 수는 (해당 종류의 개수 + 1)이다.
- 각 종류의 선택 경우의 수를 모두 곱한다.
- 마지막으로 모든 종류에서 아무것도 입지 않는 경우 1개를 제외한다.

[시간복잡도]
- clothes의 길이를 N이라고 할 때
- 의상 종류별 개수를 세는 과정: O(N)
- map.values() 순회: O(K)
  (K는 의상 종류의 개수, K <= N)
- 전체 시간복잡도: O(N)

[핵심]
- 같은 종류의 의상에서는 한 번에 하나만 선택할 수 있다.
- 각 종류별 선택지는
  "입을 수 있는 의상 개수 + 안 입는 경우 1개"
  이므로 count + 1이다.
- 서로 다른 종류의 선택은 독립적이므로 곱의 법칙을 사용한다.
- 아무것도 입지 않는 경우는 허용되지 않으므로 마지막에 1을 뺀다.
- HashMap의 getOrDefault()를 사용하면 종류별 개수를 간단하게 누적할 수 있다.

[피드백]
- 의상 이름이 아니라 의상 종류별 개수만 세도록 한 접근이 적절하다.
- getOrDefault()를 사용해 HashMap에 개수를 누적한 방식이 간결하다.
- 경우의 수를 (value + 1)씩 곱하고 마지막에 1을 빼는 로직도 정확하다.
- 불필요한 중첩 반복문 없이 한 번의 순회로 종류별 개수를 구해 효율적이다.

[기억할 점]
종류별로 하나를 선택하거나 선택하지 않는 경우가 있다면
→ 각 종류의 경우의 수를 (개수 + 1)로 계산한다.
→ 서로 독립적인 선택이면 전부 곱한다.
→ 전체 미선택 경우가 불가능하면 마지막에 1을 뺀다.
 */

package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class P42578 {

    public static void main(String[] args) {

        Solution s = new Solution();
        String[][] clothes= {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(s.solution(clothes));
    }

    static class Solution {
        public int solution(String[][] clothes) {

            Map<String, Integer> map = new HashMap<>();

            for (String[] clothe : clothes) {

                    map.put(clothe[1],map.getOrDefault(clothe[1],0)+1);

            }
            int answer = 1;
            for (Integer value : map.values()) {
                answer *= value+1;
            }

            return answer-1;
        }
    }

}
