/*
[문제]
SWEA 1945 - 간단한 소인수분해

[분류]
수학 / 구현 / 소인수분해

[접근]
문제에서 주어진 소수 2, 3, 5, 7, 11을 배열에 저장한뒤
while문 사용으로 나눗셈 적용.

[시간복잡도]
시간복잡도는 대략 O(log N)으로 볼 수 있다.
전체 시간복잡도는 O(T log N)이다.

[핵심 포인트]
소수 종류 배열에 넣어서 편하게 쓰지

[피드백]
나눌 값들을 배열에 저장하는 것
-> 문제를 풀때 몇 안되는 경우의수는 고정된 배열에 넣으면 유용할 수 있다는점 참고하자.

*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1945 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int [] sosu = {2,3,5,7,11};

        for(int tc = 0; tc<T; tc++){
            sb.append("#").append(tc+1).append(" ");
            int N = Integer.parseInt(br.readLine());

            for(int i = 0; i<sosu.length; i++){
                int num = 0;

                while(N%sosu[i] == 0){
                    num++;
                    N = N/sosu[i];
                }
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
