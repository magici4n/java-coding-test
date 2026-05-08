/*
[문제]
SWEA 5174 – subtree

[분류]
트리 / DFS / 재귀 / 서브트리 탐색

[접근]
주어진 트리에서 특정 노드 N을 루트로 하는 서브트리에 포함된 노드의 개수를 구하는 문제이다.

간선 정보는 부모-자식 관계로 주어진다.
각 부모 노드는 최대 2개의 자식을 가질 수 있으므로,
node[1][부모]에는 첫 번째 자식,
node[2][부모]에는 두 번째 자식을 저장했다.

이후 주어진 노드 N부터 DFS를 시작하여,
방문하는 노드마다 count를 1씩 증가시킨다.

현재 노드의 왼쪽 자식이 있으면 DFS로 내려가고,
오른쪽 자식이 있으면 DFS로 내려간다.

DFS가 끝났을 때 count 값이
N을 루트로 하는 서브트리의 전체 노드 개수가 된다.

[시간복잡도]
O(V)

DFS는 서브트리에 포함된 노드를 한 번씩 방문한다.
최악의 경우 전체 노드를 모두 방문할 수 있으므로 O(V)이다.

간선 수가 E일 때 트리의 노드 수는 보통 E + 1이므로,
O(E)로 봐도 된다.

[핵심 포인트]
- 부모 노드 기준으로 자식 노드를 저장한다.
- 각 노드는 최대 2개의 자식을 가지므로 node[1], node[2]를 사용했다.
- DFS를 시작하는 노드는 입력으로 주어진 N이다.
- DFS에서 현재 노드를 방문할 때 count++ 한다.
- 자식이 0이 아니라면 해당 자식으로 재귀 호출한다.
- 배열 크기는 node = new int[3][E + 2] 정도면 충분하다.
  - 첫 번째 인덱스는 1, 2만 사용
  - 두 번째 인덱스는 노드 번호를 의미

[피드백]
처음 풀이에서 DFS 로직은 정확했다.

현재 노드를 방문하면서 count를 증가시키고,
자식 노드가 존재하면 재귀적으로 내려가는 방식이므로
서브트리의 노드 개수를 세는 문제 의도와 잘 맞는다.

더 깔끔하게 하려면 전역 변수 static int N은 없애고,
main 안에서 int target으로 받아 dfs(target)을 호출하는 방식이 좋다.

현재 풀이는 DFS를 이용한 정답 가능한 풀이이고,
트리에서 특정 노드를 기준으로 하위 노드를 모두 세는 기본 구조를 잘 구현한 코드이다.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5174 {
    static int N;
    static int [][] node;
    static int count;


    static void dfs(int current) {

        count++;
        if(node[1][current] != 0) {
            dfs(node[1][current]);
        }
        if(node[2][current] != 0) {
            dfs(node[2][current]);
        }
    }

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int E = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            StringTokenizer nums = new StringTokenizer(br.readLine());

            node = new int[3][E+2];
            for(int i = 0; i < E; i++) {
                int a = Integer.parseInt(nums.nextToken());
                int b = Integer.parseInt(nums.nextToken());
                if(node[1][a] == 0) {
                    node[1][a] = b;
                }else {
                    node[2][a] = b;
                }
            }

            count = 0;
            dfs(N);
            sb.append("#").append(tc+1).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }
}
