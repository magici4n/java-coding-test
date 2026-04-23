/*
[문제]
SWEA 1206 - View

[분류]
구현 / 배열

[접근]
각 건물을 기준으로 왼쪽 2칸, 오른쪽 2칸의 건물 높이를 비교했다.
주변 4개 건물 중 가장 높은 건물보다 현재 건물이 더 높을 때만 그 차이만큼 조망권 세대를 더하는 방식으로 풀이했다.

[시간복잡도]
O(N)

[핵심 포인트]
- 양쪽 2칸씩, 총 4칸을 비교해야 함
- 현재 건물이 주변 4개 건물보다 모두 높아야 조망권이 생김
- 조망권 세대 수는 현재 높이 - 주변 최대 높이
- 맨 앞 2칸, 맨 뒤 2칸은 검사 대상이 아님
- 불가능한 경우는 바로 continue로 넘겨도 됨

[피드백]
d3치고는 쉬운 문제였다 (d2보다 쉬운 느낌)
 조건식은 < 보다 <= 로 쓰는 것이 문제 의미를 더 직접적으로 드러낸다.
또한 building_left, building_right 보다는 leftMax, rightMax 같은 이름이 더 좋을 것 같다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1206 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc<10; tc++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] buildings = new int[N];
            for(int i = 0; i<N; i++){
                buildings[i] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            for(int j = 2; j<N-2; j++){
                int building_left = Math.max(buildings[j - 2], buildings[j - 1]);
                int building_right = Math.max(buildings[j + 2], buildings[j + 1]);
                if(buildings[j] < building_left || buildings[j]<building_right){
                    continue;
                }
                sum += buildings[j] -Math.max(building_left,building_right);
            }
            sb.append("#").append(tc+1).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
