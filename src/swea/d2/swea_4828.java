/*
[문제]
SWEA 4828 – min max

[분류]
구현 / 배열 / 최댓값·최솟값

[접근]
N개의 숫자를 입력받으면서 최댓값과 최솟값을 동시에 갱신한다.
모든 숫자를 확인한 뒤 최댓값 - 최솟값을 출력한다.

[시간복잡도]
O(N)

각 테스트케이스마다 N개의 숫자를 한 번씩만 확인하므로 O(N)이다.
전체 테스트케이스까지 고려하면 O(T * N)이다.

[핵심 포인트]
입력받는 즉시 max, min을 갱신하면 배열에 따로 저장하지 않아도 된다.

[피드백]
어렵지 않은 문제.
다음번엔 크기비교할때 Math.max나 Math.min을 활용해보자.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4828 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                if(num>max){
                    max = num;
                }
                if(num<min){
                    min = num;
                }
            }
            sb.append("#").append(tc+1).append(" ").append(max-min).append("\n");
        }
        System.out.print(sb);
    }
}
