/*
[문제]
SWEA 2019 - 더블더블

[분류]
구현 / 반복문 / 수학

[접근]
0부터 N까지 반복하면서 2의 거듭제곱 값을 출력한다.
내 풀이에서는 Math.pow(2, i)를 사용해 2^i 값을 구했다.

[시간복잡도]
O(N)

[핵심 포인트]
Math.pow(a, b)는 a의 b제곱을 구한다.

주의:
Math.pow()의 반환값은 double이다.
정수로 출력하려면 (int) 형변환이 필요하다.

[피드백]
이 문제처럼 2배씩 증가하는 값은
num = 1에서 시작해서 반복할 때마다 num *= 2 하는 방식이 더 자연스럽다.

int num = 1;
for (int i = 0; i <= N; i++) {
    sb.append(num);
    num *= 2;
}

앞으로 2의 거듭제곱을 순서대로 출력하는 문제에서는
Math.pow()뿐 아니라 누적 곱 방식도 떠올리자.
*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2019 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<= N; i++){
            sb.append((int)Math.pow(2,i));
            if(i != N){
                sb.append(" ");
            }
        }
        System.out.print(sb);
    }
}
