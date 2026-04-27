/*
[문제]
SWEA 1966 - 숫자를 정렬하자

[분류]
정렬 / 배열 / 구현

[접근]
각 테스트 케이스마다 N개의 숫자를 배열에 저장한 뒤,
Arrays.sort()를 사용해 오름차순으로 정렬.

[시간복잡도]
각 테스트 케이스마다 정렬에 O(N log N)이 걸린다.

전체 시간복잡도:
O(T * N log N)

[핵심 포인트]
1. 입력 개수가 N개이므로 int[] 배열을 만들어 저장한다.
2. Arrays.sort(arr)를 사용하면 기본적으로 오름차순 정렬된다.


[피드백]
쉬운 문제. 안 봐도 될 것 같다.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1966 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());
            int [] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            sb.append("#").append(tc+1).append(" ");
            for(int i = 0; i<N; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
