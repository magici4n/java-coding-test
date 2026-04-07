/*
[문제]
BOJ 9012 - 괄호

[분류]
구현 / 문자열 / 스택

[접근]
문자열을 왼쪽부터 확인하면서, '(' 는 스택에 넣고 ')' 가 나오면 스택에서 짝이 되는 '(' 를 꺼내는 방식으로 검사했다.
'('가 없거나, 마지막까지 확인한 뒤 스택이 남아 있으면 올바르지 않은 괄호 문자열로 판단했다.

[시간복잡도]
O(N)
-문자열 길이를 N이라고 할 때 각 문자를 한 번씩만 확인하므로 O(N)

[핵심 포인트]
-자바에서 스택은 `Deque<Character> stack = new ArrayDeque<>();` 로 구현
-StringBuilder로 출력할때 사이사이 줄바꿈이 필요하면 append에 ('\n')넣어야한다.

[피드백]
괄호 종류가 하나뿐이라면 스택 없이 count방식으로 풀 수 있다는 점.(count의 공간복잡도가 더 작음)
*/

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj_9012 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i<T; i++){
            boolean flag = true;
            Deque<Character> stack = new ArrayDeque<>();
            String VPS = br.readLine();
            for(int j = 0; j<VPS.length(); j++){
                if(VPS.charAt(j)=='('){
                    stack.push(VPS.charAt(j));
                }else if(VPS.charAt(j)==')'){
                    if (!stack.isEmpty()){
                        stack.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){
                flag = false;
            }
            if(flag) {
                sb.append("YES").append('\n');
            }else {
                sb.append("NO").append('\n');
            }
        }
    System.out.print(sb);
    }
}
