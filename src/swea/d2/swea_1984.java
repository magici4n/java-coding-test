/*
[문제]
SWEA 1984 - 중간 평균값 구하기

[분류]
구현 / 정렬 / 수학

[접근]
10개의 수를 Arraylist에 넣은뒤 정렬했다.
정렬 후 최솟값 1개와 최댓값 1개를 제거 후 평균 계산
마지막으로 Math.round()사용

[시간복잡도]
O(T * 10 log 10)
- 테스트케이스마다 숫자 10개 정렬
- 숫자 개수가 고정(10개)이라 사실상 O(T)처럼 봐도 된다.

[핵심 포인트]
- list.sort(null)로 오름차순 정렬
- 정렬 후 양끝 값 제거
- 평균 계산 시 sum / 8.0 으로 실수 연산 처리
- Math.round()로 반올림
- StringBuilder로 출력 누적

[피드백]
list.remove(8)보단  list.remove(list.size() - 1)로 쓰는 편이 더 직관적이다.


*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;
import java.util.StringTokenizer;

public class swea_1984 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j<10; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            list.sort(null);

            list.remove(0);
            list.remove(8);


            int sum = 0;

            for(int k = 0; k<8; k++){
                sum += list.get(k);
            }

            sb.append("#").append(i+1).append(" ").append(Math.round(sum/8.0)).append("\n");
        }
        System.out.print(sb);
    }
}
