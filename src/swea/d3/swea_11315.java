/*
[문제]
SWEA 11315 - 오목 판정

[분류]
구현 / 배열 / 완전탐색 / 방향 배열

[접근]
N x N 바둑판에서 'o'가 5개 이상 연속으로 놓여 있는지 확인하는 문제이다.

모든 칸을 시작점으로 잡고, 해당 칸이 'o'인 경우에만 4방향을 검사한다.

검사할 방향은 다음 4개이다.

1. 오른쪽
2. 아래
3. 오른쪽 아래 대각선
4. 왼쪽 아래 대각선

모든 칸을 시작점으로 검사하기 때문에 반대 방향인 왼쪽, 위, 왼쪽 위, 오른쪽 위는 따로 검사하지 않아도 된다.

각 방향마다 현재 칸부터 5칸을 확인하면서 모두 'o'이면 오목이 존재하므로 YES를 출력한다.
범위를 벗어나거나 중간에 '.'이 나오면 해당 방향 검사를 중단한다.

[시간복잡도]
O(N^2)

모든 칸을 한 번씩 시작점으로 확인하고,
각 칸마다 4방향, 각 방향마다 최대 5칸만 검사한다.

정확히는 O(N^2 * 4 * 5)이지만,
4와 5는 상수이므로 O(N^2)이다.

[핵심 포인트]
방향 배열을 사용하면 가로, 세로, 대각선 검사를 하나의 로직으로 처리할 수 있다.

int[] dr = {0, 1, 1, 1};
int[] dc = {1, 0, 1, -1};

각 방향의 의미는 다음과 같다.

dr[0] = 0, dc[0] = 1  -> 오른쪽
dr[1] = 1, dc[1] = 0  -> 아래
dr[2] = 1, dc[2] = 1  -> 오른쪽 아래
dr[3] = 1, dc[3] = -1 -> 왼쪽 아래

다음 좌표는 아래 공식으로 구한다.

int nr = r + dr[d] * k;
int nc = c + dc[d] * k;

여기서
r, c는 시작 위치,
d는 방향,
k는 현재 방향으로 몇 칸 이동했는지를 의미한다.

[피드백]
처음 풀이에서는 가로, 세로, 대각선을 각각 따로 나누어 검사했다.
접근 자체는 맞았지만, 대각선 검사를 여러 경우로 나누면서 코드가 길어지고,
flag 관리와 break 위치가 복잡해졌다.

특히 대각선은 좌표 계산이 조금만 틀려도 특정 경우를 놓칠 수 있기 때문에,
직접 모든 경우를 나누기보다는 방향 배열을 사용하는 것이 훨씬 안전하다.

이번 문제에서 기억할 점은 다음과 같다.

"격자에서 여러 방향을 검사해야 하면 방향 배열을 먼저 떠올리자."

앞으로 오목, 빙고, 단어 찾기, 미로 탐색처럼
상하좌우 또는 대각선 방향을 확인하는 문제에서는
dr, dc 배열을 활용하면 코드가 훨씬 짧고 안정적이다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_11315{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] dr = {0, 1, 1, 1};
        int[] dc = {1, 0, 1, -1};

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            char[][] map = new char[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            boolean found = false;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {

                    if (map[r][c] != 'o') {
                        continue;
                    }

                    for (int d = 0; d < 4; d++) {
                        int count = 0;

                        for (int k = 0; k < 5; k++) {
                            int nr = r + dr[d] * k;
                            int nc = c + dc[d] * k;

                            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                                break;
                            }

                            if (map[nr][nc] == 'o') {
                                count++;
                            } else {
                                break;
                            }
                        }

                        if (count == 5) {
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        break;
                    }
                }

                if (found) {
                    break;
                }
            }

            sb.append("#").append(tc).append(" ");

            if (found) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }
}