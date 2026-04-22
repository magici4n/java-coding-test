/*
[문제]
SWEA 4874 - Forth

[분류]
스택 / 구현 / 문자열

[접근]
후위 표기식이므로 숫자가 나오면 스택에 넣고,
연산자가 나오면 스택에서 두 개를 꺼내 계산한 뒤 다시 넣는 방식으로 처리했다.
"."이 나오면 연산을 끝내고 결과를 출력하도록 했다.

[시간복잡도]
O(N)
- 입력 토큰을 한 번씩만 확인하므로 O(N)

[핵심 포인트]
- 숫자는 stack.push()
- 연산자는 stack.pop() 2번 후 계산 결과를 다시 push
- 뺄셈, 나눗셈은 순서가 중요해서
  먼저 꺼낸 값을 b, 다음 값을 a로 두고 a-b, a/b 로 계산해야 함
- 연산자 처리 전 stack.size() >= 2 검사 필요
- "."에서는 스택에 값이 정확히 1개 남아 있는지 확인해야 함
- 입력은 StringTokenizer로 분리해서 처리 가능

[피드백]
"."을 만났을 때 무조건 stack.pop()을 하면 안 되고,
스택에 값이 정확히 1개 남아 있을 때만 정상 결과로 처리했으면 좋았을 것 같다.

*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class swea_4874 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            sb.append("#").append(tc+1).append(" ");
            Deque<Integer> stack = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean flag = true;
            while(st.hasMoreTokens()) {
                String thing = st.nextToken();
                switch (thing) {
                    case "+":
                        if (stack.size() >= 2) {
                            int b = stack.pop();
                            int a = stack.pop();
                            stack.push(a + b);
                        } else {
                            flag = false;
                        }
                        break;
                    case "-":
                        if (stack.size() >= 2) {
                            int b = stack.pop();
                            int a = stack.pop();
                            stack.push(a - b);
                        } else {
                            flag = false;
                        }
                        break;
                    case "*":
                        if (stack.size() >= 2) {
                            int b = stack.pop();
                            int a = stack.pop();
                            stack.push(a * b);
                        } else {
                            flag = false;
                        }
                        break;
                    case "/":
                        if (stack.size() >= 2) {
                            int b = stack.pop();
                            int a = stack.pop();
                            stack.push(a / b);
                        } else {
                            flag = false;
                        }
                        break;

                    case "%":
                        if (stack.size() >= 2) {
                            int b = stack.pop();
                            int a = stack.pop();
                            stack.push(a % b);
                        } else {
                            flag = false;
                        }
                        break;
                    case ".":
                        sb.append(stack.pop());
                        break;
                    default:
                        stack.push(Integer.parseInt(thing));
                }
                if (!flag) {
                    sb.append("error");
                    break;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
