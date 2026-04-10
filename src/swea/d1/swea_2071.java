/*
[문제]
swea 2071 - 평균값 구하기

[분류]
구현 / 수학 / 반복문

[접근]
각 테스트케이스마다 10개의 수를 입력받아 합계를 구한 뒤, 10.0으로 나누어 평균을 구했다.
이후 Math.round()를 사용해 반올림한 값을 출력했다

[시간복잡도]
O(N)- 테스트 케이스 만큼 반복문

[핵심 포인트]
- 평균 계산은 sum / 10 이 아니라 sum / 10.0 으로 해야 한다
- Math.round()로 반올림 처리


[피드백]
Math.round를 생각하지 못해서 처음에 틀렸었다.
Math.round의 반환형은 인자 타입에 따라 달라진다.
Math.round(float) → int
Math.round(double) → long
-> 반올림

Math.ceil() - 올림 -> double 반환
Math.floor() - 내림 -> double 반환

*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2071 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i =1; i<=T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum =0;
            for(int j = 0; j<10; j++){
                sum += Integer.parseInt(st.nextToken());
            }
            System.out.printf("#%d %d\n",i,Math.round(sum/10.0));
        }
    }
}
