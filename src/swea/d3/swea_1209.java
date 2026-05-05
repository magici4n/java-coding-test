/*
[문제]
SWEA 1209 – Sum

[분류]
구현 / 배열 / 2차원 배열 / 완전탐색

[접근]
100 x 100 배열을 입력받고,
각 행의 합, 각 열의 합, 두 대각선의 합을 모두 구한다.
그중 가장 큰 값을 max에 저장해서 출력한다.

[시간복잡도]
O(100 * 100)

행 검사에서 100 x 100,
열 검사에서 100 x 100,
대각선 검사는 각각 100번씩 수행한다.
배열 크기가 100으로 고정되어 있으므로 실제로는 상수 시간에 가깝지만,
일반적으로 보면 O(N^2) 방식이다.

[핵심 포인트]
행 검사:
sum += map[i][j];

열 검사:
sum += map[j][i];

왼쪽 위 → 오른쪽 아래 대각선:
sum += map[i][i];

오른쪽 위 → 왼쪽 아래 대각선:
sum += map[i][99 - i];

반대 대각선을 구할 때는 행이 증가하면 열은 감소해야 한다.
즉, i가 0, 1, 2, ... 증가할 때 열은 99, 98, 97, ... 이 되어야 한다.

[피드백]
전체적인 풀이 방향은 맞았다.
행 검사와 열 검사는 정확하게 구현했고,
입력 처리도 BufferedReader, StringTokenizer, StringBuilder를 잘 사용했다.

처음 코드에서 실수한 부분은 두 번째 대각선 검사였다.

for(int i = 99; i >= 0; i--){
    sum += map[i][i];
}

이 코드는 반대 대각선이 아니라
map[99][99], map[98][98], ..., map[0][0]을 더하는 코드이므로
첫 번째 대각선을 거꾸로 더한 것과 같다.

반대 대각선은 다음처럼 작성해야 한다.

for(int i = 0; i < 100; i++){
    sum += map[i][99 - i];
}

이번 문제에서 기억할 점은 2차원 배열의 대각선 인덱스 처리이다.
왼쪽 위에서 오른쪽 아래는 [i][i],
오른쪽 위에서 왼쪽 아래는 [i][N - 1 - i] 형태로 접근한다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1209 {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 10; tc++){
            int [][]map = new int[100][100];
            int N = Integer.parseInt(br.readLine());

            for(int i = 0;  i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j<100; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Integer.MIN_VALUE;
            int sum;

            //행 검사
            for(int i = 0; i<100; i++){
                sum = 0;
                for(int j = 0; j<100; j++){
                    sum+=map[i][j];
                }
                max = Math.max(sum,max);
            }
            //열 검사
            for(int i = 0; i<100; i++){
                sum = 0;
                for(int j = 0; j<100; j++){
                    sum+=map[j][i];
                }
                max = Math.max(sum,max);
            }
            sum = 0;
            //대각선 검사(1)
            for(int i = 0; i<100; i++){
               sum += map[i][i];
            }
            max = Math.max(sum,max);
            sum = 0;
            for(int i=0; i<100; i++){
                sum += map[i][99-i];
            }
            max = Math.max(sum,max);
            sb.append("#").append(N).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}
