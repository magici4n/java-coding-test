/*
[문제]
SWEA 9229 - 한빈이와 Spot Mart

[분류]
정렬 / 완전탐색 / 투 포인터

[접근]
과자 무게 배열을 오름차순 정렬한다.
각 과자 a[i]를 첫 번째 과자로 고정한 뒤,
뒤쪽에서부터 두 번째 과자를 찾아 합이 M 이하인지 확인한다.
정렬되어 있으므로 뒤에서부터 확인하다가 처음으로 M 이하가 되는 순간,
해당 i 기준 가장 큰 합이므로 Max를 갱신하고 break한다.

[시간복잡도]
정렬: O(N log N)
탐색: O(N^2)

전체: O(N^2)

[핵심 포인트]
두 과자의 합이 M 이하인 것 중 최댓값을 구해야 한다.
가능한 조합이 없으면 -1을 출력해야 하므로 max를 -1로 초기화한다.

정렬 후 j를 뒤에서부터 탐색하면,
각 i에 대해 가장 큰 가능한 조합을 먼저 찾을 수 있다.

[피드백]
풀이 로직은 맞다.
정렬을 활용했고, 조건을 만족하는 순간 break하는 것도 타당하다.
다만 변수명 Max, A는 자바 관례상 max, first처럼 소문자로 쓰는 것이 좋다.

추가로 이 문제는 투 포인터로도 풀 수 있다.
투 포인터를 사용하면 정렬 후 O(N)에 탐색할 수 있어 더 효율적이다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_9229 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int [] a = new int [N];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st1.nextToken());
            }

            Arrays.sort(a);
            int Max = -1;
            for(int i = 0; i < N-1; i++) {
                int A = a[i];
                for(int j = N-1; j >i; j--) {
                    if(A + a[j] <= M) {
                        Max = Math.max(Max, A+a[j]);
                        break;
                    }
                }
            }
            sb.append("#").append(tc+1).append(" ").append(Max).append("\n");
        }
        System.out.print(sb);
    }
}
