/*
 [문제]
 BOJ 10810 - 최소, 최대

 [분류]
 구현 / 배열

 [접근]
 처음에는 scanner로 접근해서 한 줄 입력을 어떻게 처리할지 고민하였는데
 BufferedReader와 StringTokenizer를 알게되면서 쉽게 처리하였다.


 [시간복잡도]
 O(N)
-O(N) 인 이유는 정수 N개를 한 번씩만 확인하기 때문.
1.숫자 하나를 꺼낸다.
2.현재 min 과 비교한다.
3.현재 max 와 비교한다.
이걸 N번 반복해
[핵심 포인트]
 StringTokenizer,BufferedReader함께 사용.

[피드백]
 StringTokenizer,BufferedReader를 잘 익혀보자.
 */

package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10810 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            if (number > max){
                max = number;
            }
            if (number < min){
                min = number;
            }
        }
        System.out.print(min + " " + max);

    }
}
