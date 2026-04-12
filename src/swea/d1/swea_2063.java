/*
[문제]
SWEA 2063 - 중간값 찾기

[분류]
구현 / 정렬 / 배열

[접근]
br.readLine으로 입력받는 것을 반복문을 통해 ArrayList에 넣은 뒤 정렬 후
중간값 인덱스를 출력하였다.

[시간복잡도]
O(N log N)
- sort가 N log N만큼 걸림
[핵심 포인트]
인덱스는 0부터 시작하므로 N / 2 또는 (N+1)/2 - 1 로 계산 가능

[피드백]
정렬에 대한 개념을 다지는게 좋아보임.
*/

package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_2063 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        List<Integer> list = new ArrayList<>();

        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(null);
        System.out.println(list.get((N+1)/2 -1));
    }
}
