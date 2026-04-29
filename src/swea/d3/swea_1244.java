/*
[문제]
SWEA 1244 - 최대 상금

[분류]
DFS / 백트래킹 / 완전탐색 / 문자열

[접근]
현재 숫자 상태에서 바꿀 수 있는 두 자리를 모두 선택해 swap한 뒤,
교환 횟수를 하나 사용하고 다음 단계로 DFS를 진행했다.
교환 횟수를 모두 사용했을 때 만들어진 숫자들 중 최댓값을 answer로 갱신했다.
같은 교환 횟수에서 같은 숫자 상태가 다시 나오면 중복 탐색이므로 visited로 가지치기했다.

[시간복잡도]
대략 O((자리수^2)^chance)
- 매 단계마다 바꿀 수 있는 두 자리 조합을 모두 시도
- 다만 visited를 통해 같은 상태의 중복 탐색을 줄임

[핵심 포인트]
- 상태: 현재 숫자 배열(numbers), 현재까지 사용한 교환 횟수(count)
- 종료 조건: count == chance
- 행동: 두 자리 i, j를 골라 swap
- DFS 후 다시 swap해서 원상복구
- visited[count]에 현재 숫자 상태를 저장해 같은 단계의 중복 상태 제거
- 숫자 문자열은 new String(numbers)로 상태 비교 가능
- 최종 숫자 비교는 Integer.parseInt(current)로 가능

[피드백]
이 문제를 그리디나 선택정렬처럼 접근하지 않고,
가능한 모든 교환을 탐색하는 DFS + 백트래킹 구조로 바꾼 점이 가장 중요하다.
특히 swap -> dfs -> swap 구조를 통해 원상복구하는 백트래킹 흐름을 잘 적용했다.
또한 visited를 교환 횟수별로 나누어 같은 단계에서 같은 숫자 상태를 중복 탐색하지 않도록 처리한 점이 핵심이다.
이 문제는 난도가 있는 편이라 처음부터 혼자 설계하기 어려울 수 있는데,
코드를 직접 제출해보며 구조를 익히는 과정 자체가 의미가 크다.
다음에는 이 코드에서
1) 왜 count별 visited가 필요한지
2) 왜 swap 후 다시 swap하는지
3) 종료 조건이 왜 count == chance인지
이 세 가지를 스스로 설명할 수 있는지 확인해보면 좋다.
*/
package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class swea_1244 {
    static char[] numbers;
    static int chance;
    static int answer;
    static HashSet<String>[] visited;

    static void dfs(int count) {
        String current = new String(numbers);

        if (visited[count].contains(current)) {
            return;
        }
        visited[count].add(current);

        if (count == chance) {
            answer = Math.max(answer, Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                swap(i, j);
                dfs(count + 1);
                swap(i, j); // 원상복구
            }
        }
    }

    static void swap(int i, int j) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            chance = Integer.parseInt(st.nextToken());

            numbers = num.toCharArray();
            answer = 0;

            visited = new HashSet[chance + 1];
            for (int i = 0; i <= chance; i++) {
                visited[i] = new HashSet<>();
            }

            dfs(0);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
