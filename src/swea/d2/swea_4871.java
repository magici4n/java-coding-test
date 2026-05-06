/*
[문제]
SWEA 4871 - 그래프 경로

[분류]
그래프 / 방향 그래프 / DFS / 도달 가능 여부

[접근]
정점과 간선 정보를 인접 리스트로 저장한다.
이 문제는 방향 그래프이므로 입력으로 a b가 주어지면 a에서 b로 가는 간선만 저장한다.
출발 노드에서 DFS를 수행하면서 도착 노드에 도달할 수 있는지 확인한다.
탐색 중 도착 노드를 만나면 answer를 1로 바꾸고 종료한다.
끝까지 도착 노드를 만나지 못하면 answer는 0으로 유지된다.

[시간복잡도]
O(V + E)

각 정점은 최대 한 번 방문하고,
각 간선도 인접 리스트를 통해 최대 한 번씩 확인하므로 O(V + E)이다.

[핵심 포인트]
1. 방향 그래프는 graph[a].add(b)만 한다.
2. 도달 가능 여부 문제는 DFS와 BFS 둘 다 가능하다.
3. DFS에서는 visited 배열로 이미 방문한 노드를 다시 방문하지 않게 해야 한다.
4. 사이클이 있는 그래프에서 visited 체크가 없으면 무한 재귀가 발생할 수 있다.
5. 최단 거리를 구하는 문제가 아니므로 distance 배열은 필요 없다.
6. answer == 1이면 이미 도착 가능함을 확인한 것이므로 추가 탐색을 줄일 수 있다.

[피드백]
DFS 풀이 방향이 적절하다.
이전 코드에서 부족했던 visited[next] 체크를 추가해서 사이클이 있는 그래프에서도 안정적으로 동작한다.
방향 그래프라는 문제 조건을 잘 반영해서 graph[a].add(b)만 사용한 점도 좋다.

다만 Java 스타일상 static ArrayList<Integer> graph[] 보다는
static ArrayList<Integer>[] graph 형태가 더 일반적이다.
*/


package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_4871 {
    static ArrayList<Integer> graph[];
    static boolean visited[];
    static int answer;
    static void dfs(int start, int goal) {
        if (answer == 1) {
            return;
        }
        visited[start] = true;

        if(start == goal) {
            answer = 1;
            return;
        }

        for(int next : graph[start]) {
            if(!visited[next]) {
                dfs(next,goal);
            }
        }
    }
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for(int i = 0; i< V+1; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i <E; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st1.nextToken());
                int b = Integer.parseInt(st1.nextToken());
                graph[a].add(b);
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int goal = Integer.parseInt(st2.nextToken());

            answer = 0;
            visited = new boolean[V+1];
            dfs(start,goal);

            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
/*
bfs로 구현
	static ArrayList<Integer> graph[];
	static boolean visited[];
	static int answer;

	static void bfs(int start, int goal) {
		Queue<Integer> queue = new ArrayDeque<>();

		queue.add(start);

		visited[start] = true;

		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current == goal) {
				answer = 1;
				return;
			}
			for(int next: graph[current]) {
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}
[문제]
SWEA 4871 - 그래프 경로

[분류]
그래프 / 방향 그래프 / DFS / BFS / 도달 가능 여부

[접근]
정점과 간선 정보를 인접 리스트로 저장한다.
이 문제는 방향 그래프이므로 a에서 b로 가는 간선만 graph[a].add(b)로 저장한다.
출발 노드에서 BFS를 수행하면서 연결된 노드를 탐색한다.
탐색 중 도착 노드를 만나면 answer를 1로 바꾸고 종료한다.
끝까지 도착 노드를 만나지 못하면 answer는 0으로 유지된다.

[시간복잡도]
O(V + E)

각 정점은 최대 한 번 방문하고,
각 간선도 인접 리스트를 통해 확인하므로 O(V + E)이다.

[핵심 포인트]
1. 방향 그래프는 graph[a].add(b)만 한다.
2. 무방향 그래프처럼 graph[b].add(a)를 추가하면 안 된다.
3. BFS는 Queue를 사용한다.
4. BFS에서는 큐에 넣는 순간 visited[next] = true 처리한다.
5. 최단 거리가 아니라 도달 가능 여부만 확인하므로 distance 배열은 필요 없다.
6. current == goal이 되는 순간 answer = 1로 바꾸고 return 한다.

[피드백]
BFS 구조를 잘 잡았다.
이전 코드에서 빠졌던 visited[next] = true 처리를 큐에 넣기 전에 추가해서 안정적인 BFS가 되었다.
SWEA 4871은 최단 거리 문제가 아니라 도달 가능 여부 문제이므로 DFS와 BFS 모두 가능하다.
이번 풀이는 BFS로 도달 여부를 확인하는 정석적인 풀이로 볼 수 있다.
*/
