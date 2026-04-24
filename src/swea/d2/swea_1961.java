/*
[문제]
SWEA 1961 - 숫자 배열 회전

[분류]
구현 / 배열

[접근]
원본 배열을 90도, 180도, 270도 회전한 결과를 각각 구해서 출력했다.
회전 결과를 별도의 배열에 저장하지 않고, 인덱스 규칙을 이용해 바로 StringBuilder에 붙이는 방식으로 풀이했다.

[시간복잡도]
O(N^2)

[핵심 포인트]
- 90도 회전: result[i][j] = map[N - 1 - j][i]
- 180도 회전: result[i][j] = map[N - 1 - i][N - 1 - j]
- 270도 회전: result[i][j] = map[j][N - 1 - i]
- 각 줄마다 90도, 180도, 270도 결과를 공백으로 구분해서 출력
- 별도 배열 없이 바로 출력

[피드백]
나름 잘 푼것 같아서 뿌듯한 문제
*/

package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1961 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            sb.append("#").append(tc+1).append("\n");
            int N = Integer.parseInt(br.readLine());
            int [][]map = new int[N][N];

            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j =0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i =0; i<N; i++){
                //90도
                for(int j = 0; j<N; j++){
                    sb.append(map[N-1-j][i]);
                }
                sb.append(" ");
                //180도
                for(int j = 0; j<N; j++){
                    sb.append(map[N-1-i][N-1-j]);
                }
                sb.append(" ");
                //270도
                for(int j = 0; j<N; j++){
                    sb.append(map[j][N-1-i]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}