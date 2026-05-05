/*
[문제]
SWEA 4881 – 배열 최소 합

[분류]
DFS / 백트래킹 / 완전탐색 / 가지치기

[접근]
N x N 배열에서 각 행마다 숫자를 하나씩 선택한다.
단, 같은 열에서는 두 개 이상의 숫자를 선택할 수 없다.

따라서 row를 기준으로 한 줄씩 내려가며 숫자를 선택하고,
이미 선택한 열은 visited[col] 배열로 표시해서 다시 선택하지 않도록 한다.

dfs(row, sum) 형태로 재귀를 사용한다.

row는 현재 선택할 행을 의미하고,
sum은 지금까지 선택한 숫자들의 합을 의미한다.

모든 행에서 숫자를 하나씩 선택하면 row == N이 되고,
이때 answer와 sum을 비교해서 최소값을 갱신한다.

[시간복잡도]
O(N!)

각 행마다 하나의 열을 선택해야 하고,
이미 선택한 열은 다시 선택할 수 없으므로 경우의 수는

N * (N-1) * (N-2) * ... * 1

즉 O(N!)이다.

다만 sum이 이미 현재 answer 이상이면 더 탐색하지 않는 가지치기를 사용하면
실제 탐색량은 줄어든다.

[핵심 포인트]
이 문제는 각 행에서 하나씩 선택하고,
열 중복을 막아야 하므로 visited[col]이 필요하다.

DFS 함수는 다음 형태로 생각하면 된다.

dfs(row, sum)

row: 현재 몇 번째 행을 선택 중인지
sum: 지금까지 선택한 숫자들의 합

백트래킹의 기본 구조는 다음과 같다.

visited[col] = true;    // 선택
dfs(row + 1, sum + map[row][col]);  // 다음 행으로 이동
visited[col] = false;   // 선택 취소

visited[col] = false를 하는 이유는
현재 선택으로 만들 수 있는 경우를 모두 확인한 뒤,
다른 열을 선택하는 경우도 탐색하기 위해 원상복구하는 것이다.

가지치기는 다음과 같이 할 수 있다.

if (sum >= answer) {
    return;
}

이미 현재 최소값보다 합이 크거나 같다면,
앞으로 숫자를 더 선택해도 최소값이 될 수 없으므로 더 탐색하지 않는다.

[피드백]
이 문제는 D2라고 되어 있지만 체감 난이도는 낮지 않다.
단순 배열 순회 문제가 아니라 DFS, visited 배열, 백트래킹, 가지치기 개념이 함께 들어간다.

처음부터 혼자 풀이를 떠올리지 못해도 괜찮은 문제다.
중요한 것은 코드를 따라 작성하면서 재귀 호출의 흐름을 이해하는 것이다.

특히 다음 세 가지를 기억하면 된다.

1. row를 하나씩 증가시키며 각 행에서 숫자를 고른다.
2. 같은 열을 다시 고르지 않기 위해 visited[col]을 사용한다.
3. 재귀 호출 후 visited[col] = false로 원상복구해야 다른 경우도 탐색할 수 있다.

이번 문제에서 배운 핵심은
"선택한다 → 다음 단계로 간다 → 선택을 취소한다"
라는 백트래킹의 기본 구조다.

다음에 비슷한 문제가 나오면
각 행에서 하나씩 고르거나,
중복 없이 선택해야 하거나,
모든 경우 중 최소/최대를 구해야 하는 조건을 보고
DFS + visited + 백트래킹을 떠올리면 된다.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4881 {
    static int N;
    static int [][] map;
    static boolean[] visited;
    static int answer;

    static void dfs(int row, int sum) {
        //가지치기 : 이미 현재 최소값보다 크면 더 볼 필요 없음
        if(sum>answer){
            return;
        }

        // 모든 행에서 하나씩 골랐다면 최소값 갱신
        if(row == N){
            answer = Math.min(answer,sum);
            return;
        }

        // 현재 row 행에서 사용할 열 선택
        for(int col = 0; col < N; col++){
            if(!visited[col]){
                visited[col] = true;
                dfs(row + 1, sum + map[row][col]);
                visited[col] = false; // 원상복구
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<= T; tc++){
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N];
            answer = Integer.MAX_VALUE;

            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j = 0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0,0);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
    }
}