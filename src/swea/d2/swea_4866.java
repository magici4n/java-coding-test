/*
[문제]
SWEA 4866 - 괄호검사

[분류]
스택 / 문자열 / 구현

[접근]
문자열을 왼쪽부터 한 글자씩 확인한다.
여는 괄호 '(' 또는 '{'는 스택에 넣는다.
닫는 괄호 ')' 또는 '}'가 나오면 스택이 비어 있는지 먼저 확인하고,
비어 있지 않다면 스택의 top이 현재 닫는 괄호와 짝이 맞는지 검사한다.
짝이 맞지 않으면 올바르지 않은 문자열이므로 0을 출력한다.
모든 문자를 확인한 뒤 스택에 여는 괄호가 남아 있으면 닫히지 않은 괄호가 있는 것이므로 0을 출력한다.
정상적으로 모두 처리되면 1을 출력한다.

[시간복잡도]
O(N)
- 문자열의 각 문자를 한 번씩만 확인한다.

[핵심 포인트]
1. 괄호 검사는 스택을 사용한다.
2. 여는 괄호는 push한다.
3. 닫는 괄호가 나오면 stack이 비었는지 먼저 확인해야 한다.
4. stack의 top과 현재 닫는 괄호가 짝이 맞아야 한다.
5. 반복문이 끝난 뒤 stack이 비어 있어야 올바른 괄호 문자열이다.

[피드백]
처음에 푼 코드는 코드내에서 반복성이 잦은 코드였다.
그리고 무의미한 while문도 들어가있었다.
코드를 짤 때 생각나는대로 짜지말고 생각하면서 짜자.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class swea_4866 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            Deque<Character> stack = new ArrayDeque<>();
            String sentence = br.readLine();
            int result = 1;

            for(int i = 0; i< sentence.length(); i++){
                char c = sentence.charAt(i);

                if(c == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        result = 0;
                        break;
                    }
                }else if(c == '}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        result = 0;
                        break;
                    }
                }else if(c=='(' || c == '{') {
                    stack.push(c);
                }
            }
            if(!stack.isEmpty()){
                result = 0;
            }
            sb.append("#").append(tc+1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
