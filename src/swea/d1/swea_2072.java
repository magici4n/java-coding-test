/*
[문제]
BOJ 2072 - 홀수만 더하기

[분류]
구현 / 반복문 / 조건문

[접근]
StringTokenizer로 숫자를 분리해서 순서대로 처리했다.

[시간복잡도]
O(N) - 테스트 케이스 개수

[핵심 포인트]
st로 받은 값들의 개수를 모르고 하나씩 받아서 전부 사용하고 싶을때
while(st.hasMoreTokens()){}를 사용하면 된다.

[피드백]
사실 st.hasMoreTokens()를 안 사용해도 되는 문제(입력 10개 고정)였는데 문제를 꼼꼼히 안 읽었다.
*/
package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2072 {
    public static void main(String [] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i<=T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 != 0){
                    sum+= num;
                }
            }
            System.out.printf("#%d %d\n",i,sum);
        }
    }
}
