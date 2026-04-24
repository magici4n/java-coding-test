/*
[문제]
SWEA 1970 - 쉬운 거스름돈

[분류]
구현 / 그리디 / 배열

[접근]
큰 화폐 단위부터 차례대로 가능한 만큼 사용했다.
각 화폐마다 현재 금액에서 몇 장이 필요한지 나누기로 구하고,
남은 금액은 나머지 연산으로 갱신하는 방식으로 풀이했다.

[시간복잡도]
O(1)
- 화폐 단위 개수가 8개로 고정되어 있어서 사실상 상수 시간

[핵심 포인트]
- count = N / money[i]
- N = N % money[i]
- 화폐 단위를 배열에 저장해 반복문으로 처리 가능


[피드백]
쉬운 문제라 따로 또 볼 내용은 없던 것 같다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1970 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int []money = {50000,10000,5000,1000,500,100,50,10};

        int T = Integer.parseInt(br.readLine());


        for(int tc= 0; tc<T; tc++){
            sb.append("#").append(tc+1).append("\n");
            int N = Integer.parseInt(br.readLine());

            for(int i =0; i< money.length;i++ ){
                int count = N/money[i];
                N = N%money[i];

                sb.append(count).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
