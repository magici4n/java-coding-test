/*
[문제]
SWEA 1285 - 아름이의 돌 던지기

[분류]
구현 / 배열 / 절댓값 / 최솟값 갱신

[접근]
거리를 Math.abs()를 통해서 절댓값 처리.
- 더 작은 거리를 발견하면 min을 갱신하고 count를 1로 초기화
- 현재 최소 거리와 같은 거리를 발견하면 count 증가

[시간복잡도]
O(N)

각 테스트케이스마다 참가자 N명을 한 번씩만 확인하므로 O(N)이다.

[핵심 포인트]
1. 음수 위치도 0과의 거리는 양수이므로 Math.abs()를 사용한다.
2. 최소값이 갱신되면 count를 1로 다시 초기화해야 한다.
3. 최소값과 같은 값이 나오면 count를 증가시킨다.
4. 배열에 저장하지 않고 입력받으면서 바로 처리할 수 있다.

[피드백]
Math.abs() 기억하기 - 절댓값 처리
불필요한 배열 생성하지 말기
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1285 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int min = Integer.MAX_VALUE;
            int count = 0;
            for(int i = 0; i< N; i++){
                int num = Integer.parseInt(st.nextToken());
                num = Math.abs(num);

                if(num < min){
                    count = 1;
                    min = num;
                }else if(num == min){
                    count++;
                }
            }
            sb.append("#").append(tc+1).append(" ").append(min).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }
}
