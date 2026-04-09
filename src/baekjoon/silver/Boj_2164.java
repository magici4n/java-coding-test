/*
[문제]
BOJ 2164 - 카드 2

[분류]
구현 / 덱

[접근]
Deque를 사용했고, 덱의 뒤쪽을 카드의 맨 위로 보도록 방향을 잡아 pollLast와 offerFirst로 처리했다.

[시간복잡도]
O(N)

[핵심 포인트]
- Deque를 큐처럼 사용할 때 어느 쪽을 front로 볼지 일관되게 정하기

[피드백]
나는 덱을 생각하고 구현하였는데 큐로 보아도 충분히 푸는 문제였다.
for문으로 N-1번 반복해도 되지만 while(size > 1)이 문제 의미를 더 잘 드러낸다
*/

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj_2164 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i= 1; i<N+1; i++){
            dq.offerFirst(i);
        }
        for(int i= 1; i<N; i++){
            dq.pollLast();
            dq.offerFirst(dq.pollLast());
        }

        System.out.print(dq.poll());
    }
}
