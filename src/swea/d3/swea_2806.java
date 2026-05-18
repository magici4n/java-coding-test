/*
[문제]
SWEA 2806 - N-Queen

[분류]
DFS / 백트래킹 / 완전탐색

[접근]
퀸을 한 행에 하나씩 놓는 방식으로 DFS를 진행한다.
현재 row에서 가능한 col을 하나씩 확인하고,
같은 열과 양쪽 위 대각선에 이미 퀸이 있는지 검사한다.
놓을 수 있다면 퀸을 놓고 다음 행으로 이동한다.
N개의 행에 모두 퀸을 놓으면 가능한 경우의 수를 1 증가시킨다.

[시간복잡도]
백트래킹 탐색이므로 정확히 단순한 다항 시간은 아니다.
각 행마다 가능한 열을 선택하며 탐색하고,
불가능한 경우는 가지치기한다.

[핵심 포인트]
한 행에 하나씩만 퀸을 놓으면 같은 행 검사는 필요 없다.
위에서 아래로 퀸을 놓기 때문에 현재 위치에서는 위쪽만 검사하면 된다.

검사해야 하는 방향:
1. 같은 열
2. 좌측 위 대각선
3. 우측 위 대각선

백트래킹 기본 구조:
놓기
재귀 호출
원상복구

[피드백]
풀이 방향은 정석적이고 코드도 잘 작성했다.
flag를 이용해 불가능한 경우 continue로 넘기는 방식도 문제 없다.
다만 검사 코드가 dfs 내부에 길게 들어가 있으므로,
나중에는 check(row, col) 함수로 분리하면 코드 가독성이 더 좋아진다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2806 {

    static int N;
    static int [][]map;
    static int answer;
    static void dfs(int row){
        if(row == N){
            answer++;
            return;
        }

        for(int col = 0; col < N; col++){
            boolean flag = true;
            //같은 열 검사
            for(int i = row-1; i >=0; i--){
                if(map[i][col] == 1){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                continue;
            }
            // 좌측 위 대각선 검사 row-- col--
            int r = row-1;
            int c = col-1;
            while(r >= 0 && c >=0){
                if(map[r][c] == 1){
                    flag = false;
                    break;
                }
                r--;
                c--;
            }
            if(!flag){
                continue;
            }
            // 우측 위 대각선 검사
            r = row-1;
            c = col+1;
            while(r >=0 && c <N){
                if(map[r][c]==1){
                    flag = false;
                    break;
                }
                r--;
                c++;
            }
            if(!flag){
                continue;
            }

            map[row][col] =1;
            dfs(row+1);
            map[row][col] =0;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            answer = 0;
            dfs(0);


            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
