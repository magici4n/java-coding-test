/*
[문제]
BOJ 2606 - 바이러스

[분류]
그래프 / DFS

[접근]
인접 리스트로 그래프를 만든 뒤
1번 컴퓨터부터 DFS를 시작해서 연결된 컴퓨터들을 모두 방문 처리.
방문이 끝난 뒤 visited 배열을 확인하여 1번을 제외한 감염된 컴퓨터 수 출력

[시간복잡도]
O(V + E)
- 정점 수: V, 간선 수: E
- DFS는 각 정점과 간선을 한 번씩 확인

[핵심 포인트]
- 인접 리스트는 graph[i]를 각각 new ArrayList<>()로 초기화해야 함
- 이 문제의 연결 정보는 양방향이므로 graph[a].add(b), graph[b].add(a) 둘 다 필요
- DFS 함수 기본 구조는 방문 처리 후 인접 노드 재귀 호출


[피드백]
처음으로 DFS문제를 풀어보느라 여러 문제가 있었다.
인접 리스트 배열만 만들고 각 칸의 ArrayList를 초기화하지 않아서 add 시점에 문제가 생겼었다.
또한 이 문제는 양방향 그래프인데 한 방향만 저장해서 연결 관계가 완전하게 표현되지 않았다.
마지막으로 감염 수를 셀 때 0번 인덱스를 보거나 마지막 컴퓨터를 놓치는 범위 실수가 있었다.
즉, DFS의 인접 리스트 그래프 초기화와 양방향 처리 부분을 더 확실히 익혀야 한다.
*/

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2606 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int now){
        visited[now] = true;

        for(int next : graph[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[computer+1];
        visited = new boolean[computer+1];

        for (int i = 1; i <= computer; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);

        int count = 0;
        for (int i = 2; i <= computer; i++){
            if(visited[i]){
                count++;
            }
        }
        System.out.print(count);
    }
}
