/*
[문제]
SWEA 1208 - Flatten

[분류]
구현 / 정렬 / 시뮬레이션

[접근]
박스 높이 배열을 정렬하면 가장 낮은 박스는 box[0],
가장 높은 박스는 box[99]가 된다.

덤프 1회마다 가장 높은 박스에서 1을 빼고,
가장 낮은 박스에 1을 더한다.

이후 다시 정렬하여 새로운 최솟값과 최댓값을 갱신한다.
덤프 횟수를 모두 사용하거나, 최댓값과 최솟값의 차이가 1 이하가 되면 반복을 종료한다.

[시간복잡도]
박스 개수는 100개이고, 덤프 횟수를 D라고 하면
매 덤프마다 정렬하므로 O(D * 100 log 100)이다.
박스 개수가 고정되어 있으므로 충분히 빠르다.

[핵심 포인트]
1. Arrays.sort(box)를 하면 box[0]은 최솟값, box[99]는 최댓값이 된다.
2. 덤프 한 번은 최댓값 -1, 최솟값 +1이다.
3. 값을 바꾼 뒤 다시 정렬해야 다음 최솟값과 최댓값을 알 수 있다.
4. 최댓값과 최솟값의 차이가 0 또는 1이면 더 이상 의미 있게 줄어들지 않는다.

[피드백]
문제를 이런식으로 푼다면 좋은 문제인가? 싶다.
d3치고는 이 방식으로 풀면 쉬운 문제 같다.

*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1208 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc<10; tc++){
            int dump = Integer.parseInt(br.readLine());

            int [] box = new int[100];

            int result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0 ; i < 100; i++){
                box[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(box);

            for(int i = 0; i < dump; i++){
                if(box[0]==box[99]){
                    break;
                }
                box[99] -= 1;
                box[0] += 1;
                Arrays.sort(box);

            }
            result = box[99] - box[0];
            sb.append("#").append(tc+1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
