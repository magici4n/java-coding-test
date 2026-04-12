/*
[문제]
BOJ 11866 - 요세푸스 문제 0

[분류]
구현 / 큐

[접근]
1부터 N까지 덱에 넣고, 앞에서 K-1개를 뒤로 보내고 K번째 원소를 제거하는 과정을 반복했다.

[시간복잡도]
O(NK)

[핵심 포인트]
- 앞의 원소를 뒤로 보내는 연산: offerLast(pollFirst())
- K번째 원소 제거: pollFirst()
- 출력 형식은 <1, 2, 3> 형태로 맞춰야 한다
- 마지막 원소 뒤에는 ", "를 붙이지 않도록 처리해야 한다

[피드백]
- Deque말고 queue로도 가능
- count 변수와 마지막 원소 예외 처리가 들어가서 코드가 조금 복잡해졌다
- K-1번 회전 후 1번 제거하는 구조로 쓰면 더 직관적이다
for (int j = 1; j < K; j++) {
    dq.offerLast(dq.pollFirst());
}
sb.append(dq.pollFirst());
- 반복 조건은 for(N번)보다 while(!dq.isEmpty())가 문제 의미를 더 잘 드러낸다

*/

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Boj_11866 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 1; i<=N; i++){
            dq.offerLast(i);
        }
        sb.append("<");
        for(int i = 0; i<N; i++){
            int count = 1;
            for(int j = 0; j< K; j++){
                if (dq.size() == 1){
                    sb.append(dq.pollFirst());
                    break;
                }
                if(count == K){
                    sb.append(dq.pollFirst()).append(", ");
                }else{
                    count++;
                    dq.offerLast(dq.pollFirst());
                }
            }
        }
        sb.append(">");
        System.out.print(sb);

    }
}
