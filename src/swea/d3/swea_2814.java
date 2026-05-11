/*
[문제]
SWEA 2814 - 최장 경로

[분류]
DFS / 백트래킹 / 그래프 탐색

[접근]
- 주어진 그래프에서 가장 긴 경로의 길이를 구하는 문제이다.
- 한 번 방문한 정점은 같은 경로 안에서 다시 방문할 수 없다.
- 어느 정점에서 시작해야 최장 경로가 나올지 모르기 때문에,
  모든 정점을 시작점으로 DFS를 수행한다.
- DFS를 진행하면서 현재까지 방문한 정점 수를 count로 관리한다.
- 매번 count와 result를 비교하여 최댓값을 갱신한다.
- DFS가 끝나면 방문 처리를 해제하며 다른 경로도 탐색할 수 있도록 한다.

[시간복잡도]
- 모든 정점에서 DFS를 시작한다.
- 각 DFS에서 가능한 경로를 탐색하므로 최악의 경우 경우의 수가 많아질 수 있다.
- SWEA 2814는 N의 크기가 작기 때문에 DFS + 백트래킹으로 풀이 가능하다.
- 대략적인 시간복잡도: O(N!)

[핵심 포인트]
- 최장 경로 문제이므로 BFS가 아니라 DFS로 모든 가능한 경로를 탐색한다.
- 시작 정점이 정해져 있지 않으므로 1번부터 N번까지 모두 시작점으로 삼아야 한다.
- visited 배열은 한 경로 안에서 중복 방문을 막기 위한 용도이다.
- DFS 후에는 visited를 다시 false로 바꿔야 다른 경로에서 해당 정점을 사용할 수 있다.
- result는 테스트케이스마다 0으로 초기화해야 한다.
- static 변수는 처음에는 자동으로 0이 되지만, 테스트케이스마다 자동 초기화되지는 않는다.

[피드백]
- 모든 정점에서 DFS를 시작한 점이 좋다.
- 현재 코드는 자식 노드 탐색 후 부모 쪽에서 visited[next] = false, count--를 처리하고 있다.
- 이 방식도 동작은 가능하지만, 보통은 dfs 함수 마지막에서 자기 자신의 방문을 해제하는 방식이 더 깔끔하다.
- 다음부터는 백트래킹 구조를 다음 흐름으로 익히면 좋다.

  방문 처리
  → count 증가
  → 다음 노드 탐색
  → 방문 해제
  → count 감소
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_2814 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count;
    static int result;
    static void dfs(int index) {
        if(visited[index]) {
            return;
        }
        visited[index] = true;
        count++;
        result = Math.max(count, result);
        for(int next: graph[index]) {
            if(!visited[next]) {
                dfs(next);
                visited[next]= false;
                count--;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            for(int i = 0; i< N+1; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++) {
                StringTokenizer st1 =new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st1.nextToken());
                int b = Integer.parseInt(st1.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            result = 0;
            for(int i = 1 ; i <N+1; i++) {
                count = 0;
                visited = new boolean[N+1];
                dfs(i);
            }
            sb.append("#").append(tc+1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
