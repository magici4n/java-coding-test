/*
[문제]
BOJ 2750 - 수 정렬하기

[분류]
구현 / 정렬 / 배열

[접근]
N개의 수를 배열에 저장한 뒤, Arrays.sort()를 사용해 오름차순 정렬했다.

[시간복잡도]
O(N log N)
- Arrays.sort가 N log N

[핵심 포인트]
입력 개수가 정해져 있으므로 int[] 배열 사용했다.
Arrays.sort()로 오름차순 정렬했다.

[피드백]
출력이 많은 문제에서는 StringBuilder를 사용하면 좋다.
정렬 관련 개념을 정리하자.
*/

package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2750 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] numbers = new int[N];
        for(int i = 0; i<N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        for(int i =0; i<N; i++){
            System.out.println(numbers[i]);
        }

    }
}
