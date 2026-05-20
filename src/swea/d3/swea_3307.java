/*
[문제]
SWEA 3307 - 최장 증가 부분 수열

[분류]
DP / LIS / 최장 증가 부분 수열

[접근]
부분 수열은 원래 배열의 순서를 유지하면서 일부 원소를 선택하는 것이다.
dp[i]를 "A[i]를 마지막 원소로 하는 최장 증가 부분 수열의 길이"로 정의한다.

각 i에 대해, i보다 앞에 있는 모든 j를 확인한다.
만약 A[j] < A[i]라면 A[j] 뒤에 A[i]를 붙일 수 있으므로,
dp[i] = Math.max(dp[i], dp[j] + 1)로 갱신한다.

모든 dp[i] 중 최댓값이 정답이다.

[시간복잡도]
O(N^2)

바깥 반복문에서 i를 0부터 N-1까지 돌고,
각 i마다 앞에 있는 j들을 다시 확인하므로 O(N^2)이다.

[핵심 포인트]
1. 부분 수열은 순서를 바꾸는 것이 아니라, 원래 순서를 유지하면서 일부를 고르는 것이다.

예:
A = {1, 3, 2, 5, 4, 7}

가능:
1, 3, 5, 7
1, 2, 4, 7

불가능:
1, 2, 3, 7
이유: 원래 배열에서 3은 2보다 앞에 있었기 때문에 순서가 바뀐다.

2. 문제 설명의 B1, B2, ..., BK는 값이 아니라 선택한 인덱스이다.

B1 < B2 < ... < BK
→ 선택한 위치가 왼쪽에서 오른쪽 순서라는 뜻

A_B1 <= A_B2 <= ... <= A_BK
→ 선택한 위치의 값들이 증가해야 한다는 뜻

3. dp[i]의 의미를 정확히 잡는 것이 중요하다.

dp[i] = A[i]를 마지막으로 하는 증가 부분 수열의 최대 길이

4. 현재 값 A[i] 앞에 붙일 수 있는 값은 i보다 앞에 있으면서 A[i]보다 작은 값이다.

if (A[j] < A[i]) {
    dp[i] = Math.max(dp[i], dp[j] + 1);
}

단, 문제 조건이 비감소 수열처럼 A[j] <= A[i]를 허용한다면 <=를 사용한다.
일반적인 LIS, 즉 최장 증가 부분 수열은 보통 <를 사용한다.

[피드백]
처음 접근에서 DFS로 부분 수열을 직접 만들려고 한 방향 자체는 완전히 엉뚱하지 않았다.
하지만 문제의 B를 배열의 값으로 해석하면서 A[A[index] - 1]처럼 값을 다시 인덱스로 사용하는 방향으로 흐른 것이 핵심 오해였다.

이 문제에서 B는 "고른 값"이 아니라 "고른 위치"이다.
따라서 값을 다시 인덱스로 사용할 필요가 없고, 단순히 앞쪽 원소 A[j]와 현재 원소 A[i]를 비교하면 된다.

이번 문제에서 기억할 점은 다음과 같다.

- A_i는 A의 i번째 원소라는 뜻이다.
- A_Bi는 A의 Bi번째 원소라는 뜻이다.
- B는 선택한 인덱스 목록으로 보는 것이 자연스럽다.
- 부분 수열은 순서 유지가 핵심이다.
- LIS 문제는 dp[i] = i번째 원소를 마지막으로 하는 최대 길이로 접근하면 된다.

문제 해석에서 막힌 것은 실력 부족이라기보다,
알고리즘 문제에서 자주 쓰는 수학식 표현에 아직 익숙하지 않아서 생긴 오해이다.
다음에 비슷한 표현이 나오면 "B는 인덱스일 가능성이 높다"는 것을 먼저 의심하면 된다.
*/

package swea.d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3307 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st =new StringTokenizer(br.readLine());

            int [] A = new int[N];
            int [] dp = new int[N];
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            for(int i = 0;  i<N; i++) {
                dp[i] = 1;

                for(int j = 0; j <i; j++) {
                    if(A[j] < A[i]) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
                answer = Math.max(answer, dp[i]);
            }
            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
