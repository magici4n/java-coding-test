/*
[문제]
SWEA 4836 - 색칠하기

[분류]
구현 / 2차원 배열 / 시뮬레이션 / 카운팅

[접근]
10 x 10 크기의 2차원 배열을 도화지로 사용한다.
각 칸의 상태를 숫자로 구분한다.

0: 아직 칠하지 않은 칸
1: 빨간색으로 칠한 칸
2: 파란색으로 칠한 칸
3: 빨간색과 파란색이 겹친 보라색 칸

입력으로 주어진 좌표 범위를 순회하면서 색을 칠한다.
빨간색을 칠할 때 이미 파란색이 칠해져 있으면 보라색으로 바꾸고 purple을 증가시킨다.
파란색을 칠할 때 이미 빨간색이 칠해져 있으면 보라색으로 바꾸고 purple을 증가시킨다.
이미 보라색인 칸은 다시 세지 않는다.

[시간복잡도]
O(N * 100)

색칠할 영역은 최대 10 x 10 크기이므로 한 색종이마다 최대 100칸을 확인한다.
따라서 전체 시간복잡도는 O(N * 100)이고, 100은 상수이므로 사실상 O(N)으로 볼 수 있다.

[핵심 포인트]
1. 2차원 배열을 사용해서 색칠 상태를 저장한다.
2. 좌표 범위는 r1부터 r2까지, c1부터 c2까지 모두 포함하므로 <= 조건을 사용한다.
3. 빨강은 1, 파랑은 2, 보라는 3으로 표시한다.
4. 빨강과 파랑이 겹칠 때만 purple을 증가시킨다.
5. 이미 보라색인 칸은 다시 purple에 포함시키면 안 된다.
6. 문제의 도화지 크기가 10 x 10으로 작기 때문에 직접 모든 칸을 칠해도 충분하다.

[피드백]
무식하게 풀었다고 생각했는데 무식한 풀이로 푸는 문제같다.
다만 빨강과 파랑을 처리하는 반복문이 거의 동일하게 중복되어 있으므로,
중복되는 부분을 줄이는 고민을 해보는게 좋을 것 같다.
*/
package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4836 {

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            int [][] map = new int[10][10];
            int purple =0;
            int N = Integer.parseInt(br.readLine());
            for(int k = 0; k < N; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());


                if(color == 1) {
                    for(int i = r1; i<= r2; i++) {
                        for(int j = c1; j <= c2; j++) {
                            if(map[i][j] == 0 || map[i][j] == 1) {
                                map[i][j] = 1;
                            }else if(map[i][j]== 2) {
                                map[i][j] = 3;
                                purple++;
                            }
                        }
                    }
                }else {
                    for(int i = r1; i<= r2; i++) {
                        for(int j = c1; j <= c2; j++) {
                            if(map[i][j] == 0 || map[i][j] == 2) {
                                map[i][j] = 2;
                            }else if(map[i][j]== 1) {
                                map[i][j] = 3;
                                purple++;
                            }
                        }
                    }
                }
            }
            sb.append("#").append(tc+1).append(" ").append(purple).append("\n");
        }
        System.out.print(sb);
    }
}