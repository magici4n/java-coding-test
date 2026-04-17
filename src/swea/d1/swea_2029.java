/*
[문제]
SWEA 2029 - 몫과 나머지 출력하기

[분류]
수학 / 사칙연산 / 구현

[접근]
생략

[시간복잡도]
O(N)
- 테스트 케이스 N개를 한 번씩 처리하므로 O(N)이다.

[핵심 포인트]
생략

[피드백]
- (int)(A / B)는 불필요한 형변환이다. A와 B가 int이면 A / B 자체가 이미 int 결과를 반환한다.
소수점 결과가 필요한 문제에서는 계산 전에 (double) A / B처럼 피연산자 중 하나를 실수형으로 바꿔야 한다.
*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2029 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i<=T; i++){
            sb.append("#").append(i).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append((int)(A/B)).append(" ").append(A%B).append("\n");
        }
        System.out.print(sb);
    }
}
