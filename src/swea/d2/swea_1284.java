/*
[문제]
SWEA 1284 - 수도 요금 경쟁

[분류]
구현 / 조건문 / 수학

[접근]
A사는 1리터당 P원의 요금을 내므로 P * W로 계산.
B사는 사용량 W가 R 이하이면 기본요금 Q만 내고,
R을 초과하면 초과량 (W - R)에 대해 리터당 S원을 추가로 낸다.
두 회사의 요금을 각각 계산한 뒤 Math.min()으로 더 저렴한 요금을 출력.

[시간복잡도]
O(T)
각 테스트케이스마다 단순 계산만 수행한다.

[핵심 포인트]
- A사 요금: P * W
- B사 요금:
  - W <= R : Q
  - W > R : Q + (W - R) * S
- 두 값 중 최소값은 Math.min()으로 구한다.

[피드백]
쉬운 문제. 안 봐도 될듯.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1284 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int P_value = P*W;
            int Q_value = 0;

            if(W>R){
                Q_value = Q + (W-R)*S;
            }else{
                Q_value = Q;
            }
            int result = Math.min(P_value, Q_value);
            sb.append("#").append(tc+1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
