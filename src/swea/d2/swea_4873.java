/*
[문제]
SWEA 4873 - 반복문자 지우기

[분류]
문자열 / 스택 / 구현

[접근]
문자열을 왼쪽부터 한 글자씩 확인하면서,
최근에 남아 있는 문자와 현재 문자가 같은지 비교한다.

최근에 남아 있는 문자를 확인하기 위해 스택을 사용한다.
스택이 비어 있으면 현재 문자를 넣고,
스택의 맨 위 문자와 현재 문자가 같으면 반복 문자 한 쌍이므로 pop 한다.
다르면 현재 문자를 push 한다.

모든 문자를 처리한 뒤 스택에 남아 있는 문자 개수가
반복 문자를 제거한 뒤 남은 문자열의 길이가 된다.

[시간복잡도]
O(N)

문자열의 각 문자를 한 번씩만 확인하고,
각 문자마다 push 또는 pop 연산을 수행한다.
스택 연산은 O(1)이므로 전체 시간복잡도는 O(N)이다.

[핵심 포인트]
- 같은 문자가 연속으로 나오면 두 개씩 제거하는 문제이다.
- 제거 후 새롭게 붙은 문자끼리도 다시 비교되어야 한다.
- 이때 "가장 최근에 남아 있는 문자"를 확인해야 하므로 스택을 사용한다.
- stack.peek()은 스택 맨 위 문자를 확인한다.
- stack.pop()은 스택 맨 위 문자를 제거한다.
- stack.push(c)는 현재 문자를 스택에 넣는다.
- Java에서는 Stack보다 Deque<Character> stack = new ArrayDeque<>(); 사용을 권장한다.

[피드백]
처음에는 단순 문자열 구현으로 접근할 수 있지만,
이 문제의 핵심은 문자를 제거한 뒤 새롭게 붙은 문자도 다시 비교해야 한다는 점이다.

예를 들어 ABBA의 경우,
가운데 BB가 제거되면 AA가 새롭게 붙고,
이 AA도 다시 제거되어 최종 길이는 0이 된다.

이처럼 최근에 남아 있는 문자와 현재 문자를 비교해야 하므로
스택을 사용하는 것이 정석적인 풀이이다.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class swea_4873 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            String words = br.readLine();

            Deque<Character> stack = new ArrayDeque<>();

            for(int i = 0; i<words.length(); i++) {
                char c = words.charAt(i);
                if(stack.isEmpty()) {
                    stack.push(c);
                }else if(stack.peek() == c) {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
            sb.append("#").append(tc+1).append(" ").append(stack.size()).append("\n");
        }
        System.out.print(sb);
    }
}
