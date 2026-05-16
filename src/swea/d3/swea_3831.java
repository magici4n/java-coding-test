/*
[문제]
SWEA 4831 - 전기버스

[분류]
그리디 / 배열 / 구현

[접근]
현재 위치(pos)에서 한 번 충전으로 갈 수 있는 최대 위치는 pos + K이다.
그 범위 안에 있는 충전소 중 가장 멀리 있는 충전소를 선택해서 이동한다.

갈 수 있는 충전소가 하나도 없으면 더 이상 진행할 수 없으므로 0을 출력한다.
종점 N까지 한 번에 갈 수 있는 위치에 도달하면 반복을 종료한다.

[시간복잡도]
O(M)

충전소 배열을 idx로 한 번만 순회하기 때문에 전체 시간복잡도는 O(M)이다.

[핵심 포인트]
1. 현재 위치에서 갈 수 있는 충전소 중 가장 먼 곳을 고르는 그리디 문제이다.
2. 가까운 충전소에서 충전할 필요가 없고, 최대한 멀리 가는 선택이 항상 유리하다.
3. idx는 이미 확인한 충전소를 다시 볼 필요가 없으므로 계속 앞으로만 이동한다.
4. next를 현재 위치(pos)로 초기화해두면, 이동 가능한 충전소가 없는 경우를 쉽게 판별할 수 있다.

예:
int next = pos;

while (idx < M && station[idx] <= pos + K) {
    next = station[idx];
    idx++;
}

if (next == pos) {
    possible = false;
    break;
}

[피드백]
처음 풀이에서는 gas를 '갈 수 있는 최대 위치'처럼 사용했고, cur 인덱스를 조정하면서 station[cur - 1]에 접근했다.
이 방식도 방향은 맞았지만, cur이 0일 때 station[-1]에 접근할 수 있고,
마지막 충전소가 현재 갈 수 있는 범위 안에 있어도 제대로 선택하지 못하는 문제가 있었다.

이번 정석 풀이처럼 현재 위치(pos), 다음 충전 위치(next), 충전소 인덱스(idx)를 분리하면
인덱스 예외도 줄어들고 로직이 훨씬 명확해진다.

이 문제는 다음처럼 기억하면 된다.

"현재 위치에서 갈 수 있는 충전소 중 가장 먼 곳에서 충전한다.
갈 수 있는 충전소가 없으면 실패한다."
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3831 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] station = new int[M];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                station[i] = Integer.parseInt(st1.nextToken());
            }

            int pos = 0;
            int idx = 0;  //정류장 배열 인덱스
            int count = 0;
            boolean possible = true;

            while(pos + K < N){
                int next = pos;

                while(idx < M && station[idx] <= pos+K){
                    next = station[idx];
                    idx++;
                }
                if(next == pos){
                    possible = false;
                    break;
                }
                count++;
                pos = next;
            }
            sb.append("#").append(tc+1).append(" ");

            if(possible){
                sb.append(count).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
    }
}
