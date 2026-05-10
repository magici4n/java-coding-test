/*
[문제]
SWEA 5176 – 이진탐색

[분류]
트리 / 완전 이진트리 / 이진탐색트리 / 중위순회

[접근]
1부터 N까지의 값을 이용해서 이진탐색트리를 만드는 문제이다.

단, 일반적인 이진탐색트리처럼 숫자를 하나씩 삽입하는 방식이 아니라,
완전 이진트리의 형태가 이미 정해져 있다고 생각해야 한다.

완전 이진트리는 배열로 표현할 수 있다.

현재 노드 index가 i라면,
왼쪽 자식은 i * 2,
오른쪽 자식은 i * 2 + 1이다.

따라서 int[] tree = new int[N + 1] 크기로 배열을 만들고,
tree[1]부터 tree[N]까지를 완전 이진트리의 노드라고 생각한다.

이진탐색트리의 중요한 특징은
중위순회하면 값이 오름차순으로 나온다는 것이다.

중위순회 순서:
왼쪽 자식 → 현재 노드 → 오른쪽 자식

따라서 완전 이진트리를 중위순회하면서
1부터 N까지의 값을 차례대로 넣으면
이진탐색트리 조건을 만족하는 트리가 완성된다.

[시간복잡도]
O(N)

중위순회를 하면서 1번부터 N번 노드까지 한 번씩 방문하므로 O(N)이다.

[핵심 포인트]
- 완전 이진트리는 배열로 표현할 수 있다.
- tree[0]은 사용하지 않고 tree[1]부터 사용한다.
- 현재 노드가 index라면:
  - 왼쪽 자식: index * 2
  - 오른쪽 자식: index * 2 + 1
- 이진탐색트리는 중위순회하면 오름차순이 된다.
- 따라서 중위순회하면서 1, 2, 3, ... 값을 차례대로 넣으면 된다.
- 일반 BST 삽입 방식으로 풀면 완전 이진트리 모양이 깨질 수 있으므로 적절하지 않다.
- 우선순위 큐 문제도 아니다.
  우선순위 큐는 힙 구조이고, 이 문제는 완전 이진트리 형태의 이진탐색트리를 만드는 문제이다.

[피드백]
이 문제는 이름에 이진탐색이 들어가 있어서
일반적인 이진탐색트리 삽입 문제처럼 보일 수 있다.

하지만 핵심은 숫자를 하나씩 BST 조건에 맞게 삽입하는 것이 아니라,
완전 이진트리의 고정된 자리에 값을 배치하는 것이다.

처음에 이진탐색트리를 직접 만들어야 하는 문제라고 생각한 것은 자연스러운 접근이다.
다만 이 문제에서는 완전 이진트리의 형태가 유지되어야 하므로,
배열을 이용해 트리의 자리를 먼저 잡고,
중위순회로 값을 넣는 방식이 정석 풀이이다.

특히 "이진탐색트리는 중위순회하면 오름차순이다"라는 성질을 이용하는 것이 핵심이다.

이 문제를 통해 완전 이진트리 배열 표현과 중위순회의 의미를 함께 익힐 수 있다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_5176 {

    static int [] tree;
    static int N;
    static int num;
    static void inorder(int index){
        if(index > N){
            return;
        }

        inorder(2 * index);
        tree[index] = num++;
        inorder(2 * index+1);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());
            tree = new int[N+1];
            num = 1;
            inorder(1);

            sb.append("#").append(tc+1).append(" ").append(tree[1]).append(" ").append(tree[N/2]).append("\n");
        }
        System.out.print(sb);
    }
}
