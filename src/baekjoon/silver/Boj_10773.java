/*
[문제]
BOJ 10773 - 제로

[분류]
구현 / 스택

[접근]
수를 하나씩 입력받으면서 0이 아니면 스택에 넣고, 0이면 가장 최근에 넣은 수를 꺼냄.
그후 스택에 남아있는 수를 더해서 최종합 도출.

[시간복잡도]
O(N)
- K개의 입력을 한 번씩 처리하므로 O(K)
- 이후 스택에 남은 값들을 합하는 과정도 최대 O(K)

[핵심 포인트]
가장 최근 값을 취소해야 하므로 스택을 사용한다.

[피드백]

if (n == 0) {
    sum -= stack.pop();
} else {
    stack.push(n);
    sum += n;
}
마지막에 스택을 다시 순회해서 합을 구했는데,
위와 같이 입력받는 동안 sum을 같이 관리하면 더 효율적으로 작성할 수도 있다.
*/
package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj_10773 {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer>stack = new ArrayDeque<>();

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i<K; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                stack.pop();
            }else{
                stack.push(n);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.print(sum);
    }
}

