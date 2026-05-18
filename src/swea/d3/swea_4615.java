/*
[문제]
SWEA 4615 - 재미있는 오셀로 게임

[분류]
구현 / 시뮬레이션 / 2차원 배열 / 방향 탐색

[접근]
오셀로 판을 2차원 배열로 만들고, 처음 가운데 4개의 돌을 배치한다.
이후 입력으로 들어오는 위치에 돌을 놓은 뒤, 8방향을 확인한다.

각 방향마다 바로 옆 칸이 범위 안에 있고, 빈 칸이 아니며, 내 색이 아니면
상대 돌이 있다고 판단하고 그 방향으로 계속 탐색한다.

탐색 중 같은 색 돌을 만나면 그 사이의 돌들을 현재 색으로 뒤집는다.
범위를 벗어나거나 빈 칸을 만나면 해당 방향은 뒤집지 않는다.

[시간복잡도]
O(M * 8 * N)

M개의 돌을 놓을 때마다 8방향을 검사한다.
각 방향에서 최악의 경우 N칸 정도 이동할 수 있으므로 전체 시간복잡도는 O(M * N) 정도로 볼 수 있다.

[핵심 포인트]
1. 오셀로는 처음 중앙 4칸에 돌이 놓인 상태로 시작한다.

초기 배치:
map[N/2 - 1][N/2 - 1] = 2;
map[N/2][N/2] = 2;
map[N/2 - 1][N/2] = 1;
map[N/2][N/2 - 1] = 1;

2. 입력은 열, 행, 색 순서로 들어온다.
문제 입력이 col, row 순서이므로 배열에 접근할 때는 row, col 순서로 바꿔야 한다.

int col = Integer.parseInt(st.nextToken());
int row = Integer.parseInt(st.nextToken());
col--;
row--;

put(row, col, color);

3. 8방향 탐색을 위해 dr, dc 배열을 사용한다.

static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
static int[] dc = { 0,  1, 1, 1, 0,-1,-1, -1};

4. 배열 범위 체크는 반드시 OR 조건으로 해야 한다.

잘못된 예:
row < 0 && row >= N

올바른 예:
row < 0 || row >= N || col < 0 || col >= N

또는:
return row >= 0 && row < N && col >= 0 && col < N;

5. 돌을 뒤집을 때는 k가 아니라 j를 사용해야 한다.

for (int j = 1; j < k; j++) {
    map[row + dr[i] * j][col + dc[i] * j] = color;
}

[피드백]
처음에는 index_check 조건에서 &&를 사용해서 범위 밖 좌표를 제대로 걸러내지 못했다.
인덱스 검사는 하나라도 범위를 벗어나면 false가 되어야 하므로 ||를 사용해야 한다.

현재 코드가 좋은 코드가 아니란건 안다.
put 함수 안에서 row + dr[i] * k, col + dc[i] * k 계산이 반복되어 가독성이 떨어진다.
나중에는 nr, nc, nextR, nextC 같은 변수를 사용해서
좌표 계산 → 범위 체크 → 배열 접근 순서가 명확하게 보이도록 리팩토링하면 더 좋은 코드가 된다는 것을 참고하자.
*/
package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4615 {

    static int N;
    static int[][]map;
    static int [] dr = {-1,-1, 0, 1, 1,  1,  0, -1};
    static int [] dc = { 0, 1, 1, 1, 0, -1, -1, -1};

    static void put(int row, int col, int color) {
        map[row][col] = color;

        for(int i = 0; i< 8; i++) {
            if(!index_check(row+dr[i],col+dc[i])) {
                continue;
            }
            if(map[row+dr[i]][col+dc[i]]!= 0 && map[row+dr[i]][col+dc[i]]!= color) {
                int k = 2;
                boolean flag = true;
                if(!index_check(row+dr[i]*k,col+dc[i]*k)) {
                    continue;
                }
                while(map[row+dr[i]*k][col+dc[i]*k] != color) {
                    if(!index_check(row+dr[i]*k,col+dc[i]*k)||map[row+dr[i]*k][col+dc[i]*k] == 0) {
                        flag = false;
                        break;
                    }
                    k++;
                    if(!index_check(row+dr[i]*k,col+dc[i]*k)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j = 1; j < k; j++) {
                        map[row+dr[i]*j][col+dc[i]*j] = color;
                    }
                }
            }
        }
    }
    static boolean index_check(int row, int col) {
        if(row <0 || row >=N || col <0 || col>=N) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int count_1 = 0;
            int count_2 = 0;
            map = new int[N][N];
            map[N/2 - 1][N/2 - 1] = 2;
            map[N/2][N/2] = 2;
            map[N/2 - 1][N/2] = 1;
            map[N/2][N/2 - 1] = 1;

            for(int i = 0; i<M; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st1.nextToken());
                int row = Integer.parseInt(st1.nextToken());
                col--; row--;

                int color = Integer.parseInt(st1.nextToken());

                put(row,col,color);
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j<N; j++) {
                    if(map[i][j] == 1) {
                        count_1++;
                    }else if(map[i][j]== 2) {
                        count_2++;
                    }

                }
            }
            sb.append("#").append(tc+1).append(" ").append(count_1).append(" ").append(count_2).append("\n");
        }
        System.out.print(sb);
    }
}
