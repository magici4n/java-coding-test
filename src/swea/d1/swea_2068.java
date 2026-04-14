/*
[문제]
SWEA 2068 - 최대수 구하기

[분류]
구현 / 배열 / 최댓값

[접근]
각 테스트케이스마다 10개의 숫자를 입력받은 후 정렬 후 제일 뒤에 값 출력

[시간복잡도]
O(T * 10log 10)
-> 정렬을 사용해서 시간 복잡도 효율이 좋지 않음 - max변수를 두고 구하는 방식이 유리

[핵심 포인트]
최댓값만 필요할 때는 정렬보다 max 변수로 갱신하는 방식이 더 적절하다.
예:
int max = Integer.MIN_VALUE;

if (num > max) {
    max = num;
}

[피드백]
시간 복잡도를 고려해서 푸는 습관도 들여보자.
*/
package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2068 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++){
            sb.append("#").append(i+1).append(" ");
            int[] nums = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<10; j++){
                nums[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums);
            sb.append(nums[9]).append("\n");
        }
        System.out.print(sb);
    }
}
