/*
[문제]
SWEA 1860 - 진기의 최고급 붕어빵

[분류]
정렬 / 구현 / 시뮬레이션

[접근]
손님들이 도착하는 시간을 배열에 저장한 뒤 오름차순으로 정렬한다.
먼저 도착하는 손님부터 확인하면서, 해당 시간까지 만들어진 붕어빵 개수를 계산한다.

M초마다 K개의 붕어빵을 만들 수 있으므로,
sec초까지 만들어진 붕어빵 개수는 (sec / M) * K개이다.

i번째 손님을 확인할 때, 현재까지 도착한 손님 수는 i + 1명이다.
따라서 해당 시간까지 만들어진 붕어빵 개수가 i + 1보다 작으면
현재 손님에게 줄 붕어빵이 부족하므로 Impossible이다.

모든 손님을 처리할 수 있으면 Possible을 출력한다.

[시간복잡도]
O(N log N)

손님 도착 시간을 정렬하는 데 O(N log N)이 걸린다.
정렬 이후 각 손님을 한 번씩 확인하므로 O(N)이 걸린다.
따라서 전체 시간복잡도는 O(N log N)이다.

[핵심 포인트]
1. 손님 도착 시간을 오름차순으로 정렬해야 한다.
2. sec초까지 만들어진 붕어빵 개수는 (sec / M) * K개이다.
3. i번째 손님까지 처리하려면 최소 i + 1개의 붕어빵이 필요하다.
4. 0초에 도착한 손님은 붕어빵이 아직 없으므로 바로 Impossible이 될 수 있다.
5. 현재까지 만들어진 붕어빵 수가 현재까지 온 손님 수보다 적으면 Impossible이다.

[피드백]
또한 client 배열은 실제 손님 자체보다는 손님의 도착 시간을 저장하므로,
arrival 같은 이름을 사용하면 의미가 더 명확해질 수 있다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1860 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int [] client = new int[N];

            StringTokenizer nums = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                client[i] = Integer.parseInt(nums.nextToken());
            }
            Arrays.sort(client);

            boolean mission = true;

            for(int i = 0; i< N; i++) {
                int amount = (client[i] / M) * K;

                if(amount - i <= 0) {
                    mission = false;
                    break;
                }
            }

            sb.append("#").append(tc+1).append(" ");

            if(mission) {
                sb.append("Possible");
            }else {
                sb.append("Impossible");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
