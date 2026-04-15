/*
[문제]
SWEA 2058 - 자릿수 더하기

[분류]
구현 / 수학

[접근]
입력받은 숫자 N을 10으로 나눈 나머지를 이용해 마지막 자리 숫자를 구한다.
각 자리 숫자를 sum에 더한 뒤, N을 10으로 나누며 한 자리씩 줄인다.

[시간복잡도]
O(자릿수)

[핵심 포인트]
마지막 자리 숫자 구하기:
N % 10

마지막 자리 제거하기:
N / 10

자릿수 합 기본 패턴:
while (N > 0) {
    sum += N % 10;
    N /= 10;
}

[피드백]
현재 풀이도 정답은 가능하지만
다만 while(true)와 if(N < 10)로 마지막 숫자를 따로 처리하는 방식보다,
while(N > 0) 조건을 사용하면 더 간결하고 일반적인 풀이가 된다.

앞으로 자릿수 합 문제는 N % 10, N /= 10 패턴을 기억하자.
*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2058 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        while(true){
            sum += N%10;
            N = N/10;

            if(N<10){
                sum+=N;
                break;
            }
        }
        System.out.print(sum);
    }
}
