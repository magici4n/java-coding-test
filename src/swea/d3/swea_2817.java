/*
[문제]
SWEA 2817 - 부분 수열의 합

[분류]
DFS / 백트래킹 / 부분집합 / 조합

[접근]
N개의 수 중에서 몇 개를 선택했을 때 합이 K가 되는 경우의 수를 구하는 문제이다.
현재 index부터 뒤쪽 숫자들을 하나씩 선택해보면서 DFS를 진행한다.

숫자를 선택하면 sum에 더하고,
재귀 호출이 끝나면 다시 sum에서 빼서 원상복구한다.

이미 합이 K가 되면 answer를 1 증가시키고,
합이 K를 초과하면 더 탐색하지 않고 가지치기한다.

[시간복잡도]
O(2^N)

각 원소는 선택하거나 선택하지 않는 경우가 있으므로
최악의 경우 모든 부분집합을 확인한다.

[핵심 포인트]
1. visited 배열은 필요 없다.
   dfs(i + 1)로 다음 인덱스부터 탐색하기 때문에
   이미 선택한 숫자를 다시 고르지 않는다.

2. 백트래킹 구조를 기억해야 한다.

   sum += A[i];
   dfs(i + 1);
   sum -= A[i];

3. 문제의 수가 양수이기 때문에 sum > K일 때 가지치기가 가능하다.

4. sum == K가 되면 정답을 증가시키고 return한다.
   이후 숫자를 더 선택하면 합이 더 커지기 때문에 더 볼 필요가 없다.

[피드백]
처음에는 visited 배열과 이중 for문을 사용하려고 해서 탐색 구조가 복잡해졌다.
이 문제는 중복 선택을 막기 위해 visited를 쓰는 문제가 아니라,
시작 인덱스를 넘겨주면서 조합을 만드는 방식으로 푸는 것이 더 자연스럽다.

핵심은 현재 위치 이후의 숫자만 선택하도록 dfs(i + 1)을 호출하는 것이다.
앞으로 부분집합, 조합, 부분수열의 합 문제에서는 이 백트래킹 패턴을 떠올리면 된다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2817 {


    static int N;
    static int sum;
    static int answer;
    static int K;
    static int [] A;
    static void dfs(int index) {

        if(sum == K) {
            answer++;
            return;
        }
        if(sum > K) {
            return;
        }

        for(int i = index; i < N; i++) {
            sum+= A[i];
            dfs(i+1);
            sum-= A[i];
        }

    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            sum = 0;
            answer = 0;

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            A = new int[N];
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st1.nextToken());
            }
            dfs(0);

            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

}

