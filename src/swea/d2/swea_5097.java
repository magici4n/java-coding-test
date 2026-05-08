/*
[문제]
SWEA 5097 – 회전

[분류]
큐 / 구현 / 나머지 연산 / 시뮬레이션 최적화

[접근]
길이가 N인 수열에서 맨 앞의 원소를 맨 뒤로 보내는 작업을 M번 반복한 뒤,
맨 앞에 오는 원소를 구하는 문제이다.

큐를 직접 사용해서 M번 회전시킬 수도 있지만,
회전은 N번마다 원래 위치로 돌아오기 때문에
실제로 필요한 위치는 M % N 번째 인덱스이다.

예를 들어 N = 5, M = 2이고 수열이 1 2 3 4 5라면,

초기 상태: 1 2 3 4 5
1회전: 2 3 4 5 1
2회전: 3 4 5 1 2

결과는 원래 수열의 index 2 위치인 3이다.

따라서 targetIndex = M % N을 구한 뒤,
입력받은 숫자 중 targetIndex 번째 값을 result로 저장하면 된다.

[시간복잡도]
O(N)

현재 풀이에서는 targetIndex 번째 값까지만 읽으므로
정확히는 O(M % N + 1)이다.

하지만 입력 수열의 길이를 기준으로 보면 최악의 경우 O(N)이다.

큐를 직접 M번 회전하면 O(M)이 걸릴 수 있는데,
나머지 연산을 이용하면 더 효율적으로 풀 수 있다.

[핵심 포인트]
- 큐를 M번 직접 회전하지 않아도 된다.
- N번 회전하면 원래 상태로 돌아온다.
- 따라서 회전 후 맨 앞 원소의 위치는 M % N이다.
- index는 0부터 시작하므로 M % N 값을 그대로 사용할 수 있다.
- StringTokenizer로 입력 한 줄을 이미 읽었기 때문에,
  targetIndex 번째 값까지만 꺼내도 입력 처리에는 문제가 없다.

[피드백]
이번 풀이는 문제의 본질을 잘 파악한 풀이이다.

문제는 큐 회전처럼 보이지만,
최종적으로 필요한 것은 회전 후 맨 앞 원소 하나뿐이다.
따라서 실제 큐를 만들어 poll/add를 반복하지 않고,
M % N으로 정답 위치를 바로 계산한 점이 좋다.

다만 변수명을 조금 더 명확하게 하려면
index보다는 targetIndex 또는 frontIndex 같은 이름을 사용할 수 있다.

현재 풀이는 정답 가능한 풀이이며,
큐 시뮬레이션보다 더 효율적인 최적화 풀이이다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5097 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int index = M%N;

            int result = 0;

            StringTokenizer num = new StringTokenizer(br.readLine());
            for(int i = 0; i <= index; i++) {
                result = Integer.parseInt(num.nextToken());
            }
            sb.append("#").append(tc+1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}