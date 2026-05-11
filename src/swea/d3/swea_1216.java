/*
[문제]
SWEA 1216 - 회문2

[분류]
구현 / 문자열 / 완전탐색 / 2차원 배열 / 회문 검사

[접근]
- 100 x 100 크기의 문자 배열이 주어진다.
- 가로 또는 세로 방향에서 만들 수 있는 회문 중 가장 긴 길이를 구한다.
- 회문의 길이 n을 1부터 100까지 바꿔가며 검사한다.
- 가로 검사:
  각 행 i에서 시작 열 j를 정하고, 길이 n짜리 문자열이 회문인지 확인한다.
- 세로 검사:
  각 열 i에서 시작 행 j를 정하고, 길이 n짜리 문자열이 회문인지 확인한다.
- 회문 여부는 양끝 문자를 안쪽으로 좁혀가며 비교한다.
- 회문이면 result와 n을 비교하여 최댓값을 갱신한다.

[시간복잡도]
- 길이 n을 1부터 100까지 검사한다.
- 각 길이마다 시작 위치를 확인하고, 최대 n / 2번 비교한다.
- 전체 시간복잡도는 대략 O(100^4)에 가깝다.
- 하지만 배열 크기가 100 x 100으로 고정되어 있어 충분히 풀이 가능하다.

[핵심 포인트]
- 길이 n짜리 회문 후보의 시작 위치는 0부터 100 - n까지 가능하다.
- 가로 검사에서 비교 인덱스는 다음과 같다.
  왼쪽: j + k
  오른쪽: j + n - 1 - k
- 세로 검사에서는 행 인덱스만 같은 방식으로 바꿔서 비교한다.
  위쪽: j + k
  아래쪽: j + n - 1 - k
- k는 0부터 n / 2 전까지 증가시키면 된다.
- n이 홀수일 때 가운데 문자는 비교할 필요가 없다.
- flag는 회문 후보 하나를 검사할 때마다 새로 true로 초기화해야 한다.

[피드백]
- 처음에는 flag가 길이 n마다 한 번만 초기화되어 논리 오류가 있었다.
- 수정 후에는 j 반복문 안에서 flag를 생성하여 각 회문 후보마다 독립적으로 검사하게 되었다.
- 다만 최장 회문 문제이므로 길이를 100부터 1까지 줄여가며 탐색하면 더 효율적으로 풀 수 있다.
- 가로/세로 회문 검사 로직이 비슷하므로, 나중에는 함수로 분리하면 코드 중복을 줄일 수 있다.
*/

package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1216 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < 10; tc++) {
            int T = Integer.parseInt(br.readLine());

            char [][]map = new char[100][100];

            for(int i = 0; i < 100; i++) {
                String nums = br.readLine();
                for(int j = 0; j < 100; j++){
                    map[i][j] = nums.charAt(j);
                }
            }
            int result = 0;


            //가로
            for(int n = 1 ; n <= 100; n++) {
                for(int i = 0; i< 100; i++) {
                    for(int j = 0; j <= 100-n; j++) {
                        boolean flag = true;
                        for(int k = 0; k< n/2; k++) {
                            if(map[i][j + k] != map[i][j+n-k-1]) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag) {
                            result = Math.max(n, result);
                            break;
                        }
                    }
                }
            }

            //세로
            for(int n = 1 ; n <= 100; n++) {
                for(int i = 0; i< 100; i++) {
                    for(int j = 0; j <= 100-n; j++) {
                        boolean flag = true;
                        for(int k = 0; k< n/2; k++) {
                            if(map[j+k][i] != map[j+n-k-1][i]) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag) {
                            result = Math.max(n, result);
                            break;
                        }
                    }
                }
            }

            sb.append("#").append(T).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
