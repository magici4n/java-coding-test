/*
[문제]
SWEA 5215 - 햄버거 다이어트

[분류]
DP / 0-1 Knapsack / 배낭 문제

[접근]
각 재료는 한 번만 사용할 수 있으므로 0/1 Knapsack 방식으로 접근한다.

재료마다 점수와 칼로리가 주어진다.
제한 칼로리 L을 넘지 않으면서 얻을 수 있는 최대 점수를 구해야 한다.

dp[i][w]를 다음과 같이 정의한다.

dp[i][w] = i번째 재료까지 고려했을 때,
           칼로리 제한이 w일 때 얻을 수 있는 최대 점수

i번째 재료를 볼 때 선택지는 두 가지이다.

1. i번째 재료를 넣지 않는 경우
   dp[i - 1][w]

2. i번째 재료를 넣는 경우
   dp[i - 1][w - weight[i]] + value[i]

단, i번째 재료를 넣으려면 현재 칼로리 제한 w가 weight[i] 이상이어야 한다.

따라서 현재 재료를 넣을 수 없는 경우에는 이전 값을 그대로 가져오고,
넣을 수 있는 경우에는 넣는 경우와 넣지 않는 경우 중 더 큰 값을 선택한다.

[점화식]
if (w < weight[i]) {
    dp[i][w] = dp[i - 1][w];
} else {
    dp[i][w] = Math.max(
        dp[i - 1][w],
        dp[i - 1][w - weight[i]] + value[i]
    );
}

[시간복잡도]
O(N * L)

N개의 재료에 대해, 각 재료마다 1부터 L까지의 칼로리 제한을 확인하므로
시간복잡도는 O(N * L)이다.

[공간복잡도]
O(N * L)

2차원 dp 배열을 사용하므로 공간복잡도는 O(N * L)이다.

[핵심 포인트]
- 이 문제는 대표적인 0/1 Knapsack 문제이다.
- 각 재료는 한 번만 사용할 수 있다.
- value 배열에는 맛 점수, weight 배열에는 칼로리를 저장한다.
- dp[i][w]는 i번째 재료까지 고려했을 때 칼로리 제한 w에서 얻을 수 있는 최대 점수이다.
- 현재 재료를 넣는 경우와 넣지 않는 경우를 비교해야 한다.
- 현재 재료를 넣는 경우에는 dp[i - 1][w - weight[i]] + value[i]를 사용한다.
- dp[i - 1]을 사용하는 이유는 같은 재료를 중복으로 사용하면 안 되기 때문이다.
- 최종 정답은 dp[N][L]이다.

[피드백]
0/1 knapsack의 표준 문제 같다.
잘 기억하자.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5215 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int [] value = new int[N+1];
            int [] weight = new int[N+1];

            for(int i = 1; i<= N; i++){
                StringTokenizer info = new StringTokenizer(br.readLine());
                value[i] = Integer.parseInt(info.nextToken());
                weight[i] = Integer.parseInt(info.nextToken());
            }

            int [][] dp = new int[N+1][L+1];

            for(int i = 1; i<= N; i++){
                for(int w = 1; w<=L; w++){

                    if(w < weight[i]){
                        dp[i][w] = dp[i-1][w];
                    }else{
                        dp[i][w] = Math.max(
                                dp[i-1][w-weight[i]]+value[i],dp[i-1][w]
                        );
                    }
                }
            }
            sb.append("#").append(tc+1).append(" ").append(dp[N][L]).append("\n");
        }
        System.out.print(sb);
    }
}
