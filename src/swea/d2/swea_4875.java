/*
[문제]
SWEA 4875 – 미로

[분류]
DFS / 백트래킹 / 그래프 탐색 / 2차원 배열 탐색

[접근]
N x N 미로에서 출발점 2에서 시작해 도착점 3에 도달할 수 있는지 확인한다.

미로의 의미는 다음과 같다.

0: 이동 가능한 길
1: 벽
2: 출발점
3: 도착점

입력을 받으면서 출발점 2의 위치를 저장한다.
그 후 DFS를 이용해 상하좌우로 이동하면서 도착점 3을 찾는다.

이미 방문한 칸은 visited 배열로 표시해서 다시 방문하지 않도록 한다.
도착점 3을 만나면 answer를 1로 바꾸고 탐색을 종료한다.

[시간복잡도]
O(N^2)

최악의 경우 미로의 모든 칸을 한 번씩 방문할 수 있다.
각 칸에서 상하좌우 4방향을 확인하지만, 4는 상수이므로 전체 시간복잡도는 O(N^2)이다.

[핵심 포인트]
2차원 배열에서 상하좌우 이동은 row, col 변화로 표현한다.

상: row - 1
하: row + 1
좌: col - 1
우: col + 1

방향 배열을 사용하면 코드를 더 깔끔하게 만들 수 있다.

static int[] dr = {-1, 1, 0, 0};
static int[] dc = {0, 0, -1, 1};

다음 위치는 다음처럼 계산한다.

int nr = row + dr[d];
int nc = col + dc[d];

DFS 이동 전에는 세 가지를 확인해야 한다.

1. 배열 범위를 벗어나지 않는지
2. 이미 방문한 칸이 아닌지
3. 벽이 아닌지

조건 예시는 다음과 같다.

if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
if (visited[nr][nc]) continue;
if (map[nr][nc] == 1) continue;

그 후 이동 가능한 칸이면 dfs(nr, nc)를 호출한다.

[피드백]
처음 작성한 코드에서 핵심 구조는 잘 잡았다.
출발점을 찾고, visited 배열을 사용하고, DFS로 미로를 탐색하려는 방향은 맞았다.

다만 처음에는 이동 가능한 위치를 확인한 뒤에도 dfs(row, col)처럼 현재 위치를 다시 호출하는 문제가 있었다.
이 부분을 dfs(row, col - 1), dfs(row + 1, col)처럼 실제 다음 위치로 이동하도록 수정하면서 정답 코드가 되었다.

또한 처음에는 map[nextRow][nextCol] == 0인 경우만 이동하려고 했는데,
도착점은 3이기 때문에 0만 허용하면 도착점으로 들어갈 수 없다.
따라서 벽이 아닌 칸, 즉 map[nr][nc] != 1 조건으로 처리하는 것이 좋다.

현재 풀이도 정답이지만, 네 방향을 if문으로 각각 작성하면 코드가 길어지고 row/col 방향을 헷갈릴 수 있다.
앞으로 2차원 DFS/BFS 문제에서는 방향 배열 dr, dc를 사용하는 방식을 익혀두는 것이 좋다.

이번 문제에서 기억할 핵심은 다음과 같다.

1. 미로 탐색은 DFS 또는 BFS로 풀 수 있다.
2. 2차원 배열에서는 visited[row][col]로 방문 여부를 관리한다.
3. 상하좌우 이동은 방향 배열 dr, dc로 처리하면 깔끔하다.
4. 이동 조건은 범위, 방문 여부, 벽 여부를 확인한다.
5. 도착점을 만나면 answer = 1로 바꾸고 탐색을 종료한다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_4875 {
    static int map[][];
    static boolean visited[][];
    static int N;
    static int answer;

    static void dfs(int row, int col){
        if(answer ==1){
            return;
        }
        if(visited[row][col]){
            return;
        }

        visited[row][col] = true;

        if(map[row][col] == 3){
            answer = 1;
            return;
        }
        //상 col - 1
        if(col-1 >=0 && map[row][col-1] != 1){
            dfs(row,col-1);
        }
        //하 col + 1
        if(col+1 <=N-1 && map[row][col + 1] != 1){
            dfs(row,col+1);
        }
        //좌 row - 1
        if(row-1 >= 0 && map[row-1][col] != 1){
            dfs(row-1,col);
        }
        //우 row + 1
        if(row+1 <= N-1 && map[row+1][col] != 1){
            dfs(row+1,col);
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());
            int row =0;
            int col =0;
            map = new int[N][N];
            for(int i = 0; i < N; i++){
                String nums = br.readLine();
                for(int j = 0; j < N; j++){
                    map[i][j] = nums.charAt(j) - '0';
                    if(map[i][j] == 2){
                        row = i;
                        col = j;
                    }
                }
            }
            visited = new boolean[N][N];
            answer = 0;
            dfs(row,col);

            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
