/*
[문제]
SWEA 2001 - 파리 퇴치

[분류]
완전탐색 / 2차원 배열 / 구현

[접근]
M x M 파리채가 들어갈 수 있는 모든 시작 좌표를 탐색했다.
각 시작점마다 M x M 범위의 값을 직접 더해서 합을 구하고,
그중 최댓값을 정답으로 출력했다.

[시간복잡도]
O((N-M+1)^2 * M^2)

[핵심 포인트]
- 파리채 시작 위치는 행, 열 모두 0 ~ N-M까지 탐색
- 각 위치마다 M x M 범위를 직접 순회하며 합 계산
- 테스트케이스별 최댓값 갱신

[피드백]
- 완전탐색 접근을 정확하게 구현했다.
- 시작 좌표 범위를 <= N-M으로 잘 잡았다.
- sum 초기화도 올바르게 처리했다.
- 다만 NN 같은 변수명은 의미가 잘 드러나지 않아 map, grid 같은 이름이 더 가독성이 좋다.
- sum은 바깥에서 재사용하는 대신 각 시작점 안에서 새로 선언하면 더 직관적이다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2001 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int [][] NN = new int[N][N];
            sb.append("#").append(i+1).append(" ");
            for(int j = 0; j<N; j++){
                StringTokenizer stN = new StringTokenizer(br.readLine());
                for(int q = 0; q<N; q++){
                    NN[j][q] = Integer.parseInt(stN.nextToken());
                }
            }
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int a = 0; a<=N-M; a++){
                for(int b = 0; b<=N-M; b++){
                    for(int c = a; c<a+M; c++){
                        for(int d = b; d<b+M; d++){
                            sum += NN[c][d];
                        }
                    }
                    if (sum > max){
                        max = sum;
                    }
                    sum = 0;
                }
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}
