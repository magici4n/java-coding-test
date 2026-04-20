/*
[문제]
SWEA 1954 - 달팽이 숫자

[분류]
구현 / 시뮬레이션 / 2차원 배열

[접근]
방향을 4개로 나누고, 현재 채울 수 있는 경계값(xmin, xmax, ymin, ymax)을 관리하면서
한 방향씩 끝까지 채운 뒤 경계를 줄여가며 달팽이 모양으로 숫자를 채웠다.

[시간복잡도]
O(N^2)

[핵심 포인트]
- 한 방향으로 끝까지 이동 후 방향 전환
- 방향 전환 후에는 다음 탐색을 위해 현재 위치 보정
- 한 바퀴 돌 때마다 해당 방향의 경계를 줄여야 함

[피드백]
- 경계값을 줄여가며 구현한 점이 좋다.
- 달팽이 문제의 핵심인 방향 전환과 범위 조절을 잘 이해했다.
- 다만 map[x][y]로 저장하면서 출력은 map[q][k]로 하고 있어 좌표 체계가 직관적이지 않다.
- row, col 기준으로 일관되게 작성하면 더 읽기 쉬운 코드가 된다.
- while(value <= N*N) 형태가 조금 더 자연스럽다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1954 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++){
            sb.append("#").append(i+1).append("\n");
            int N = Integer.parseInt(br.readLine());
            int [][]map = new int[N][N];

            int xmax = N-1;
            int xmin = 0;
            int xcur = 0;

            int ymax = N-1;
            int ymin = 0;
            int ycur = 0;

            int flag = 1;
            int value = 1;

            while(value != N*N+1) {

                switch (flag) {
                    case 1:
                        for (; xcur <= xmax; xcur++) {
                            map[xcur][ycur] = value;
                            value++;
                        }
                        xcur--;
                        ycur++;
                        ymin++;
                        flag++;
                        break;
                    case 2:
                        for (; ycur <= ymax; ycur++) {
                            map[xcur][ycur] = value;
                            value++;
                        }
                        ycur--;
                        xcur--;
                        xmax--;
                        flag++;
                        break;
                    case 3:
                        for (; xcur >= xmin; xcur--) {
                            map[xcur][ycur] = value;
                            value++;
                        }
                        xcur++;
                        ycur--;
                        ymax--;
                        flag++;
                        break;
                    case 4:
                        for (; ycur >= ymin; ycur--) {
                            map[xcur][ycur] = value;
                            value++;
                        }
                        ycur++;
                        xcur++;
                        xmin++;
                        flag = 1;
                        break;
                }
            }
            for(int k = 0; k<N; k++){
                for(int q = 0; q<N; q++){
                    sb.append(map[q][k]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
