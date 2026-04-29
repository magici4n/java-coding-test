/*
[문제]
SWEA 1940 - 가랏! RC카!

[분류]
구현 / 시뮬레이션

[접근]
각 명령마다 현재 속도 v를 갱신하고, 갱신된 속도만큼 이동 거리에 더한다.

- command == 0 : 현재 속도 유지
- command == 1 : 가속도만큼 속도 증가
- command == 2 : 가속도만큼 속도 감소
  - 단, 속도는 음수가 될 수 없으므로 최소 0으로 처리

매 초마다 명령 처리 후 distance += v 를 수행한다.

[시간복잡도]
O(N)

테스트케이스마다 N개의 명령을 한 번씩만 확인하므로 O(N)이다.

[핵심 포인트]
1. 현재 속도를 계속 저장하는 변수 v가 필요하다.
2. 명령 처리 후 이동 거리를 더해야 한다.
3. 감속할 때 속도가 음수가 되지 않게 해야 한다.

[피드백]
코드를 적으면서 조금 깔끔한 코드는 아니라고는 생각이 들긴했다.
수정할 부분이 있다면 굳이 else문을 안적어도 됐다.
그리고 감속 부분은
Math.max(0, v - a)를 사용하면 더 간결하게 표현할 수 있었다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1940 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());

            int distance = 0;
            int v = 0;
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());

                if(command == 1){
                    v += Integer.parseInt(st.nextToken());
                }else if (command == 2){
                    int a = Integer.parseInt(st.nextToken());
                    if(v > a){
                        v -= a;
                    }else{
                        v = 0;
                    }
                }else{
                    ;
                }
                distance += v;
            }
            sb.append("#").append(tc+1).append(" ").append(distance).append("\n");
        }
        System.out.print(sb);
    }
}
