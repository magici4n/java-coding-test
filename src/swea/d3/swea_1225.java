/*
[문제]
SWEA 1225 - 암호생성기

[분류]
큐 / 시뮬레이션 / 구현

[접근]
8개의 숫자를 큐에 저장한 뒤, 앞에서 하나씩 꺼내 1, 2, 3, 4, 5를 순서대로 뺀다.
뺀 결과가 0보다 크면 다시 큐의 뒤에 넣고,
0 이하가 되면 0으로 바꿔 큐 뒤에 넣은 뒤 반복을 종료한다.
이때 감소값은 1~5가 반복되도록 관리한다.

[시간복잡도]
O(K)

K는 암호 생성이 종료될 때까지 반복되는 횟수이다.
한 번 반복할 때마다 poll, add 연산만 수행하므로 각 연산은 O(1)이다.
입력 숫자는 항상 8개로 고정되어 있어 실질적으로는 매우 작다.

[핵심 포인트]
1. 앞에서 꺼내고 뒤에 넣는 구조이므로 Queue 또는 Deque를 사용한다.
2. 감소값 count는 1, 2, 3, 4, 5 순서로 반복되어야 한다.
3. 계산 결과가 0 이하가 되면 반드시 0으로 바꿔 큐 뒤에 넣고 종료한다.
4. SWEA 1225는 테스트케이스 번호가 입력으로 주어지므로 출력할 때 tc + 1이 아니라 입력받은 번호를 사용한다.

[피드백]
Deque<Integer>를 사용해서 큐 시뮬레이션을 구현한 점은 적절하다.
pollFirst()로 앞에서 꺼내고 add()로 뒤에 넣는 흐름도 문제 조건과 잘 맞는다.

d3 치고 쉬운 문제.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class swea_1225 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc<10; tc++) {
            int T = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i< 8; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            int count = 1;
            while(true) {
                int num = deque.pollFirst() - count;

                if(num <= 0) {
                    deque.add(0);
                    break;
                }
                deque.addLast(num);

                count++;
                if(count == 6) {
                    count = 1;
                }
            }
            sb.append("#").append(T).append(" ");
            while(!deque.isEmpty()) {
                sb.append(deque.pollFirst()).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
