/*
[문제]
SWEA 2056 - 연월일 달력

[분류]
구현 / 문자열 / 배열

[접근]
입력받은 8자리 날짜 문자열을 substring()으로 연, 월, 일로 분리 후
조건을 적용시킨다.

[시간복잡도]
O(N)

[핵심 포인트]
문자열 자르기: substring(시작, 끝)

월별 일수 배열:
int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

[피드백]
Integer.parseInt(month)를 여러 번 반복해서 사용한 부분은 int month = Integer.parseInt(monthStr); 처럼 변수에 저장하면 깔끔.
생각보다 어렵게 느꼈던 문제였다. subString생각을 못해서 처음에는 과도한 swich문과 if-else문을 사용했으며
subString이후에도 int[] days 생각을 못해서 사실상 못 푼 문제나 다름없다.
조금 더 기초적으로 문제를 풀 생각을 해도 좋을 것 같다.
*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2056 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        for(int i =0; i<T; i++){
            String date = br.readLine();
            String year = date.substring(0,4);
            String month = date.substring(4,6);
            String day = date.substring(6);
            sb.append("#").append(i+1).append(" ");

            if(Integer.parseInt(month) <1 || Integer.parseInt(month) > 12 || Integer.parseInt(day) < 1 || Integer.parseInt(day) > days[Integer.parseInt(month)]){
                sb.append(-1).append("\n");
            }else{
                sb.append(year).append("/").append(month).append("/").append(day).append("\n");
            }
        }
        System.out.print(sb);


    }
}
