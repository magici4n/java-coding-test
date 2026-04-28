/*
[문제]
SWEA 1948 - 날짜 계산기

[분류]
구현 / 배열 / 날짜 계산

[접근]
각 월의 일수를 배열에 저장한다.
두 날짜가 같은 달이면 second_day - first_day + 1로 계산한다.
서로 다른 달이면 시작 월의 남은 날짜, 중간 월들의 전체 날짜,
마지막 월의 날짜를 각각 더해 총 날짜 수를 구한다.
문제에서 시작일과 종료일을 모두 포함하므로 +1 처리가 필요하다.

[시간복잡도]
O(T * 12)
각 테스트케이스마다 최대 12개월 범위 안에서 반복문을 수행한다.
월의 개수가 고정되어 있으므로 사실상 O(T)에 가깝다.

[핵심 포인트]
- 월별 일수 배열:
  int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

- 같은 달:
  result = second_day - first_day + 1;

- 다른 달:
  시작 월 남은 날짜 = day[first_month] - first_day + 1
  중간 월 전체 날짜 = day[i]
  마지막 월 날짜 = second_day

- 시작일과 종료일을 모두 포함하므로 +1을 잊지 않아야 한다.

[피드백]
쉬운 문제. 별로 크지않은 값들은 고정 배열에 넣어 사용하기.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1948 {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());


            int first_month = Integer.parseInt(st.nextToken());
            int first_day = Integer.parseInt(st.nextToken());
            int second_month = Integer.parseInt(st.nextToken());
            int second_day = Integer.parseInt(st.nextToken());

            int result = 0;

            if(first_month == second_month){
                result = second_day - first_day + 1;
            }else{
                for(int i = first_month+1; i<second_month ; i++){
                    result += day[i];
                }
                result += day[first_month] - first_day + 1;
                result += second_day;
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
