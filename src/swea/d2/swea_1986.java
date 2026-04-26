/*
[문제]
SWEA 1986 - 지그재그 숫자

[분류]
구현 / 수학

[접근]
1부터 N까지 반복하면서 홀수면 더하고 짝수면 빼는 방식

[시간복잡도]
O(N)

[핵심 포인트]
- 홀수는 더하고 짝수는 뺌
- i % 2 == 0 이면 짝수
- 1부터 N까지 반복하며 누적합 계산
- 출력 형식은 #테스트케이스번호 결과

[피드백]
너무 쉬워서 패스
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1986 {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T= Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            sb.append("#").append(tc+1).append(" ");
            int sum = 0;

            int N = Integer.parseInt(br.readLine());

            for(int i = 1; i<=N; i++){
                if(i % 2 == 0){
                    sum -= i;
                }else{
                    sum += i;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
