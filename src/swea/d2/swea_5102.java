/*
[문제]
SWEA 5102 - 노드의 거리

[분류]
그래프 / BFS / 최단 거리 / 인접 리스트

[접근]
정점과 간선 정보를 인접 리스트로 저장한다.
출발 노드에서 BFS를 수행하면서 각 노드까지의 거리를 distance 배열에 저장한다.
BFS는 가까운 노드부터 탐색하므로 도착 노드를 처음 만나는 순간의 거리가 최단 거리이다.
도착하지 못하면 0을 반환한다.

[시간복잡도]
O(V + E)

각 정점은 최대 한 번 방문하고,
각 간선도 인접 리스트를 통해 확인하므로 전체 시간복잡도는 O(V + E)이다.

[핵심 포인트]
1. 간선의 가중치가 없는 그래프에서 최단 거리는 BFS를 사용한다.
2. BFS는 Queue를 사용한다.
3. 방문 처리는 Queue에 넣는 순간 한다.
4. 거리 계산은 distance[next] = distance[current] + 1 로 한다.
5. 무방향 그래프이므로 graph[a].add(b), graph[b].add(a)를 모두 해준다.
6. 도착할 수 없는 경우 0을 출력한다.

[피드백]
이번 풀이는 BFS 구조를 잘 잡았다.
visited 배열, distance 배열, Queue 사용 모두 적절하다.
앞으로 '최단 거리', '최소 이동 횟수', '몇 단계 만에 도착하는가'라는 표현이 나오고
간선 가중치가 없다면 BFS를 먼저 떠올리면 된다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5102 {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int[] distance;

    static int bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        distance[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return distance[current];
            }

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
        public static void main(String[] args)throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());

            for (int tc = 0; tc < T; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());

                graph = new ArrayList[V + 1];

                for (int i = 0; i < V + 1; i++) {
                    graph[i] = new ArrayList<>();
                }

                for (int i = 0; i < E; i++) {
                    StringTokenizer st1 = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st1.nextToken());
                    int b = Integer.parseInt(st1.nextToken());

                    graph[a].add(b);
                    graph[b].add(a);
                }
                visited = new boolean[V + 1];
                distance = new int[V + 1];
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st2.nextToken());
                int end = Integer.parseInt(st2.nextToken());

                int result = bfs(start, end);
                sb.append("#").append(tc + 1).append(" ").append(result).append("\n");
            }
            System.out.print(sb);
    }
}
