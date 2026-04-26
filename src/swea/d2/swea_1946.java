/*
[문제]
SWEA 1946 - 간단한 압축 풀기

[분류]
구현 / 문자열

[접근]
문자와 반복 횟수를 입력받아 해당 문자를 횟수만큼 출력했다.
출력한 문자 개수를 count로 세면서, 10개가 될 때마다 줄바꿈하도록 구현했다.

[시간복잡도]
O(전체 출력 문자 수)

[핵심 포인트]
- 문자를 하나씩 출력하면서 개수 세기
- count가 10이 되면 줄바꿈 후 0으로 초기화

[피드백]
 테스트케이스가 끝날 때 무조건 줄바꿈을 추가하면,
전체 문자 수가 10의 배수인 경우 빈 줄이 하나 더 생길 수 있다.
if (count != 0) {
    sb.append("\n");
}
이런식으로 구현했으면 좋았을 것이다.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1946 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            sb.append("#").append(tc+1).append("\n");

            int N = Integer.parseInt(br.readLine());

            int count = 0;

            for(int i =0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String ch = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                for(int j = 0; j<num; j++){
                    sb.append(ch);
                    count++;
                    if(count == 10){
                        sb.append("\n");
                        count= 0;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
