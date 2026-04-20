/*
[문제]
SWEA 1926 - 간단한 369게임

[분류]
구현 / 문자열(자릿수 처리)

[접근]
1부터 N까지 숫자를 하나씩 확인했다.
각 숫자에 대해 일의 자리부터 꺼내면서 3, 6, 9가 몇 번 나오는지 count.

[시간복잡도]
O(N log N)
바깥 반복문: N번
안쪽 while문: 각 숫자의 자릿수만큼, 즉 O(log N)
전체: O(N log N)

[핵심 포인트]
- num % 10으로 마지막 자리 확인
- num /= 10으로 다음 자리로 이동
- 3, 6, 9가 나온 개수만큼 "-" 출력
- StringBuilder로 출력 문자열을 한 번에 관리

[피드백]
낫벧

*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1926 {
    public static void main(String []args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());


        for(int i = 1; i<= N; i++){
            int num = i;
            int count = 0;

            while(num>0) {
                int rest = num % 10;
                num = num / 10;
                if (rest == 3 || rest == 6 || rest == 9) {
                    count++;
                }
            }

            if(count>0){
                for(int j = 0; j<count; j++){
                    sb.append("-");
                }
            }else{
                sb.append(i);
            }
            sb.append(" ");
        }
        System.out.print(sb);
    }
}