/*
[문제]
SWEA 2070 - 큰 놈, 작은 놈, 같은 놈

[분류]
구현 / 조건문

[접근]
StringTokenizer로 a,b를 받아서 조건문

[시간복잡도]
O(N)

[핵심 포인트]
두 수 비교는 if - else if - else 구조로 처리한다.

[피드백]
쉬운 문제. 다시 안 봐도 될 것 같다.
*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2070 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<T; i++){
            sb.append("#").append(i+1).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>b){
                sb.append(">").append("\n");
            }else if(a<b){
                sb.append("<").append("\n");
            }else{
                sb.append("=").append("\n");
            }
        }
        System.out.print(sb);

    }
}
