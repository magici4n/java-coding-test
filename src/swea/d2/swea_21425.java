/*
[문제]
SWEA 21425 - +=

[분류]
구현 / 반복문 / 그리디

[접근]
두 정수 A, B가 주어졌을 때,
연산 A += B 또는 B += A를 원하는 순서대로 수행할 수 있다.

목표는 A 또는 B 중 하나가 N을 초과할 때까지 필요한 최소 연산 횟수를 구하는 것이다.

최소 횟수를 만들기 위해서는 매번 두 수 중 더 작은 값에 더 큰 값을 더한다.

이유:
- 큰 값에 작은 값을 더하면 작은 값만큼만 증가한다.
- 작은 값에 큰 값을 더하면 큰 값만큼 증가한다.
- 따라서 더 작은 쪽을 빠르게 키워야 이후 연산에서도 큰 수끼리 더해지는 흐름이 만들어진다.

[시간복잡도]
O(log N)

매 연산마다 작은 값에 큰 값을 더하면서 수가 빠르게 증가한다.
피보나치 수열처럼 커지기 때문에 반복 횟수는 대략 log N 수준이다.

[핵심 포인트]
문제의 “원하는 순서대로”는 두 연산을 번갈아 고정 수행한다는 뜻이 아니다.



[피드백]
처음 풀이에서는 문제를 제대로 이해하지 못해.
A += B, B += A 순서가 고정되어 풀었다.
문제를 좀더 꼼꼼히 읽고 잘 이해하려는 습관이 필요하다.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_21425 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int count = 0;

            while(!(A > N || B > N)){
                if(A <= B){
                    A+=B;
                }else{
                    B+=A;
                }
                count++;

            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
