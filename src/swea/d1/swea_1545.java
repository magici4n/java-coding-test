/*
[문제]
SWEA 1545 - 거꾸로 출력해 보아요

[분류]
구현 / 반복문

[접근]
입력받은 N부터 0까지 1씩 감소시키며 출력한다.
for문을 감소 방향으로 사용한다.

[시간복잡도]
O(N)

[핵심 포인트]
감소 반복문:
for (int i = N; i >= 0; i--)

[피드백]
마지막에 공백이 하나 붙지만 SWEA에서는 보통 허용된다.
그래도 신경쓰자.
*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1545 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = N; i>=0; i--){
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
