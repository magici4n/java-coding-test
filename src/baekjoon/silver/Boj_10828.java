/*
[문제]
BOJ 10828 - 스택

[분류]
구현 / 스택

[접근]
이 문제를 어떤 방식으로 풀었는지 한두 줄로 적기

[시간복잡도]
O(N)- N에따라서 명령을 N번 처리
각 명령 push,pop,size,isEmpty,top등은 모두 O(1)이기때문

[핵심 포인트]
- 자바에서는 `Deque`와 `ArrayDeque`로 스택을 구현할 수 있다.
- 문자열 비교는 `==`가 아니라 `equals()`를 사용해야 한다.
- 출력이 많을 때는 `System.out.println()`을 반복하기보다 `StringBuilder`에 모아 한 번에 출력하는 방법이 좋다.


[피드백]
자바에서의 Stack을 좀 익혀야 할 필요가 있음.
StringTokenizer활용 생각해보기
StringBuilder 활용 생각해보기
if -else 문이 더 좋을지 switch 문이 좋을지 생각해보기.

*/


package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_10828 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);

            }else if(command.equals("pop")){
                if(stack.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(stack.pop());
                }
            }else if(command.equals("size")){
                sb.append(stack.size());
            }else if(command.equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
            }else if(command.equals("top")){
                if(stack.isEmpty()){
                   sb.append(-1);
                }else{
                    sb.append(stack.peek());
                }
            }
        }
        System.out.println(sb);
    }
}