/*
[문제]
SWEA 1859 - 백만 장자 프로젝트

[분류]
그리디 / 배열 / 뒤에서부터 탐색

[접근]
- 뒤에서부터 보면서 현재까지의 최고가를 max에 저장한다.
- 현재 가격이 max보다 작으면, 현재 가격에 사서 max 가격에 팔 수 있으므로 차익을 sum에 더한다.
- 현재 가격이 max보다 크면, 앞으로의 기준 최고가를 현재 가격으로 갱신한다.

[시간복잡도]
O(N)
- 각 테스트 케이스마다 가격 배열을 한 번 입력받고, 뒤에서 한 번 탐색한다.
- 따라서 한 테스트 케이스 기준 시간복잡도는 O(N)이다.

[핵심 포인트]
- 미래의 최고 판매가를 알아야 하므로 앞에서부터가 아니라 뒤에서부터 탐색한다.
- 누적 이익은 int 범위를 초과할 수 있으므로 long을 사용해야 한다.

[피드백]
어려워서 댓글을 보고 힌트를 얻어 푼 문제이다.
로직을 만드는게 생각보다 어려운 것 같다,,
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1859 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i++){
            sb.append("#").append(i+1).append(" ");
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nums = new int[N];
            long sum = 0;
            for(int j = 0; j < N; j++){
                nums[j] = Integer.parseInt(st.nextToken());
            }
            int max = Integer.MIN_VALUE;
            for(int k = N-1; k>=0; k--){
                if(max < nums[k]){
                    max = nums[k];
                }else{
                    sum += (max - nums[k]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
