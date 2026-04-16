/*
[문제]
SWEA 2046 - 스탬프 찍기

[분류]
구현 / 반복문

[접근]
입력받은 N만큼 반복문을 돌면서 # 문자를 출력한다.

[시간복잡도]
O(N)

[핵심 포인트]
for문 사용

[피드백]
쉬운문제라서 큰 피드백은 없고 StringBuilder를 사용하자.
*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2046{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
            System.out.print("#");
        }
    }
}
