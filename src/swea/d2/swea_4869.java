/*
[문제]
SWEA 4869 – 종이붙이기

[분류]
DP / 점화식 / 타일링

[접근]
20 x N 크기의 공간을 채우는 방법의 수를 구하는 문제이다.
N은 10의 배수이므로 n = N / 10으로 바꿔서 생각한다.

dp[i]를 20 x (10 * i) 크기를 채우는 방법의 수라고 정의한다.

맨 오른쪽을 기준으로 보면,
1. 마지막 10칸에 10x20 종이 1개를 세로로 붙이는 경우 → dp[i - 1]
2. 마지막 20칸에 20x20 종이 1개 또는 10x20 종이 2개를 가로로 붙이는 경우 → 2 * dp[i - 2]

따라서 점화식은
dp[i] = dp[i - 1] + 2 * dp[i - 2]

[시간복잡도]
O(N)

정확히는 N / 10만큼 반복하므로 O(N / 10)이지만,
상수는 제거하므로 O(N)으로 볼 수 있다.

[핵심 포인트]
- N을 그대로 쓰지 말고 N / 10으로 줄여서 생각한다.
- dp[1] = 1
- dp[2] = 3
- dp[i] = dp[i - 1] + 2 * dp[i - 2]
- 마지막 20칸을 채우는 방법은 3가지처럼 보이지만,
  세로 종이 2개를 붙이는 경우는 dp[i - 1]에 이미 포함되므로 중복해서 세지 않는다.
- n = 1인 경우 dp[2]를 넣으면 배열 범위 오류가 날 수 있으므로 배열 크기를 넉넉하게 잡거나 예외 처리가 필요하다.

[피드백]
처음에는 마지막 20칸을 기준으로 생각할 때,
10x20 종이 2개를 세로로 배치하는 경우까지 포함해서 3가지라고 헷갈릴 수 있다.

하지만 점화식에서는 경우를 중복 없이 나누는 것이 중요하다.

dp[i - 1]은 이미 마지막에 세로 종이 1개를 붙이는 모든 경우를 포함한다.
따라서 dp[i - 2] 뒤에 붙이는 경우에서는
20x20 종이 1개와 10x20 종이 2개를 가로로 눕히는 경우만 따로 세면 된다.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_4869 {

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int n = N/10;
            int []dp = new int[31];
            dp[1] = 1;
            dp[2] = 3;

            for(int i = 3; i<31; i++) {
                dp[i] = dp[i-1] + 2*dp[i-2];
            }

            sb.append("#").append(tc+1).append(" ").append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}