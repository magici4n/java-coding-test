/*
[문제]
SWEA 1204 - 최빈수 구하기

[분류]
구현 / 배열 / 카운팅 / 빈도수 계산

[접근]
- 각 점수를 표현할 배열을 만들어서 그 수가 나올때마다 그 배열에 +1을 한 뒤
최종으로 그 배열값 내에서 가장 큰 값을 결과로 내었다.

[시간복잡도]
O(1)
- 각 테스트 케이스마다 점수는 항상 1000개이고, 점수 범위도 0~100으로 고정되어 있다.
- 따라서 입력 크기가 고정된 문제 기준으로는 O(1)이다.
- 일반화해서 점수 개수를 N, 점수 범위를 K라고 보면 O(N + K)이다.

[핵심 포인트]
- 점수 범위가 0~100 으로 고정되어있으니 배열 사용
- int 배열은 생성 시 자동으로 0으로 초기화되므로 따로 0을 넣어줄 필요가 없다.

[피드백]
-나쁘지 않게 잘 풀었다.
-굳이 int 배열을 0으로 초기화 안해도 된다는 것을 기억하자.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1204 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append("#").append(num).append(" ");
            int []nums = new int[101];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int k = 0; k<1000; k++){
                nums[Integer.parseInt(st.nextToken())]++;
            }
            int max = Integer.MIN_VALUE;
            int flag = 0;
            for(int q = 0; q<=100; q++){
                if (max<=nums[q]){
                    max = nums[q];
                    flag = q;
                }
            }
            sb.append(flag).append("\n");
        }
        System.out.print(sb);
    }
}
