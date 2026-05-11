/*
[문제]
SWEA 1215 - 회문1

[분류]
구현 / 문자열 / 완전탐색 / 2차원 배열

[접근]
- 8 x 8 문자 배열이 주어진다.
- 길이가 N인 회문이 가로와 세로에 몇 개 있는지 구한다.
- 가능한 모든 시작 위치를 확인한다.
- 가로 검사에서는 각 행마다 시작 열 j를 잡고 길이 N만큼 확인한다.
- 세로 검사에서는 각 열마다 시작 행 j를 잡고 길이 N만큼 확인한다.
- 회문 여부는 양끝 문자를 안쪽으로 좁혀가며 비교한다.
- 비교해야 하는 횟수는 N / 2번이다.

[시간복잡도]
- 가로 검사: 8 * (8 - N + 1) * (N / 2)
- 세로 검사: 8 * (8 - N + 1) * (N / 2)
- 전체 시간복잡도: O(8 * 8 * N)
- 배열 크기가 8 x 8로 고정되어 있으므로 사실상 상수 시간에 가깝다.

[핵심 포인트]
- 길이 N짜리 문자열의 시작 위치는 0부터 8 - N까지 가능하다.
- 가로 검사에서 왼쪽 인덱스는 j + k,
  오른쪽 인덱스는 j + N - 1 - k이다.
- 세로 검사도 같은 원리로 행 인덱스만 바꿔서 검사한다.
- k는 0부터 N / 2 전까지 증가시키면 된다.
- N이 홀수여도 가운데 문자는 비교할 필요가 없기 때문에 N / 2번만 비교하면 된다.
- SWEA 1215는 테스트케이스가 10개 고정이다.

[피드백]
- count를 사용해서 N / 2번 모두 일치했는지 확인한 방식도 가능하다.
- 다만 회문 검사는 boolean flag를 사용하면 조금 더 직관적으로 작성할 수 있다.
- 사용하지 않는 StringTokenizer import는 제거해도 된다.
*/
package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1215 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc= 0; tc < 10; tc++) {
            int N = Integer.parseInt(br.readLine());

            char [][]map = new char[8][8];
            for(int i = 0; i < 8; i++) {
                String words = br.readLine();
                for(int j = 0; j < 8; j++) {
                    map[i][j] = words.charAt(j);
                }
            }

            int result = 0;
            int count = 0;

            //가로 검사
            for(int i = 0; i< 8; i++) {
                for(int j = 0; j <=8-N; j++) {
                    count = 0;
                    for(int k = 0; k < N/2; k++) {
                        if(map[i][j+k] != map[i][j+N-1-k]) {
                            break;
                        }
                        count++;
                    }
                    if(count == N/2) {
                        result++;
                    }
                }
            }

            //세로 검사
            for(int i = 0; i< 8; i++) {
                for(int j = 0; j <=8-N; j++) {
                    count = 0;
                    for(int k = 0; k < N/2; k++) {
                        if(map[j+k][i] != map[j+N-1-k][i]) {
                            break;
                        }
                        count++;
                    }
                    if(count == N/2) {
                        result++;
                    }
                }
            }
            sb.append("#").append(tc+1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}

