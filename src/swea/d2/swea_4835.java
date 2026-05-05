/*
[문제]
SWEA 4835 – 구간합

[분류]
구현 / 배열 / 완전탐색 / 구간합

[접근]
N개의 숫자를 배열에 저장한다.
연속된 M개의 숫자를 하나의 구간으로 보고, 가능한 모든 구간의 합을 구한다.

시작 인덱스 i를 0부터 N-M까지 이동시키면서
i부터 i+M-1까지의 합을 계산한다.

각 구간합을 구할 때마다 최댓값과 최솟값을 갱신하고,
마지막에 최댓값 - 최솟값을 출력한다.

[시간복잡도]
O(N * M)

시작 위치는 총 N-M+1개이고,
각 시작 위치마다 M개의 숫자를 더하므로
O((N-M+1) * M)이다.

대략적으로 O(N * M)으로 볼 수 있다.

[핵심 포인트]
연속된 M개의 합을 구해야 하므로
시작 인덱스의 범위는 0부터 N-M까지이다.

[피드백]
구간합 문제는 나중에 슬라이딩 윈도우 방식으로도 풀 수 있다.

*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4835 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int [] nums = new int[N];
            for(int i = 0; i<N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<=N-M; i++){
                int sum = 0;

                for(int j = i; j<i+M; j++){
                    sum += nums[j];
                }

                max = Math.max(sum,max);
                min = Math.min(sum,min);
            }
            sb.append("#").append(tc+1).append(" ").append(max-min).append("\n");
        }
        System.out.print(sb);
    }
}
