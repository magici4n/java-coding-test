/*
[문제]
SWEA 5177 - 이진 최소 힙

[분류]
트리 / 힙 / 구현

[접근]
입력받은 숫자들을 순서대로 최소 힙에 삽입한다.

최소 힙은 부모 노드의 값이 자식 노드의 값보다 작거나 같아야 한다.
따라서 새 값을 배열의 마지막 위치에 넣은 뒤,
부모 노드와 비교하면서 새 값이 더 작으면 부모와 자리를 바꾼다.

이 과정을 루트에 도달하거나,
부모 노드가 현재 노드보다 작거나 같을 때까지 반복한다.

모든 값을 삽입한 뒤에는 마지막 노드 N의 조상 노드 값을 더한다.
마지막 노드의 부모는 N / 2이고,
그 부모의 부모는 다시 parent / 2로 구할 수 있다.

[시간복잡도]
O(N log N)

숫자 N개를 하나씩 힙에 삽입한다.
각 삽입 과정에서 최악의 경우 루트까지 올라갈 수 있으므로 O(log N)이 걸린다.
따라서 전체 시간복잡도는 O(N log N)이다.

마지막 노드의 조상 합을 구하는 과정은 트리의 높이만큼 이동하므로 O(log N)이다.
전체적으로는 O(N log N)이다.

[핵심 포인트]
- 최소 힙은 부모 값 <= 자식 값 조건을 만족해야 한다.
- 힙을 배열로 표현할 때 1번 인덱스부터 사용하면 편하다.
- 현재 노드 idx의 부모 노드는 idx / 2이다.
- 새 값을 삽입한 뒤 부모보다 작으면 서로 교환하면서 위로 올린다.
- heapify(idx)는 idx 위치에 들어간 값을 올바른 위치까지 올리는 함수이다.
- 마지막 노드의 조상 합은 parent = N / 2부터 시작해서 parent /= 2 하며 구한다.
- heap[0]은 사용하지 않는 칸이므로 비교하거나 합산하지 않는 것이 좋다.

[피드백]
처음 작성한 코드도 최소 힙을 만드는 핵심 로직은 맞았다.
부모와 자식을 비교하고, 자식이 더 작으면 교환하는 방식은 올바른 접근이었다.

다만 전역 변수 index가 여러 역할을 동시에 맡고 있었다.
index가 새 값을 삽입할 위치로도 쓰이고,
heapify 과정에서 부모로 올라가는 현재 위치로도 쓰이고,
마지막 조상 합을 구할 때도 사용되었다.

따라서 원래 내가 짠 코드는 index변수로 인해서 너무 더러워져서
gpt가 리팩토링한 코드를 이해한뒤 첨부하였다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5177 {

    static int[] heap;

    static void heapify(int idx) {
        while (idx > 1) {
            int parent = idx / 2;

            if (heap[parent] > heap[idx]) {
                int temp = heap[parent];
                heap[parent] = heap[idx];
                heap[idx] = temp;

                idx = parent;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            heap = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                heap[i] = Integer.parseInt(st.nextToken());
                heapify(i);
            }

            int sum = 0;
            int parent = N / 2;

            while (parent > 0) {
                sum += heap[parent];
                parent /= 2;
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }
}