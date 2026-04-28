/*
[문제]
SWEA 1976 - 시각 덧셈

[분류]
구현 / 수학 / 조건문

[접근]
두 시각의 분을 먼저 더한 뒤, 60으로 나눈 나머지를 최종 분으로 사용한다.
분의 합이 60 이상이면 몫을 시간에 더해 올림 처리를 한다.
시간은 12시간제이므로 전체 시간 합을 12로 나눈 나머지로 변환한다.
단, 12시간제에서는 0시가 아니라 12시로 표현해야 하므로,
나머지가 0이면 12로 바꿔 출력한다.

[시간복잡도]
O(T)
각 테스트케이스마다 단순 덧셈, 나머지 연산, 조건문만 수행한다.

[핵심 포인트]
- 분 계산:
  int answer_minute = (A_minute + B_minute) % 60;

- 분에서 시간으로 넘어가는 값:
  (A_minute + B_minute) / 60

- 시간 계산:
  int answer_hour = (A_hour + B_hour + (A_minute + B_minute) / 60) % 12;

- 12시간제 보정:
  if (answer_hour == 0) {
      answer_hour = 12;
  }

[피드백]
12시간제라고 해서 0~12시간을 생각해서 풀면 틀리는 문제.
조건을 잘 보고 풀자.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1976 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A_hour = Integer.parseInt(st.nextToken());
            int A_minute = Integer.parseInt(st.nextToken());
            int B_hour = Integer.parseInt(st.nextToken());
            int B_minute = Integer.parseInt(st.nextToken());

            int answer_minute = (A_minute + B_minute) % 60;
            int answer_hour = (A_hour + B_hour + (A_minute + B_minute) / 60)%12;
            if (answer_hour == 0){
                answer_hour = 12;
            }

            sb.append("#").append(tc+1).append(" ").append(answer_hour).append(" ").append(answer_minute).append("\n");
        }
        System.out.print(sb);
    }
}
