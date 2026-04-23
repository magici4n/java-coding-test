/*
[문제]
SWEA 1979 - 어디에 단어가 들어갈 수 있을까

[분류]
구현 / 배열

[접근]
가로와 세로를 각각 탐색하면서 연속된 1의 길이를 구했다.
각 행과 열에서 연속 구간의 길이가 정확히 K인 경우만 정답에 더하는 방식으로 풀이했다.

[시간복잡도]
O(N^2)

[핵심 포인트]
- 가로 검사와 세로 검사를 분리해서 생각
- 연속된 1의 길이를 세다가 0을 만나면 구간 종료
- 구간이 끝날 때 길이가 K인지 확인
- 마지막 칸이 1로 끝나는 경우도 따로 확인 필요
- 이 문제는 "정확히 K칸"이어야 하므로 K보다 길면 안 됨

[피드백]
가로/세로에서 연속된 1의 길이를 세는 핵심 접근은 맞았다.
다만 길이별 개수를 저장하는 count 배열은 없어도 되고,
구간이 끝날 때마다 길이가 K인지 바로 검사하면 더 간단하게 구현할 수 있다.
또한 flag는 현재 연속 길이를 의미하므로 len 같은 이름이 더 직관적이다.
다음에는 불필요한 저장 없이, 연속 구간이 끝나는 순간 바로 처리하는 방식으로 더 단순하게 작성해보자.
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1979 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];

            for(int i = 0; i<N; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++){
                    map[i][j] = Integer.parseInt(st1.nextToken());
                }
            }
            int sum = 0;
            // 가로 검사
            for(int i =0; i<N; i++){
                int flag = 0;
                int[] count  = new int[N+1];
                for(int j = 0; j<N; j++){
                    if(map[i][j]==1){
                        if(j == N-1){
                            flag++;
                            count[flag]++;
                        }else{
                            flag++;
                        }
                    }else{
                        count[flag]++;
                        flag = 0;
                    }
                }
                sum += count[K];
            }

            // 세로 검사
            for(int i =0; i<N; i++){
                int flag = 0;
                int[] count  = new int[N+1];
                for(int j = 0; j<N; j++){

                    if(map[j][i]==1){
                        if(j == N-1){
                            flag++;
                            count[flag]++;
                        }else{
                            flag++;
                        }
                    }else{
                        count[flag]++;
                        flag = 0;
                    }
                }
                sum += count[K];
            }
            sb.append("#").append(tc+1).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }
}
