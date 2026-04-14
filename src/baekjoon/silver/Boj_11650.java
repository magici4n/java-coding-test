/*
[문제]
BOJ 11650 - 좌표 정렬하기

[분류]
구현 / 정렬 / 2차원 배열

[접근]
좌표를 2차원 배열로 넣음.
조건에 맞는 Comparator작성

[시간복잡도]
O(N log N)
- 정렬이 O(N log N) 걸리기때문

[핵심 포인트]
2차원 배열도 Arrays.sort()와 람다식을 이용해 정렬 가능.


[피드백]
Comparator와 람다식을 좀 더 익혀야 할 필요가 있을 것 같다.
비교식에서 a-b 방식도 가능하지만 Integer.compare()를 쓰면 더 안전하다
*/

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11650 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][] nums = new int[N][2];

        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(nums,(a,b)->{
            if(a[0]==b[0]){
                return a[1] - b[1];
            }
                return a[0] - b[0];
        });

        for(int i = 0; i< N; i++){
            System.out.print(nums[i][0] + " " + nums[i][1] +"\n");
        }
    }
}
