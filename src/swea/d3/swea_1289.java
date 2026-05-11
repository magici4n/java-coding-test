/*
[문제]
SWEA 1289 - 원재의 메모리 복구하기

[분류]
구현 / 문자열 / 그리디

[접근]
- 처음 메모리 상태는 모든 비트가 0인 상태라고 생각한다.
- 목표 비트 문자열을 왼쪽부터 차례대로 확인한다.
- 현재 상태와 목표 비트의 문자가 다르면, 그 위치부터 뒤쪽까지 한 번에 바꿔야 한다.
- 따라서 이전 상태와 현재 문자가 달라지는 순간마다 수정 횟수를 1 증가시킨다.
- Deque를 사용하여 현재까지의 마지막 비트 상태를 저장한다.
- 처음 상태를 나타내기 위해 stack에 '0'을 먼저 넣어둔다.
- target_bit를 순회하면서 stack.peek()과 현재 문자가 다르면 count를 증가시키고,
  현재 문자를 stack에 push하여 상태를 갱신한다.

[시간복잡도]
- 목표 비트 문자열의 길이를 N이라고 할 때,
  문자열을 한 번만 순회하므로 O(N)이다.

[핵심 포인트]
- 처음 상태는 항상 0이다.
- 현재 상태와 목표 비트가 다를 때만 수정이 필요하다.
- 연속된 같은 비트는 한 번의 수정으로 처리되므로 매번 세면 안 된다.
- 결국 수정 횟수는 0에서 시작해서 비트 값이 바뀌는 구간의 개수와 같다.
- 첫 글자가 1이면 0에서 1로 바뀌는 순간이므로 count가 1 증가한다.
- Deque의 peek()을 통해 현재 상태를 확인하고, push()로 상태를 갱신했다.

[피드백]
- 문제의 핵심인 "비트가 바뀌는 순간만 세면 된다"는 접근을 잘 잡았다.
- stack.push('0')으로 초기 상태를 표현한 점이 좋다.
- Deque를 사용해도 정답은 가능하다.
- 다만 이 문제는 이전 상태 하나만 기억하면 되므로, char current = '0'; 하나로도 충분히 풀 수 있다.
- 현재 풀이도 논리적으로 맞지만, 자료구조를 쓰지 않고 변수 하나로 처리하면 더 간결해진다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class swea_1289 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for(int tc = 0; tc < T; tc++) {
            String target_bit = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            stack.push('0');

            int count = 0;

            for(int i = 0; i<target_bit.length(); i++) {
                char c = target_bit.charAt(i);

                if(stack.peek() != c) {
                    count++;
                    stack.push(c);
                }
            }
            sb.append("#").append(tc+1).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }
}
